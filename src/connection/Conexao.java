/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
  
public class Conexao {
    private String driver = "org.postgresql.Driver";
    private String user = "postgres";
    private String url = "jdbc:postgresql://localhost:5432/POO-Final";
    private String senha = "Online152";
    private Connection con = null;
    
    public Conexao(){
        try{
            Class.forName(driver);
            this.con = (Connection)DriverManager.getConnection(url, user, senha);
            System.out.println("conexão efetuada com sucesso");
        }
        catch(ClassNotFoundException ex){
            System.err.print(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public Connection getConexao(){
		return con;
	}

	public void fecharConexao(){
		try{
			if(con != null)
				con.close();
		}catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage() , "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
