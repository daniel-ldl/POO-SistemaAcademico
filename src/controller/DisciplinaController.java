package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.DisciplinaEntidade;

public class DisciplinaController {

	Conexao connection = new Conexao();

	public void salvarDisciplina(DisciplinaEntidade disciplina) {

		connection.getConexao();
		String sqlInsereDisciplina = "INSERT INTO public.disciplinas(\r\n" + "	codigodisciplina, nomedisciplina)\r\n"
				+ "	VALUES (?, ?);";
		try {
			PreparedStatement smtInsereDisciplina = connection.getConexao().prepareStatement(sqlInsereDisciplina);
			smtInsereDisciplina.setInt(1, disciplina.getCodigo());
			smtInsereDisciplina.setString(2, disciplina.getNome());
			smtInsereDisciplina.executeUpdate();

			JOptionPane.showMessageDialog(null, "Disciplina salva!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}

}
