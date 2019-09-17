package entidades;



import java.util.Calendar;

public class AlunoEntidade extends PessoaEntidade {

	private String matricula;
	private Calendar dataMatriculaInstituicao;

	public AlunoEntidade(String cpf, String nome, String sexo, Calendar dataNascimento, String logradouro, String bairro,
			String cep, int numero, String complemento, String email, String matricula, Calendar dataMatriculaInstituicao) {
		super(cpf, nome, sexo, dataNascimento, logradouro, bairro, cep, numero, complemento, email);
		this.matricula = matricula;
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

	public AlunoEntidade() {

	}

	public AlunoEntidade(String matricula, Calendar dataMatriculaInstituicao) {
		this.matricula = matricula;
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Calendar getDataMatriculaInstituicao() {
		return dataMatriculaInstituicao;
	}

	public void setDataMatriculaInstituicao(Calendar dataMatriculaInstituicao) {
		this.dataMatriculaInstituicao = dataMatriculaInstituicao;
	}

	public long getData_Matricula() {
		return dataMatriculaInstituicao.getTimeInMillis();
	}
	
	public void setData_Matricula(long data) {
		dataMatriculaInstituicao.setTimeInMillis(data);
	}
	
	

}
