package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.GradeEntidade;

public class GradeController {

	Conexao connection = new Conexao();

	public void salvarDisciplina(GradeEntidade grade) {

		connection.getConexao();
		String sqlInsereGrade = "INSERT INTO public.grades(\r\n" + 
				"	nomegrade)\r\n" + 
				"	VALUES (?);";
		try {
			PreparedStatement smtInsereGrade = connection.getConexao().prepareStatement(sqlInsereGrade);
			smtInsereGrade.setString(1, grade.getNome());
			smtInsereGrade.executeUpdate();

			JOptionPane.showMessageDialog(null, "Grade salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}
	
}
