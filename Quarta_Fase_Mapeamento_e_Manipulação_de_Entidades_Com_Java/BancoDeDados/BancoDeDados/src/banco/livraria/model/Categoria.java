package banco.livraria.model;

/**
 *
 * @author kessio
 */
public class Categoria {
    
    private int cod;
    private String nome;

    public Categoria() {
    }

    public Categoria(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
