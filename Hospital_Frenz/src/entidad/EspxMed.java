package entidad;

public class EspxMed {
	
	private String MatriculaMed;
	private int IDEsp;
	private int estado;
	
	public EspxMed() {
		
	}

	public EspxMed(String matriculaMed, int iDEsp, int estado) {
		super();
		MatriculaMed = matriculaMed;
		IDEsp = iDEsp;
		this.estado = estado;
	}

	public String getMatriculaMed() {
		return MatriculaMed;
	}

	public void setMatriculaMed(String matriculaMed) {
		MatriculaMed = matriculaMed;
	}

	public int getIDEsp() {
		return IDEsp;
	}

	public void setIDEsp(int iDEsp) {
		IDEsp = iDEsp;
	}

	public int isEstado() {
		return estado;
	}

	public void setEstado(int i) {
		this.estado = i;
	}

	@Override
	public String toString() {
		return "EspxMed [MatriculaMed=" + MatriculaMed + ", IDEsp=" + IDEsp + ", estado=" + estado + "]";
	}

	
	
}