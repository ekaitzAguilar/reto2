package reto2Pojos;

import java.util.Objects;

public class Alojamiento {
	
	private String codHotel=null;
	private String ciudad=null;
	private String fechaAlojamiento=null;
	private String precioAlojamiento=null;
	private String idEvento=null;
	@Override
	public String toString() {
		return codHotel + ", " + ciudad + ", " + fechaAlojamiento
				+ ", p" + precioAlojamiento + ", " + idEvento ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ciudad, codHotel, fechaAlojamiento, idEvento, precioAlojamiento);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alojamiento other = (Alojamiento) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(codHotel, other.codHotel)
				&& Objects.equals(fechaAlojamiento, other.fechaAlojamiento) && Objects.equals(idEvento, other.idEvento)
				&& Objects.equals(precioAlojamiento, other.precioAlojamiento);
	}
	public String getCodHotel() {
		return codHotel;
	}
	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getFechaAlojamiento() {
		return fechaAlojamiento;
	}
	public void setFechaAlojamiento(String fechaAlojamiento) {
		this.fechaAlojamiento = fechaAlojamiento;
	}
	public String getPrecioAlojamiento() {
		return precioAlojamiento;
	}
	public void setPrecioAlojamiento(String precioAlojamiento) {
		this.precioAlojamiento = precioAlojamiento;
	}
	public String getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

}
