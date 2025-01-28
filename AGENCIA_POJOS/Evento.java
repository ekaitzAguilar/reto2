package reto2Pojos;

import java.util.Objects;


public class Evento {

	private String nombreEvento;
	private String tipoEvento;
	public String getNombreEvento() {
		return nombreEvento;
	}
	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombreEvento, tipoEvento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(nombreEvento, other.nombreEvento) && Objects.equals(tipoEvento, other.tipoEvento);
	}
	@Override
	public String toString() {
		return nombreEvento + ", " + tipoEvento ;
	}

	
	
	

}
