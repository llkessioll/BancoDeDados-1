package banco.livraria.model;

/**
 *
 * @author kessio
 */
public class Autor {
    
    private int cod;
    private String nome;
    private String nacionalidade;
    
    public Autor(){
    }
    
    public Autor(int cod, String nome, String nacionalidade){
        this.cod = cod;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
    
    
    public int getCod(){
        return cod;
    }
    public void setCod(int cod){
        this.cod = cod;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNacionalidade(){
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade){
        this.nacionalidade = nacionalidade;
    }
}
