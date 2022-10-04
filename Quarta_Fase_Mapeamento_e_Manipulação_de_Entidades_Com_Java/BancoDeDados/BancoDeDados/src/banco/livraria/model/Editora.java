package banco.livraria.model;

/**
 *
 * @author kessio
 */
public class Editora {
    
    private int cod;
    private String nome;
    private String cnpj;

    public Editora() {
    }

    public Editora(int cod, String nome, String cnpj) {
        this.cod = cod;
        this.nome = nome;
        this.cnpj = cnpj;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
}
