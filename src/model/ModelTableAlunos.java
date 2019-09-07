package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.AlunoEntidade;


public class ModelTableAlunos extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Matrícula", "Data da Matrícula"};
	private List<AlunoEntidade> aluno;

	public ModelTableAlunos(List<AlunoEntidade> aluno) {
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
		
		default:
			break;
		}
		return null;
	}

} 