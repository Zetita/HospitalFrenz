package entidad;

public class Medico {

	private int dni;
	private int matricula;
	private String nombre;
	private String apellido;
	private String direccion;
	private Provincia provincia;
	private Localidad localidad;
	private int telefono;
	private int estado;
	
	public Medico() {
		
	}

	public Medico(int dni, int matricula, String nombre, String apellido, String direccion, Localidad localidad,
			Provincia provincia, int telefono, int estado) {
		super();
		this.dni = dni;
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.estado = estado;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
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

	public Provincia getProvincia() {
		return provincia;
	}
	public void setIdProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
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
				+ ", direccion=" + direccion + ", idLocalidad=" + localidad.getId() + ", idProvincia=" + provincia.getId()
				+ ", telefono=" + telefono + ", estado=" + estado + "]";
	}
	
}
