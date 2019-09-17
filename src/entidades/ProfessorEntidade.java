package entidades;

import java.util.Calendar;
import java.util.Date;

public class ProfessorEntidade extends PessoaEntidade {

	private String matricula;
	private String formacao;
	private Calendar dataMatriculaInstituicao;

	public ProfessorEntidade(String cpf, String nome, String sexo, Calendar dataNascimento, String logradouro, String bairro,
			String cep, int numero, String complemento, String email, String matricula, String formacao,
			Calendar dataMatriculaInstituicao) {
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

	public Calendar getDataMatriculaInstituicao() {
		return dataMatriculaInstituicao;
	}

	public void setDataMatriculaInstituicao(Calendar dataMatriculaInstituicao) {
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

}
