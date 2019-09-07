package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.CursoEntidade;
import entidades.GradeEntidade;

public class ModelTableGrade extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Nome"};
	private List<GradeEntidade> grade;

	public ModelTableGrade(List<GradeEntidade> grade) {
		this.grade = grade;
	}

	@Override
	public int getRowCount() {
		return grade.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(GradeEntidade g) {
		this.grade.add(g);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.grade.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return grade.get(rowIndex).getNome();
		
		default:
			break;
		}
		return null;
	}

} 