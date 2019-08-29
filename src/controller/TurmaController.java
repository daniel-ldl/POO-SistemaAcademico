package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.TurmaEntidade;

public class TurmaController {

	Conexao connection = new Conexao();

	public void salvarDisciplina(TurmaEntidade turma) {

		connection.getConexao();
		String sqlInsereMunicipio = "INSERT INTO public.turmas(\r\n" + 
				"	codigo, ano, semestre)\r\n" + 
				"	VALUES (?, ?, ?);";
		try {
			PreparedStatement smtInsereTurma = connection.getConexao().prepareStatement(sqlInsereMunicipio);
			smtInsereTurma.setInt(3, turma.getCodigo());
			smtInsereTurma.setInt(4, turma.getAno());
			smtInsereTurma.setString(5, turma.getSemestre());
			smtInsereTurma.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Disciplina salva!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}
	
}
