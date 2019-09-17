package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.CursoEntidade;

public class CursosController {

	Conexao connection = new Conexao();

	public void salvarCliente(CursoEntidade curso) {

		connection.getConexao();
		String meuInsert = "INSERT INTO cursos(\r\n" + "	nomeCurso)\r\n"
				+ "	VALUES (?);";
		try {
			PreparedStatement smtInsereCliente = connection.getConexao().prepareStatement(meuInsert);
			smtInsereCliente.setString(1, curso.getNome());
			
			smtInsereCliente.executeUpdate();
			JOptionPane.showMessageDialog(null, "Curso salvo com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}
	
	public void carregarCursos(JComboBox cursos) throws SQLException {
		connection.getConexao();
		ResultSet rs = null;
		String meuSelect = "SELECT nomecurso\r\n" + 
				"	FROM public.cursos;";
		
		PreparedStatement smtBuscaCursos = connection.getConexao().prepareStatement(meuSelect);
		rs = smtBuscaCursos.executeQuery();
		
		if(rs.next()) {
			do {
				cursos.addItem(rs.getString("nomecurso"));					
			}while(rs.next());
		}
	}

}