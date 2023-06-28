package app.directorio.comun.acegi.temp;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.User;

public class AppUser extends User {

	private static final long serialVersionUID = -1837867212630361615L;

	Object huellaCode;

	int tipoLogueo;

	public AppUser(String username, String password, boolean enabled, Object huella, int tipoLogin, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities) throws IllegalArgumentException {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.huellaCode = huella;
		this.tipoLogueo = tipoLogin;
	}

	public Object getHuellaCode() {
		return huellaCode;
	}

	public int getTipoLogueo() {
		return tipoLogueo;
	}
}

