package banco.livraria.dao;

import banco.livraria.factory.ConnectionFactory;
import banco.livraria.model.Categoria;
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
public class CategoriaDAO {
    
    public void inserir(Categoria categoria){
        
        String sql = "INSERT INTO categoria(cod, nome) VALUES (?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, categoria.getCod());
            pstm.setString(2, categoria.getNome());
            
            pstm.execute();
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm);
        }
    }
    
    public void alterar(Categoria categoria){
        
        String sql = "UPDATE categoria SET nome = ? "+ "WHERE cod = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, categoria.getNome());
            pstm.setInt(2, categoria.getCod());
            
            pstm.execute();
            
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm);
        }
    }
    
    public List<Categoria> listar(){
        
        String sql = "SELECT * FROM categoria";
    
        List<Categoria> autores = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while(rset.next()){
                
                Categoria autor = new Categoria();
                
                autor.setCod(rset.getInt("cod"));
                autor.setNome(rset.getString("nome"));
                
                autores.add(autor);
            }
            
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm, rset);
        }
        
        return autores;
    }
    
    public void deletar(int cod){
        
        String sql = "DELETE FROM categoria WHERE cod = ?";
        
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
