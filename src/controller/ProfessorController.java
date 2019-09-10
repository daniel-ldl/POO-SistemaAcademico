package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.ProfessorEntidade;
import model.ModelTableProfessor;

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
	
	public void carregarProfessor(ModelTableProfessor modeloTabela) {
		connection.getConexao();
		ResultSet rsProfessor = null;
		List<ProfessorEntidade> listaDeProfessores = new ArrayList<ProfessorEntidade>();
		String sqlBuscaProfessor = "select pessoas.nomepessoa, pessoas.data_nascimento, pessoas.logradouro, pessoas.bairro, pessoas.cep, pessoas.numero,\r\n" + 
				"pessoas.complemento, pessoas.email, professores.matricula, professores.datamatriculainstituicao, professores.formacao \r\n" + 
				"from public.professores\r\n" + 
				"inner join public.pessoas on professores.idpessoa = pessoas.idpessoa";
		
		try {
			PreparedStatement stmResgataProfessor = connection.getConexao().prepareStatement(sqlBuscaProfessor);
			rsProfessor = stmResgataProfessor.executeQuery();
			
			if(rsProfessor.next()) {
				do {
					ProfessorEntidade professor = new ProfessorEntidade();
					professor.setNome(rsProfessor.getString("pessoas.nomepessoa"));
					professor.setDataNascimento(rsProfessor.getDate("pessoas.data_nascimento"));
					professor.setLogradouro(rsProfessor.getString("pessoas.logradouro"));
					professor.setBairro(rsProfessor.getString("pessoas.bairro"));
					professor.setCep(rsProfessor.getString("pessoas.cep"));
					professor.setComplemento(rsProfessor.getString("pessoas.complemento"));
					professor.setEmail(rsProfessor.getString("pessoas.email"));
					professor.setMatricula(rsProfessor.getString("professores.matricula"));
					professor.setDataMatriculaInstituicao(rsProfessor.getDate("professores.datamatriculainstituicao"));
					professor.setFormacao(rsProfessor.getString("professores.formacao"));
					listaDeProfessores.add(professor);
				}while(rsProfessor.next());
			}
			for(ProfessorEntidade p : listaDeProfessores) {
				modeloTabela.addRows(p);
			}
			
		}catch(SQLException e1) {
			
		}finally {
			connection.fecharConexao();
		}
	}

}
