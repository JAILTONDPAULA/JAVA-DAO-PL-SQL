package model.etities;

import java.util.Date;
import java.util.Objects;

import model.etities.enums.Sexo;

public class Colaborador {
	private Float       matricula;
	private String      razaoSocial;
	private String      nome;
	private Float       cpf;
	private Date        dataNascimento;
	private Sexo        sexo;
	private Setor       setor;
	private Colaborador gestor;
	
	public Colaborador() {
	}

	public Colaborador(Float matricula, String razaoSocial, String nome, Float cpf, Date dataNascimento, Sexo sexo,Setor setor, Colaborador gestor) {
		this.matricula = matricula;
		this.razaoSocial = razaoSocial;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.setor = setor;
		this.gestor = gestor;
	}

	public Float getMatricula() {
		return matricula;
	}

	public void setMatricula(Float matricula) {
		this.matricula = matricula;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getCpf() {
		return cpf;
	}

	public void setCpf(Float cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Colaborador getGestor() {
		return gestor;
	}

	public void setGestor(Colaborador gestor) {
		this.gestor = gestor;
	}


	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "{matricula:" + matricula + ", razaoSocial:" + razaoSocial + ", nome:" + nome + ", cpf:"
				+ cpf + ", dataNascimento:" + dataNascimento + ", sexo:" + sexo + ", setor:" + setor + ", gestor:"
				+ gestor + "}";
	}
	
	
	
	
}
