package entidad;

public class Paciente {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String fecha;
	private int telefono;
	private String  direccion;
	private Provincia provincia;
	private Localidad localidad;
	private Cobertura cobertura;
	private boolean estado;
	
	public Paciente()
	{
		
	}
	public Paciente(int dni, String nombre, String apellido, String fecha, int telefono, String direccion,
			Provincia provincia, Localidad localidad, Cobertura cobertura, boolean estado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
		this.telefono = telefono;
		this.direccion = direccion;
		this.provincia = provincia;
		this.localidad = localidad;
		this.cobertura = cobertura;
		this.estado = estado;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
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
	public Cobertura getCobertura() {
		return cobertura;
	}
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Paciente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha=" + fecha
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", Provincia=" + provincia.getNombre()
				+ ", Localidad=" + localidad.getNombre() + ", Cobertura=" + cobertura.getNombre() + ", estado=" + estado + "]";
	}

	
}
