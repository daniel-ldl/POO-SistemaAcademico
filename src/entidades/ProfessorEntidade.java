package entidades;

import java.util.Date;

public class ProfessorEntidade extends PessoaEntidade {

	private String matricula;
	private String formacao;
	private Date dataMatriculaInstituicao;

	public ProfessorEntidade(String cpf, String nome, char sexo, Date dataNascimento, String logradouro, String bairro,
			String cep, int numero, String complemento, String email, String matricula, String formacao,
			Date dataMatriculaInstituicao) {
		super(cpf, nome, sexo, dataNascimento, logradouro, bairro, cep, numero, complemento, email);
		this.matricula = matricula;
		this.formacao = formacao;
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

	public ProfessorEntidade() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public Date getDataMatriculaInstituicao() {
		return dataMatriculaInstituicao;
	}

	public void setDataMatriculaInstituicao(Date dataMatriculaInstituicao) {
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

}
