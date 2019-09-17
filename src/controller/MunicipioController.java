package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
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
	
	public void resgataMunicipios(JComboBox municipio) {
		connection.getConexao();
		ResultSet rs = null;
		String sqlRecuperaEstado = "SELECT nomemunicipio FROM public.municipios;";
		
		try {
			PreparedStatement sqlBuscaEstado = connection.getConexao().prepareStatement(sqlRecuperaEstado);
			rs = sqlBuscaEstado.executeQuery();
			
			if(rs.next()) {
				do {
					municipio.addItem(rs.getString("nomemunicipio"));					
				}while(rs.next());
			}
			
		}catch(SQLException e1) {
			
		}finally {
			
		}

	}
	
	public void resgataEstados(JComboBox estado) {
		connection.getConexao();
		ResultSet rs = null;
		String sqlRecuperaEstado = "SELECT uf FROM public.municipios group by uf;";
		
		try {
			PreparedStatement sqlBuscaEstado = connection.getConexao().prepareStatement(sqlRecuperaEstado);
			rs = sqlBuscaEstado.executeQuery();
			
			if(rs.next()) {
				do {
					estado.addItem(rs.getString("uf"));
				}while(rs.next());
			}
			
		}catch(SQLException e1) {
			JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
		}finally {
			connection.fecharConexao();
		}

	}
	
	public void resgataMunicipioPeloEstado(String estado) {
		connection.getConexao();
		ResultSet rs = null;
		List<MunicipioEntidade> listaDeMunicipios = new ArrayList<>();
		String sqlRecuperaEstado = "SELECT nomemunicipio FROM public.municipios where uf = '"+estado+"';";
		
		try {
			PreparedStatement sqlBuscaEstado = connection.getConexao().prepareStatement(sqlRecuperaEstado);
			rs = sqlBuscaEstado.executeQuery();
			
			if(rs.next()) {
				do {
					MunicipioEntidade municipio = new MunicipioEntidade();
					municipio.setNome(rs.getString("nomemunicipio"));
					listaDeMunicipios.add(municipio);
					
				}while(rs.next());
			}
			
		}catch(SQLException e1) {
			
		}finally {
			connection.fecharConexao();
		}
	}
	
}
