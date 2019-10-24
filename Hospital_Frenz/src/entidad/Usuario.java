package entidad;

public class Usuario {
	private String Usuario;
	private String Email;
	private int DNI;
	private String Contrasenia;
	private boolean Admin;
	private boolean Tipo;
	
	public Usuario() {
		super();
	}

	public Usuario(String usuario, String email, int dNI, String contrasenia, boolean admin, boolean tipo) {
		super();
		Usuario = usuario;
		Email = email;
		DNI = dNI;
		Contrasenia = contrasenia;
		Admin = admin;
		Tipo = tipo;
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

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public boolean isTipo() {
		return Tipo;
	}

	public void setTipo(boolean tipo) {
		Tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuarios [Usuario=" + Usuario + ", Email=" + Email + ", DNI=" + DNI + ", Contrasenia=" + Contrasenia
				+ ", Admin=" + Admin + ", Tipo=" + Tipo + "]";
	}
	
	
}
