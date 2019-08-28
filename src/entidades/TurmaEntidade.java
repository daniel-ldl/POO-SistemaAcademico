package entidades;

public class TurmaEntidade {

	private int codigo;
	private int ano;
	private String semestre;

	public TurmaEntidade(int codigo, int ano, String semestre) {
		super();
		this.codigo = codigo;
		this.ano = ano;
		this.semestre = semestre;
	}

	public TurmaEntidade() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

}
