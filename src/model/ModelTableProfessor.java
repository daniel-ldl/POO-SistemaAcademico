package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.ProfessorEntidade;

public class ModelTableProfessor extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Matrícula", "Formação", "Data de Matrículas" };
	private List<ProfessorEntidade> professor;

	public ModelTableProfessor(List<ProfessorEntidade> professor) {
		this.professor = professor;
	}

	@Override
	public int getRowCount() {
		return professor.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(ProfessorEntidade p) {
		this.professor.add(p);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.professor.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return professor.get(rowIndex).getMatricula();
		case 1:
			return professor.get(rowIndex).getFormacao();
		case 2:
			return professor.get(rowIndex).getDataMatriculaInstituicao();
		default:
			break;
		}
		return null;
	}

}