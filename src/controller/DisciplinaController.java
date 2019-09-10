package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.DisciplinaEntidade;
import model.ModelTableDisciplinas;

public class DisciplinaController {

	Conexao connection = new Conexao();

	public void salvarDisciplina(DisciplinaEntidade disciplina) {

		connection.getConexao();
		String sqlInsereDisciplina = "INSERT INTO public.disciplinas(\r\n" + "	codigodisciplina, nomedisciplina)\r\n"
				+ "	VALUES (?, ?);";
		try {
			PreparedStatement smtInsereDisciplina = connection.getConexao().prepareStatement(sqlInsereDisciplina);
			smtInsereDisciplina.setString(1, disciplina.getCodigo());
			smtInsereDisciplina.setString(2, disciplina.getNome());
			smtInsereDisciplina.executeUpdate();

			JOptionPane.showMessageDialog(null, "Disciplina salva!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}
	
	public void carregarDisciplinas(ModelTableDisciplinas modeloTabela) {
		connection.getConexao();
		ResultSet rsCliente = null;
		List<DisciplinaEntidade> listaDeDisciplinas = new ArrayList<DisciplinaEntidade>();
		String sqlResgataClientes = "SELECT codigodisciplina, nomedisciplina\r\n" + 
				"	FROM public.disciplinas;";
		try {
			PreparedStatement stmResgataClientes = connection.getConexao().prepareStatement(sqlResgataClientes);
			rsCliente = stmResgataClientes.executeQuery();
			if (rsCliente.next()) {
				do {
					DisciplinaEntidade novo = new DisciplinaEntidade();
					novo.setCodigo(rsCliente.getString("codigodisciplina"));
					novo.setNome(rsCliente.getString("nomedisciplina"));
					listaDeDisciplinas.add(novo);
				} while (rsCliente.next());
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			connection.fecharConexao();
		}
		for (DisciplinaEntidade c : listaDeDisciplinas) {
			modeloTabela.addRows(c);
		}
	}


}
