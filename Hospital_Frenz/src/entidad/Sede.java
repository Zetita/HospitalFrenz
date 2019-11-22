package entidad;

public class Sede {
	private int id;
	private String nombre;
	private String direccion;
	private Localidad localidad;
	private int estado;
	
	public Sede() {
		
	}

	public Sede(int id, String nombre, String direccion, Localidad localidad, int estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Sede [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", provincia=" + localidad.getProvincia().getNombre()
				+ ", localidad=" + localidad.getNombre() + ", estado=" + estado + "]";
	}
	
}
