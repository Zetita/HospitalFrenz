package entidad;

import entidad.Medico;
import entidad.Cobertura;

public class CoberturasPorMedicos {
		
	private Medico med;
	private Cobertura cob;
	private int estado;
	
	public Medico getMed() {
		return med;
	}




	public void setMed(Medico med) {
		this.med = med;
	}




	public Cobertura getCob() {
		return cob;
	}




	public void setCob(Cobertura cob) {
		this.cob = cob;
	}




	public int getEstado() {
		return estado;
	}




	public void setEstado(int estado) {
		this.estado = estado;
	}




	@Override
	public String toString() {
		return "CoberturasPorMedicos [med=" + med.getMatricula() + ", cob=" + cob.getIdCobertura() + ", estado=" + estado + "]";
	}
	
	
	
}
