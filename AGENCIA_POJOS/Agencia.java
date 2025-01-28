package reto2_Agencia_pojos;

import java.util.Objects;

public class Agencia {
	private String nombre=null;
	private String color=null;
	private String idAgencia=null;
	private String logo=null;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, idAgencia, logo, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		return Objects.equals(color, other.color) && Objects.equals(idAgencia, other.idAgencia)
				&& Objects.equals(logo, other.logo) && Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return  nombre + ", " + color + "," + idAgencia + "," + logo ;
	}
	
	

	

}
