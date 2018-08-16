package model;

public class Estudante {
	private int idEstudante;
	private String nome;
	private String sobrenome;
	private String email;

	public Estudante() {
	}

	public Estudante( String nome, String sobrenome, String email) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}

	public Estudante(int idEstudante, String nome, String sobrenome, String email) {
		this.idEstudante = idEstudante;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
	}

	public int getIdEstudante() {
		return idEstudante;
	}

	public void setIdEstudante(int idEstudante) {
		this.idEstudante = idEstudante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Estudante [idEstudante=" + idEstudante + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email="
				+ email + "]";
	}
	
	
}
