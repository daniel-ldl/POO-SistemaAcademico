package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.AlunoEntidade;
import entidades.PessoaEntidade;

public class ModelTableAluno extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Matrícula","Data de Entrada","Nome", "CPF", "Sexo", "Data de Nascimento", "Logradouro", "Bairro", "CEP", "Número", "Complemento", "Email" };
	private List<AlunoEntidade> aluno;

	public ModelTableAluno(List<AlunoEntidade> aluno) {
		this.aluno = aluno;
	}

	@Override
	public int getRowCount() {
		return aluno.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(AlunoEntidade a) {
		this.aluno.add(a);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.aluno.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return aluno.get(rowIndex).getMatricula();
		case 1:
			return aluno.get(rowIndex).getDataMatriculaInstituicao();
		case 2:
			return aluno.get(rowIndex).getNome();
		case 3:
			return aluno.get(rowIndex).getCpf();
		case 4:
			return aluno.get(rowIndex).getSexo();
		case 5:
			return aluno.get(rowIndex).getDataNascimento();
		case 6:
			return aluno.get(rowIndex).getLogradouro();
		case 7:
			return aluno.get(rowIndex).getBairro();
		case 8:
			return aluno.get(rowIndex).getCep();
		case 9:
			return aluno.get(rowIndex).getNumero();
		case 10:
			return aluno.get(rowIndex).getComplemento();
		case 11:
			return aluno.get(rowIndex).getEmail();
		default:
			break;
		}
		return null;
	}

}