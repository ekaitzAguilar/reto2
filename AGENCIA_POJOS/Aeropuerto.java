package reto2_Agencia_pojos;

import java.util.Objects;

public class Aeropuerto {
	
	private String codAeropuerto =null;
	private String ciudad = null;
	public String getCodAeropuerto() {
		return codAeropuerto;
	}
	public void setCodAeropuerto(String codAeropuerto) {
		this.codAeropuerto = codAeropuerto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ciudad, codAeropuerto);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeropuerto other = (Aeropuerto) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(codAeropuerto, other.codAeropuerto);
	}
	@Override
	public String toString() {
		return   codAeropuerto + ","  + ciudad;
	}
	
}
