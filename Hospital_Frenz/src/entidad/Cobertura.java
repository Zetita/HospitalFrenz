package entidad;

public class Cobertura {
	
	private int idCobertura;
	private String nombre;
	private String tipo;
	
	public Cobertura()
	{
		
	}

	public Cobertura(int idCobertura, String nombre, String tipo) {
		super();
		this.idCobertura = idCobertura;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getIdCobertura() {
		return idCobertura;
	}

	public void setIdCobertura(int idCobertura) {
		this.idCobertura = idCobertura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cobertura [idCobertura=" + idCobertura + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
}