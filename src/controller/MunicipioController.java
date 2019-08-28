package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.Conexao;
import entidades.MunicipioEntidade;

public class MunicipioController {

	Conexao connection = new Conexao();

	public void salvarDisciplina(MunicipioEntidade municipio) {

		connection.getConexao();
		String sqlInsereMunicipio = "INSERT INTO public.municipios(\r\n" + 
				"	nomemunicipio, uf)\r\n" + 
				"	VALUES (?, ?);";
		try {
			PreparedStatement smtInsereMunicipio = connection.getConexao().prepareStatement(sqlInsereMunicipio);
			smtInsereMunicipio.setString(1, municipio.getNome());
			smtInsereMunicipio.setString(2, municipio.getUF());
			smtInsereMunicipio.executeUpdate();

			JOptionPane.showMessageDialog(null, "Disciplina salva!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			connection.fecharConexao();
		}
	}
	
}
