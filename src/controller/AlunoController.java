package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.AlunoEntidade;

public class AlunoController {
	
	Conexao connection = new Conexao();

	public void salvarAluno(AlunoEntidade aluno) {
		
		connection.getConexao();
		String sqlInsereAluno = "INSERT INTO public.alunos(\r\n" + 
				"	matricula, datamatriculainstituicao)\r\n" + 
				"	VALUES (?, ?);";
		
		try {
			
			PreparedStatement stmInsereAluno = connection.getConexao().prepareStatement(sqlInsereAluno);
			stmInsereAluno.setString(1, aluno.getMatricula());
			stmInsereAluno.setDate(2, (Date)aluno.getDataMatriculaInstituicao());
			stmInsereAluno.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}finally {
			connection.fecharConexao();
		}
		
	}
	
}
