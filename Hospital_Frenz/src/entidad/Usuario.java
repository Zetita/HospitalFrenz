package entidad;

public class Usuario {
	private String Usuario;
	private String Email;
	private int DNI;
	private String Contrasenia;
	private String Tipo;
	private boolean Estado;
	
	public Usuario() {
		super();
	}

	public Usuario(String usuario, String email, int dNI, String contrasenia, String tipo, boolean estado) {
		super();
		Usuario = usuario;
		Email = email;
		DNI = dNI;
		Contrasenia = contrasenia;
		Tipo = tipo;
		Estado = estado;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

	@Override
	public String toString() {
		return "Usuarios [Usuario=" + Usuario + ", Email=" + Email + ", DNI=" + DNI + ", Contrasenia=" + Contrasenia
				+ ", Tipo=" + Tipo + ", Estado= " + Estado+"]";
	}
	
	
}
