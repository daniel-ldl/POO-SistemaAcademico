package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.ProfessorEntidade;

public class ProfessorController {

	Conexao connection = new Conexao();

	public void salvarProfessor(ProfessorEntidade professor) {

		connection.getConexao();
		String sqlInsereProfessor = "INSERT INTO public.professores(\r\n"
				+ "	matricula, datamatriculainstituicao, formacao)\r\n" + "	VALUES (?, ?, ?);";

		try {

			PreparedStatement stmInsereProfessor = connection.getConexao().prepareStatement(sqlInsereProfessor);
			stmInsereProfessor.setString(1, professor.getMatricula());
			stmInsereProfessor.setDate(2, (Date) professor.getDataMatriculaInstituicao());
			stmInsereProfessor.setString(3, professor.getFormacao());
			stmInsereProfessor.executeUpdate();

			JOptionPane.showMessageDialog(null, "Professor salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}

	}

}
