package entidad;

public class Localidad {
	
	private int id;
	private Provincia provincia;
	private String nombre;
	private int cp;
	
	public Localidad() {
		
	}

	public Localidad(int id, Provincia provincia, String nombre, int cp) {
		super();
		this.id = id;
		this.provincia = provincia;
		this.nombre = nombre;
		this.cp = cp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Localidad [id=" + id + ", provincia=" + provincia + ", nombre=" + nombre + ", cp=" + cp + "]";
	}
	
}
