package entidades;

public class DisciplinaEntidade {

	private int codigo;
	private String nome;

	public DisciplinaEntidade(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public DisciplinaEntidade() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
