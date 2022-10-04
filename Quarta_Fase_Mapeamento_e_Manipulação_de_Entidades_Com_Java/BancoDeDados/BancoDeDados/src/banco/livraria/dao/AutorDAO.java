package banco.livraria.dao;

import banco.livraria.factory.ConnectionFactory;
import banco.livraria.model.Autor;
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
public class AutorDAO {
    
    public void inserir(Autor autor){
        
        String sql = "INSERT INTO autor(cod, nome, nacionalidade) VALUES (?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, autor.getCod());
            pstm.setString(2, autor.getNome());
            pstm.setString(3, autor.getNacionalidade());
            
            pstm.execute();
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm);
        }
    }
    
    public void alterar(Autor autor){
        
        String sql = "UPDATE autor SET nome = ?, nacionalidade = ? "+ "WHERE cod = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, autor.getNome());
            pstm.setString(2, autor.getNacionalidade());
            pstm.setInt(3, autor.getCod());
            
            pstm.execute();
            
        }catch(SQLException erro){
            erro.printStackTrace();
        }finally{
            ConnectionFactory.closeConnection(conn, pstm);
        }
    }
    
    public List<Autor> listar(){
        
        String sql = "SELECT * FROM autor";
    
        List<Autor> autores = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            
            rset = pstm.executeQuery();
            
            while(rset.next()){
                
                Autor autor = new Autor();
                
                autor.setCod(rset.getInt("cod"));
                autor.setNome(rset.getString("nome"));
                autor.setNacionalidade(rset.getString("nacionalidade"));
                
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
        
        String sql = "DELETE FROM autor WHERE cod = ?";
        
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
