package cu.desoft.gtm.sigeml.comun.domain;

public class Mensajes extends EntidadPersistente {
	private String asunto;
	private String mensaje;
	
	//private Usuario usuarioRemitente;
	//private Usuario usuarioDestinatario;
	private Nomenclador estado;
	
	public Mensajes() {
		super();
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/*public Usuario getUsuarioRemitente() {
		return usuarioRemitente;
	}

	public void setUsuarioRemitente(Usuario usuarioRemitente) {
		this.usuarioRemitente = usuarioRemitente;
	}

	public Usuario getUsuarioDestinatario() {
		return usuarioDestinatario;
	}

	public void setUsuarioDestinatario(Usuario usuarioDestinatario) {
		this.usuarioDestinatario = usuarioDestinatario;
	}*/

	public Nomenclador getEstado() {
		return estado;
	}

	public void setEstado(Nomenclador estado) {
		this.estado = estado;
	}
}
