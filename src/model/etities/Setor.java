package model.etities;

import java.util.Objects;

public class Setor implements Comparable<Setor> {
	private long   codigo;
	private String setor;
	private Setor  superior = null;
	
	public Setor() {
	}

	public Setor(long codigo, String setor, Setor superior) {
		this.codigo   = codigo;
		this.setor    = setor;
		this.superior = superior;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Setor getSuperior() {
		return superior;
	}

	public void setSuperior(Setor superior) {
		this.superior = superior;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Setor other = (Setor) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "{codigo:" + codigo + ", setor:" + setor + ", superior:" + superior + "}";
	}

	@Override
	public int compareTo(Setor o) {
		return this.setor.compareTo(o.getSetor());
	}
	
}
