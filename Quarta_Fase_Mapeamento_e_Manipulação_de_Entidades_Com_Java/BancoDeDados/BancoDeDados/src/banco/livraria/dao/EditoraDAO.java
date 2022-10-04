package banco.livraria.dao;

import banco.livraria.factory.ConnectionFactory;
import banco.livraria.model.Editora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kessio
 */
public class EditoraDAO {
    
    public void inserir(Editora editora){
        
        String sql = "INSERT INTO editora(cod, cnpj, nome) VALUES (?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, editora.getCod());
            pstm.setString(2, editora.getCnpj());
            pstm.setString(3, editora.getNome());
            
            pstm.execute();
        }catch(SQLException erro){
            erro.printStackTrace();
        }
    }
    
    public void alterar(Editora editora){
        
        String sql = "UPDATE editora SET cnpj = ?, nome = ? "+ "WHERE cod = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, editora.getCnpj());
            pstm.setString(2, editora.getNome());
            pstm.setInt(3, editora.getCod());
            
            pstm.execute();
            
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm);
        }
    }
    
    public List<Editora> listar(){
        
        String sql = "SELECT * FROM editora";
    
        List<Editora> editoras = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while(rset.next()){
                
                Editora editora = new Editora();
                
                editora.setCod(rset.getInt("cod"));
                editora.setCnpj(rset.getString("cnpj"));
                editora.setNome(rset.getString("nome"));
                
                editoras.add(editora);
            }
            
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm);
        }
        
        return editoras;
    }
    
    public void deletar(int cod){
        
        String sql = "DELETE FROM editora WHERE cod = ?";
        
        Connection conn = null;
        
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, cod);
            
            pstm.execute();
            
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm);
        }
    }
}
