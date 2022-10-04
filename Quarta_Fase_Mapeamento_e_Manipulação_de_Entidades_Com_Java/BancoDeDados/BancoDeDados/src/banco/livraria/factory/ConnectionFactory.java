package banco.livraria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kessio
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/livrariav2";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "123456";
    
    public static Connection getConnection(){
        
        try{
            
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USUARIO, SENHA);
            
        }catch(ClassNotFoundException | SQLException erro){
            throw new RuntimeException("Erro de conxão", erro);
        }
    }
    
    public static void closeConnection(Connection conn){
        
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.print("Erro ao fechar conexão");
            }
        }
    }
    
    public static void closeConnection(Connection conn , PreparedStatement statement){
        
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException ex) {
                System.err.print("Erro ao fechar conexão");            
            }
        }
        
        closeConnection(conn);
    }
    
    public static void closeConnection(Connection conn , PreparedStatement statement, ResultSet rst){
        
        if(rst != null){
            try {
                rst.close();
            } catch (SQLException ex) {
                System.err.print("Erro ao fechar conexão");            
            }
        }
        
        closeConnection(conn, statement);
    }
}
