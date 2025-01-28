package reto2Pojos;

import java.util.Objects;

public class Pais {
	
	private String codPais=null;
	private String nombrePais=null;
	@Override
	public String toString() {
		return  codPais + ", " + nombrePais ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codPais, nombrePais);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(codPais, other.codPais) && Objects.equals(nombrePais, other.nombrePais);
	}
	public String getCodPais() {
		return codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public String getNombrePais() {
		return nombrePais;
	}
	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

}
