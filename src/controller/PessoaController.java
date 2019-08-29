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
				+ "	cpf, nomepessoa, sexo, data_nascimento, logradouro, bairro, cep, numero, complemento, email)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement stmInserePessoa = connection.getConexao().prepareStatement(sqlInserePessoa);
			stmInserePessoa.setString(2, pessoa.getCpf());
			stmInserePessoa.setString(3, pessoa.getNome());
			stmInserePessoa.setString(4, String.valueOf(pessoa.getSexo()));
			stmInserePessoa.setDate(5, (Date) pessoa.getDataNascimento());
			stmInserePessoa.setString(6, pessoa.getLogradouro());
			stmInserePessoa.setString(7, pessoa.getBairro());
			stmInserePessoa.setInt(8, pessoa.getNumero());
			stmInserePessoa.setString(9, pessoa.getComplemento());
			stmInserePessoa.executeUpdate();

			JOptionPane.showMessageDialog(null, "Disciplina salva!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}

}
