package Controller;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    
    public static Connection AbrirConexao(){
       
        Connection cont = null;
        
        try {
            String URL = "jdbc:oracle:thin:@localhost:1521:mkyong";
            Class.forName("com.mysql.jdbc.Driver");
            String usuario = "root";
            String senha = "admin";
            Connection con = DriverManager.getConnection(URL, usuario, senha);
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro na conexão com o BANCO", 
                    "Professor Online", JOptionPane.ERROR_MESSAGE);
            e.getMessage();
            
            
        }
        
        return cont;
        
    }
    
    public static void FecharConexao(Connection con){
        
        try {
            
            con.close();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
        
    }
    
}