package entidad;

public class Medico {

	private String dni;
	private String matricula;
	private String nombre;
	private String apellido;
	private String direccion;
	private Localidad localidad;
	private String telefono;
	private int estado;
	
	public Medico() {
		
	}

	public Medico(String dni, String matricula, String nombre, String apellido, String direccion, Localidad localidad, 
			String telefono, int estado) {
		super();
		this.dni = dni;
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.localidad = localidad;
		this.telefono = telefono;
		this.estado = estado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Medico [dni=" + dni + ", matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", direccion=" + direccion + ", Localidad=" + localidad.getNombre() + ", Provincia=" + 
				localidad.getProvincia().getNombre()+ ", telefono=" + telefono + ", estado=" + estado + "]";
	}
	
}
