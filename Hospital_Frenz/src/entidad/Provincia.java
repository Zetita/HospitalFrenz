package entidad;

public class Provincia {
	
	private int id;
	private String nombre;
	private String codigo31662;
	
	public Provincia() {
		
	}

	public Provincia(int id, String nombre, String codigo31662) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo31662 = codigo31662;
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

	public String getCodigo31662() {
		return codigo31662;
	}

	public void setCodigo31662(String codigo31662) {
		this.codigo31662 = codigo31662;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", codigo31662=" + codigo31662 + "]";
	}
	
}
