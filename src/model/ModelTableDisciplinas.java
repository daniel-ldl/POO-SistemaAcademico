package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.DisciplinaEntidade;

public class ModelTableDisciplinas extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Codigo", "Nome"};
	private List<DisciplinaEntidade> disciplina;

	public ModelTableDisciplinas(List<DisciplinaEntidade> disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int getRowCount() {
		return disciplina.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(DisciplinaEntidade d) {
		this.disciplina.add(d);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.disciplina.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return disciplina.get(rowIndex).getCodigo();
		case 1:
			return disciplina.get(rowIndex).getNome();
		
		default:
			break;
		}
		return null;
	}

} 