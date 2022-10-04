package banco.livraria.dao;

import banco.livraria.factory.ConnectionFactory;
import banco.livraria.model.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kessio
 */
public class LivroDAO {
    public void inserir(Livro livro){
        
        String sql = "INSERT INTO livro(isbn, titulo, anoPublicacao, editora) VALUES (?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livro.getIsbn());
            pstm.setString(2, livro.getTitulo());
            pstm.setString(3, livro.getAnoPublicacao());
            
            pstm.execute();
        }catch(SQLException erro){
            erro.printStackTrace();
        }
    }
}
