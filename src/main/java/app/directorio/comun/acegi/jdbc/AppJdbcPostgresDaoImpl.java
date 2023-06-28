package app.directorio.comun.acegi.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.context.ApplicationContextException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import app.directorio.comun.acegi.temp.AppUser;

/***
 * 
 * @author Enrique Jose Altuna Castillo
 * 
 */
public class AppJdbcPostgresDaoImpl extends JdbcDaoSupport implements UserDetailsService {
	// ~ Static fields/initializers
	// =====================================================================================

	public static final String DEF_USERS_BY_USERNAME_QUERY = "select usuario,password from public.usuarios where usuarios.usuario = ?";
	public static final String DEF_AUTHORITIES_BY_USERNAME_DIRECT_QUERY = "select distinct permiso.nombre from public.usuarios, public.perfil, public.perfilpermiso, public.permiso, public.usuariosperfil where perfil.idperfil = perfilpermiso.idperfil and permiso.idpermiso = perfilpermiso.idpermiso and usuarios.idusuario = usuariosperfil.idusuario and perfil.idperfil = usuariosperfil.idperfil and usuarios.usuario = ?";
	public static final String DEF_AUTHORITIES_BY_USERNAME_LARGE_QUERY = "select distinct permiso.nombre from public.usuarios, public.permiso, public.usuariospermiso where usuarios.idusuario = usuariospermiso.idusuario and permiso.idpermiso = usuariospermiso.idpermiso and usuarios.usuario = ?";
	// ~ Instance fields
	// ================================================================================================

	private String rolePrefix = "";
	private boolean usernameBasedPrimaryKey = true;

	// ~ Constructors
	// ===================================================================================================

	public AppJdbcPostgresDaoImpl() {

	}

	// ~ Methods
	// ========================================================================================================

	/**
	 * Allows subclasses to add their own granted authorities to the list to be returned in the
	 * <code>User</code>.
	 * 
	 * @param username
	 *            the username, for use by finder methods
	 * @param authorities
	 *            the current granted authorities, as populated from the
	 *            <code>authoritiesByUsername</code> mapping
	 */
	protected void addCustomAuthorities(String username, List<?> authorities) {}

	public String getRolePrefix() {
		return rolePrefix;
	}

	@Override
	protected void initDao() throws ApplicationContextException {
		initMappingSqlQueries();
	}

	/**
	 * Extension point to allow other MappingSqlQuery objects to be substituted in a subclass
	 */
	protected void initMappingSqlQueries() {
	// this.authoritiesByUsernameMapping = new AuthoritiesByUsernameMapping(getDataSource());
	}

	public boolean isUsernameBasedPrimaryKey() {
		return usernameBasedPrimaryKey;
	}

	public UserDetails getEmptyUserByUserName(String username) throws UsernameNotFoundException {
		PreparedStatement sentencia = null;
		ResultSet resultado;
		Connection coneccion = null;

		if (username == null || username.equals("")) {
			throw new UsernameNotFoundException("El usuario no puede estar en blanco");
		}

		try {
			coneccion = getDataSource().getConnection();
			sentencia = coneccion.prepareStatement(DEF_USERS_BY_USERNAME_QUERY);
			sentencia.setString(1, username);
			resultado = sentencia.executeQuery();
			if (resultado.next() != true) {
				sentencia.close();
				coneccion.close();
				throw new UsernameNotFoundException("No se encontro ningun usuario");
			}
			String DBuserName = resultado.getString(1);
			if (!username.equalsIgnoreCase(DBuserName)) {
				sentencia.close();
				coneccion.close();
				throw new UsernameNotFoundException("Intento de SQL Injection");
			}
			String password = resultado.getString(2);
			
			UserDetails usuarioRetorno = new AppUser(DBuserName, password, true, null, 1, true, true, true, new GrantedAuthority[] { new GrantedAuthorityImpl("HOLDER") });

			sentencia.close();
			coneccion.close();
			return usuarioRetorno;
		} catch (SQLException e) {
			try {
				sentencia.close();
			} catch (Exception excepcion3) {}
			try {
				coneccion.close();
			} catch (Exception excepcion3) {}
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

	public List<GrantedAuthorityImpl> getAuthoritiesByUsername(String username) {
		List<GrantedAuthorityImpl> listaRetorno = new LinkedList<GrantedAuthorityImpl>();

		PreparedStatement sentenciaDirecta = null;
		PreparedStatement sentenciaLarga = null;

		ResultSet resultadoDirecto;
		ResultSet resultadoLargo;

		Connection coneccion = null;

		try {
			coneccion = getDataSource().getConnection();

			sentenciaDirecta = coneccion.prepareStatement(DEF_AUTHORITIES_BY_USERNAME_DIRECT_QUERY);
			sentenciaDirecta.setString(1, username);
			resultadoDirecto = sentenciaDirecta.executeQuery();
			while (resultadoDirecto.next()) {
				String permiso = resultadoDirecto.getString(1);
				GrantedAuthorityImpl authority = new GrantedAuthorityImpl(permiso);
				listaRetorno.add(authority);
			}

			sentenciaDirecta.close();

			/*sentenciaLarga = coneccion.prepareStatement(DEF_AUTHORITIES_BY_USERNAME_LARGE_QUERY);
			sentenciaLarga.setString(1, username);
			resultadoLargo = sentenciaLarga.executeQuery();
			while (resultadoLargo.next()) {
				String permiso = resultadoLargo.getString(1);
				boolean esta = false;
				for (GrantedAuthorityImpl impl : listaRetorno) {
					if (impl.getAuthority().equalsIgnoreCase(permiso)) {
						esta = true;
						break;
					}
				}
				if (!esta) {
					GrantedAuthorityImpl authority = new GrantedAuthorityImpl(permiso);
					listaRetorno.add(authority);
				}
			}
			sentenciaLarga.close();*/

			coneccion.close();

			return listaRetorno;
		} catch (SQLException e) {
			try {
				sentenciaDirecta.close();
			} catch (Exception excepcion3) {}
			try {
				sentenciaLarga.close();
			} catch (Exception excepcion3) {}
			try {
				coneccion.close();
			} catch (Exception excepcion3) {}

			throw new UsernameNotFoundException(e.getMessage());
		}

	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserDetails user = getEmptyUserByUserName(username); // contains no GrantedAuthority[]

		List<GrantedAuthorityImpl> dbAuths = getAuthoritiesByUsername(user.getUsername());

		addCustomAuthorities(user.getUsername(), dbAuths);

		if (dbAuths.size() == 0) {
			throw new UsernameNotFoundException("El usuario no tiene permisos asignados");
		}

		GrantedAuthority[] arrayAuths = dbAuths.toArray(new GrantedAuthority[dbAuths.size()]);

		String returnUsername = user.getUsername();
		Object huellaCode = ((AppUser) user).getHuellaCode();

		if (!usernameBasedPrimaryKey) {
			returnUsername = username;
		}

		return new AppUser(returnUsername, user.getPassword(), user.isEnabled(), huellaCode, 1, true, true, true, arrayAuths);
	}

	/**
	 * Allows a default role prefix to be specified. If this is set to a non-empty value, then it is
	 * automatically prepended to any roles read in from the db. This may for example be used to add
	 * the <code>ROLE_</code> prefix expected to exist in role names (by default) by some other
	 * Acegi Security framework classes, in the case that the prefix is not already present in the
	 * db.
	 * 
	 * @param rolePrefix
	 *            the new prefix
	 */
	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}

	/**
	 * If <code>true</code> (the default), indicates the {@link #getUsersByUsernameQuery()} returns
	 * a username in response to a query. If <code>false</code>, indicates that a primary key is
	 * used instead. If set to <code>true</code>, the class will use the database-derived username
	 * in the returned <code>UserDetails</code>. If <code>false</code>, the class will use the
	 * {@link #loadUserByUsername(String)} derived username in the returned <code>UserDetails</code>
	 * .
	 * 
	 * @param usernameBasedPrimaryKey
	 *            <code>true</code> if the mapping queries return the username <code>String</code>,
	 *            or <code>false</code> if the mapping returns a database primary key.
	 */
	public void setUsernameBasedPrimaryKey(boolean usernameBasedPrimaryKey) {
		this.usernameBasedPrimaryKey = usernameBasedPrimaryKey;
	}
}
