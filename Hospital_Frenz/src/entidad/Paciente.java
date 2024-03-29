package entidad;

public class Paciente {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String fecha;
	private String telefono;
	private String  direccion;
	private Localidad localidad;
	private Cobertura cobertura;
	private int estado;
	
	public Paciente()
	{
		dni=" ";
	}
	public Paciente(String dni, String nombre, String apellido, String fecha, String telefono, String direccion,
			Localidad localidad, Cobertura cobertura, int estado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
		this.telefono = telefono;
		this.direccion = direccion;
		this.localidad = localidad;
		this.cobertura = cobertura;
		this.estado = estado;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	public Cobertura getCobertura() {
		return cobertura;
	}
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha=" + fecha
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", Provincia=" + localidad.getProvincia().getNombre()
				+ ", Localidad=" + localidad.getNombre() + ", Cobertura=" + cobertura.getNombre() + ", estado=" + estado + "]";
	}

	
}
