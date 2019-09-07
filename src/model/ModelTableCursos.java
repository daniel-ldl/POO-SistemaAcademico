package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.CursoEntidade;

public class ModelTableCursos extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = {"Nome"};
	private List<CursoEntidade> curso;

	public ModelTableCursos(List<CursoEntidade> curso) {
		this.curso = curso;
	}

	@Override
	public int getRowCount() {
		return curso.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(CursoEntidade c) {
		this.curso.add(c);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.curso.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return curso.get(rowIndex).getNome();
		
		default:
			break;
		}
		return null;
	}

} 