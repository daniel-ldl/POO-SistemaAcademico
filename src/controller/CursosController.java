package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import connection.Conexao;
import entidades.CursoEntidade;

public class CursosController {

	Conexao minhaConexao = new Conexao();

	public void salvarCliente(CursoEntidade curso) {

		minhaConexao.getConexao();
		String meuInsert = "INSERT INTO cursos(\r\n" + "	nomeCurso)\r\n"
				+ "	VALUES (?);";
		try {
			PreparedStatement smtInsereCliente = minhaConexao.getConexao().prepareStatement(meuInsert);
			smtInsereCliente.setString(1, curso.getNome());
			
			smtInsereCliente.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Salvo com Sucesso", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			minhaConexao.fecharConexao();
		}
	}

}