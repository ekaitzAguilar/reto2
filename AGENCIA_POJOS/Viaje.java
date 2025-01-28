package reto2_Agencia_pojos;

import java.util.Objects;

public class Viaje {
	
	private String nombreViaje=null;
	private String tipoViaje=null;
	private String fechaIni=null;
	private String fechaFin=null;
	private String numDias=null;
	private String pais=null;
	private String descripcion=null;
	private String servNoInclu=null;

	
	@Override
	public String toString() {
		return nombreViaje + ", " + tipoViaje + ", " + fechaIni + ", "
				+ fechaFin + ", " + numDias + ", " + pais + ", " + descripcion
				+ ", " + servNoInclu + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(descripcion, fechaFin, fechaIni, nombreViaje, numDias, pais, servNoInclu, tipoViaje);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viaje other = (Viaje) obj;
		return Objects.equals(descripcion, other.descripcion) && Objects.equals(fechaFin, other.fechaFin)
				&& Objects.equals(fechaIni, other.fechaIni) && Objects.equals(nombreViaje, other.nombreViaje)
				&& Objects.equals(numDias, other.numDias) && Objects.equals(pais, other.pais)
				&& Objects.equals(servNoInclu, other.servNoInclu) && Objects.equals(tipoViaje, other.tipoViaje);
	}
	public String getNombre() {
		return nombreViaje;
	}
	public void setNombre(String nombre) {
		this.nombreViaje = nombre;
	}
	public String getTipoViaje() {
		return tipoViaje;
	}
	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getNumDias() {
		return numDias;
	}
	public void setNumDias(String numDias) {
		this.numDias = numDias;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getServNoInclu() {
		return servNoInclu;
	}
	public void setServNoInclu(String servNoInclu) {
		this.servNoInclu = servNoInclu;
	}
		

}
