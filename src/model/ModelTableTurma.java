package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.TurmaEntidade;

public class ModelTableTurma extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Codigo", "Ano", "Semestre" };
	private List<TurmaEntidade> turma;

	public ModelTableTurma(List<TurmaEntidade> turma) {
		this.turma = turma;
	}

	@Override
	public int getRowCount() {
		return turma.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(TurmaEntidade t) {
		this.turma.add(t);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.turma.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return turma.get(rowIndex).getCodigo();
		case 1:
			return turma.get(rowIndex).getAno();
		case 2:
			return turma.get(rowIndex).getSemestre();
		default:
			break;
		}
		return null;
	}

}