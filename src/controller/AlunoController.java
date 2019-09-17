package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.AlunoEntidade;
import model.ModelTableAluno;

public class AlunoController {

	Conexao connection = new Conexao();

	public void salvarAluno(AlunoEntidade aluno) {

		connection.getConexao();
		String sqlInsereAluno = "INSERT INTO public.alunos(\r\n" + 
				"	matricula, datamatriculainst)\r\n" + 
				"	VALUES (?, ?);";

		try {

			PreparedStatement stmInsereAluno = connection.getConexao().prepareStatement(sqlInsereAluno);
			stmInsereAluno.setString(1, aluno.getMatricula());
			stmInsereAluno.setDate(2, new java.sql.Date(aluno.getDataMatriculaInstituicao().getTimeInMillis()));
			stmInsereAluno.executeUpdate();

			JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Aluno: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}

	}

	public void carregarAlunos(ModelTableAluno modeloTabela) {
		connection.getConexao();
		ResultSet rs = null;
		List<AlunoEntidade> listaDeAlunos = new ArrayList<AlunoEntidade>();
		String sqlBuscaAluno = "select pessoas.nomepessoa, pessoas.datanasc, pessoas.logradouro, pessoas.bairro, pessoas.cep, pessoas.numero,\r\n"
				+ "pessoas.complemento, pessoas.email, alunos.matricula, alunos.dataMatriculaInst \r\n"
				+ "from public.alunos\r\n" + "inner join public.pessoas on alunos.idpessoa = pessoas.idpessoa";
		try {
			PreparedStatement smtResgataAluno = connection.getConexao().prepareStatement(sqlBuscaAluno);
			rs = smtResgataAluno.executeQuery();
			if (rs.next()) {
				do {
					AlunoEntidade aluno = new AlunoEntidade();
					aluno.setNome(rs.getString("pessoas.nomePessoa"));
					//aluno.setDataNascimento(rs.getDate("pessoas.datanasc"));
					aluno.setLogradouro(rs.getString("pessoas.logradouro"));
					aluno.setBairro(rs.getString("pessoas.bairro"));
					aluno.setCep(rs.getString("pessoas.cep"));
					aluno.setNumero(rs.getInt("pessoas.numero"));
					aluno.setComplemento(rs.getString("pessoas.complemento"));
					aluno.setEmail(rs.getString("pessoas.email"));
					aluno.setMatricula(rs.getString("aluno.matricula"));
					//aluno.setDataMatriculaInstituicao(rs.getDate("alunos.datamatriculainst"));
					listaDeAlunos.add(aluno);
					
				} while (rs.next());
			}

		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null, "Erro na pesquisa!", "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
		for(AlunoEntidade a : listaDeAlunos) {
			modeloTabela.addRows(a);
		}
	}

}
