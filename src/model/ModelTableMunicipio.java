package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.MunicipioEntidade;

public class ModelTableMunicipio extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Nome", "UF" };
	private List<MunicipioEntidade> municipio;

	public ModelTableMunicipio(List<MunicipioEntidade> municipio) {
		this.municipio = municipio;
	}

	@Override
	public int getRowCount() {
		return municipio.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(MunicipioEntidade m) {
		this.municipio.add(m);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.municipio.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return municipio.get(rowIndex).getNome();
		case 1:
			return municipio.get(rowIndex).getUF();

		default:
			break;
		}
		return null;
	}

}