package reto2Pojos;

import java.util.Objects;

public class Actividad {
	
	public String codActividad=null;

	public String descActividad=null;
	public String fechaActividad=null;
	public String precioActividad=null;
	public String idEvento=null;
	
	public String getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}
	
	public String getCodActividad() {
		return codActividad;
	}
	public void setCodActividad(String codActividad) {
		this.codActividad = codActividad;
	}
	public String getDescActividad() {
		return descActividad;
	}
	public void setDescActividad(String descActividad) {
		this.descActividad = descActividad;
	}
	public String getFechaActividad() {
		return fechaActividad;
	}
	public void setFechaActividad(String fechaActividad) {
		this.fechaActividad = fechaActividad;
	}
	public String getPrecioActividad() {
		return precioActividad;
	}
	public void setPrecioActividad(String precioActividad) {
		this.precioActividad = precioActividad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codActividad, descActividad, fechaActividad, idEvento, precioActividad);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		return Objects.equals(codActividad, other.codActividad) && Objects.equals(descActividad, other.descActividad)
				&& Objects.equals(fechaActividad, other.fechaActividad) && Objects.equals(idEvento, other.idEvento)
				&& Objects.equals(precioActividad, other.precioActividad);
	}
	@Override
	public String toString() {
		return  codActividad + ", " + descActividad + ", "
				+ fechaActividad + ", " + precioActividad + ", " + idEvento ;
	}
	
	

}
