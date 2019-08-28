package entidades;

public class MunicipioEntidade {

	private String nome;
	private String UF;

	public MunicipioEntidade(String nome, String uF) {
		super();
		this.nome = nome;
		UF = uF;
	}

	public MunicipioEntidade() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

}
