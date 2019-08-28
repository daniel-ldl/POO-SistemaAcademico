package entidades;

import java.util.Date;

public class AlunoEntidade extends PessoaEntidade {

	private String matricula;
	private Date dataMatriculaInstituicao;

	public AlunoEntidade(String cpf, String nome, char sexo, Date dataNascimento, String logradouro, String bairro,
			String cep, int numero, String complemento, String email, String matricula, Date dataMatriculaInstituicao) {
		super(cpf, nome, sexo, dataNascimento, logradouro, bairro, cep, numero, complemento, email);
		this.matricula = matricula;
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

	public AlunoEntidade() {

	}

	public AlunoEntidade(String matricula, Date dataMatriculaInstituicao) {
		this.matricula = matricula;
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataMatriculaInstituicao() {
		return dataMatriculaInstituicao;
	}

	public void setDataMatriculaInstituicao(Date dataMatriculaInstituicao) {
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

}
