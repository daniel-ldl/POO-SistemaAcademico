package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Date;

import connection.Conexao;
import entidades.PessoaEntidade;

public class PessoaController {

	Conexao connection = new Conexao();

	public void salvarPessoa(PessoaEntidade pessoa) {

		connection.getConexao();

		String sqlInserePessoa = "INSERT INTO public.pessoas(\r\n"
				+ "	cpf, nomepessoa, sexo, logradouro, bairro, cep, numero, complemento, email, datanasc)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmInserePessoa = connection.getConexao().prepareStatement(sqlInserePessoa);
			stmInserePessoa.setString(1, pessoa.getCpf());
			stmInserePessoa.setString(2, pessoa.getNome());
			stmInserePessoa.setString(3, String.valueOf(pessoa.getSexo()));
			stmInserePessoa.setString(4, pessoa.getLogradouro());
			stmInserePessoa.setString(5, pessoa.getBairro());
			stmInserePessoa.setString(6, pessoa.getCep());
			stmInserePessoa.setInt(7, pessoa.getNumero());
			stmInserePessoa.setString(8, pessoa.getComplemento());
			stmInserePessoa.setString(9, pessoa.getEmail());
			stmInserePessoa.setDate(10, new java.sql.Date(pessoa.getDataNascimento().getTimeInMillis()));
			stmInserePessoa.executeUpdate();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Pessoa: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}

}
