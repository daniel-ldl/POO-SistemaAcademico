package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.MunicipioEntidade;
import entidades.PessoaEntidade;

public class ModelTablePessoa extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cabecalho[] = { "Nome", "CPF", "Sexo", "Data de Nascimento", "Logradouro", "Bairro", "CEP", "Número", "Complemento", "Email" };
	private List<PessoaEntidade> pessoa;

	public ModelTablePessoa(List<PessoaEntidade> pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int getRowCount() {
		return pessoa.size();
	}

	@Override
	public int getColumnCount() {
		return cabecalho.length;
	}

	@Override
	public String getColumnName(int posicao) {
		return cabecalho[posicao];
	}

	public void addRows(PessoaEntidade p) {
		this.pessoa.add(p);
		fireTableDataChanged();
	}

	public void removeRow(int linha) {
		this.pessoa.remove(linha);
		this.fireTableRowsDeleted(linha, linha);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return pessoa.get(rowIndex).getNome();
		case 1:
			return pessoa.get(rowIndex).getCpf();
		case 2:
			return pessoa.get(rowIndex).getSexo();
		case 3:
			return pessoa.get(rowIndex).getDataNascimento();
		case 4:
			return pessoa.get(rowIndex).getLogradouro();
		case 5:
			return pessoa.get(rowIndex).getBairro();
		case 6:
			return pessoa.get(rowIndex).getCep();
		case 7:
			return pessoa.get(rowIndex).getNumero();
		case 8:
			return pessoa.get(rowIndex).getComplemento();
		case 9:
			return pessoa.get(rowIndex).getEmail();
		default:
			break;
		}
		return null;
	}

}