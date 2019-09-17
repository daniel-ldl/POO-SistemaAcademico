package entidades;

import java.sql.Date;
import java.util.Calendar;

public class PessoaEntidade {

	private String cpf;
	private String nome;
	private String sexo;
	private Calendar dataNascimento;
	private String logradouro;
	private String bairro;
	private String cep;
	private int numero;
	private String complemento;
	private String email;

	public PessoaEntidade(String cpf, String nome, String sexo, Calendar dataNascimento, String logradouro,
			String bairro, String cep, int numero, String complemento, String email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.email = email;
	}

	public PessoaEntidade() {

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public long getData_Nascimento() {
		return dataNascimento.getTimeInMillis();
	}
	
	public void setData_Nascimento(long data) {
		dataNascimento.setTimeInMillis(data);
	}

}
