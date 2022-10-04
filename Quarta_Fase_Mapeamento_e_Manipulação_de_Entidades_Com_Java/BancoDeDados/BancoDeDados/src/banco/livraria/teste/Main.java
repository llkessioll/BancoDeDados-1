package banco.livraria.teste;

import banco.livraria.dao.AutorDAO;
import banco.livraria.dao.CategoriaDAO;
import banco.livraria.dao.EditoraDAO;
import banco.livraria.model.Autor;
import banco.livraria.model.Categoria;
import banco.livraria.model.Editora;
import java.util.Scanner;

/**
 *
 * @author kessio
 */
public class Main {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);
        AutorDAO autorDao = new AutorDAO();
        EditoraDAO editoraDao = new EditoraDAO();
        CategoriaDAO categoriaDao = new CategoriaDAO();
        
        char op, op2, op3;
        boolean menu = false;
        
        //VARIAVEIS
        int cod;
        String nome, nacionalidade, cnpj;
        //
        
        while(!menu){
            opcoes();
            System.out.println("Escolha uma opção");
            op = teclado.next().charAt(0);
            
            switch(op){
                
                case '1':
                    System.out.println("===== AUTOR ======");
                    tipoOpcoes();
                    System.out.print("Opçao: ");
                    op2 = teclado.next().charAt(0);
                    
                    switch(op2){
                        case '1':
                                
                            System.out.println(" ==== INSERIR ====");
                            System.out.println("Cod: ");
                            cod = teclado.nextInt();
                            System.out.println("Nome: ");
                            teclado.nextLine();
                            nome = teclado.nextLine();
                            System.out.println("Nacionalidade: ");
                            nacionalidade = teclado.nextLine();
                            Autor autor = new Autor(cod, nome, nacionalidade);
                            autorDao.inserir(autor);
                            break;
                            
                        case '2':
                            System.out.println("==== ALTERAR =====");
                            System.out.println("Novo Nome: ");
                            teclado.nextLine();
                            nome = teclado.nextLine();
                            System.out.println("Nova Nacionalide: ");
                            nacionalidade = teclado.nextLine();
                            System.out.println("O codigo do autor que deseja alterar: ");
                            cod = teclado.nextInt();
                            autor = new Autor(cod, nome, nacionalidade);
                            autorDao.alterar(autor);
                            break;
                            
                        case '3':
                            System.out.println("===== BUSCAR ====");
                            System.out.println("Digite o cod do autor para selecionar");
                            cod = teclado.nextInt();
                            
                            for(Autor aut : autorDao.listar()){
                                if(aut.getCod() == cod){
                                    System.out.println("Autor: Nome: "+aut.getNome()+" - Nacionalidade: "+aut.getNacionalidade());
                                    break;
                                }
                            }
                            break;
                        case '4':
                            System.out.println("====== DELETAR =====");
                            System.out.println("Entre com o codigo do Autor para deletar: ");
                            cod = teclado.nextInt();
                            autorDao.deletar(cod);
                            break;
                        case '5':
                            opcoes();
                            break;
                        default:
                            System.out.println("Não e valido");
                    }
                    
                    break;
                
                case '2':
                    System.out.println("===== CATEGORIA =====");
                    tipoOpcoes();
                    System.out.println("Opção: ");
                    op2 = teclado.next().charAt(0);
                    
                    switch(op2){
                        
                        case '1':
                            System.out.println("==== INSERIR =====");
                            System.out.println("cod: ");
                            cod = teclado.nextInt();
                            System.out.println("Nome: ");
                            teclado.nextLine();
                            nome = teclado.nextLine();
                            Categoria cat = new Categoria(cod, nome);
                            categoriaDao.inserir(cat);
                            break;
                        
                        case '2':
                            System.out.println("==== ALTERAR =====");
                            System.out.println("Novo Nome: ");
                            teclado.nextLine();
                            nome = teclado.nextLine();
                            System.out.println("O codigo do autor que deseja alterar: ");
                            cod = teclado.nextInt();
                            cat  = new Categoria(cod, nome);
                            categoriaDao.alterar(cat);
                            break;
                            
                        case '3':
                            System.out.println("===== BUSCAR ====");
                            System.out.println("Digite o cod da editora para selecionar");
                            cod = teclado.nextInt();
                            
                            for(Categoria catt : categoriaDao.listar()){
                                if(catt.getCod() == cod){
                                    System.out.println("Categoria: Nome: "+catt.getNome());
                                    break;
                                }
                            }
                            break;
                        
                        case '4':
                            System.out.println("====== DELETAR =====");
                            System.out.println("Entre com o codigo da editora para deletar: ");
                            cod = teclado.nextInt();
                            categoriaDao.deletar(cod);
                            
                            break;
                        case '5':
                            opcoes();
                        default:
                            System.out.println("Opcação inválida");
                    }
                    break;
                    
                case '3':
                    System.out.println("===== EDITORA =====");
                    tipoOpcoes();
                    System.out.println("Opção: ");
                    op3 = teclado.next().charAt(0);
                    
                    switch(op3){
                        
                        case '1':
                            System.out.println("==== INSERIR =====");
                            System.out.println("cod: ");
                            cod = teclado.nextInt();
                            System.out.println("Cnpj: ");
                            teclado.nextLine();
                            cnpj = teclado.nextLine();
                            System.out.println("Nome: ");
                            nome = teclado.nextLine();
                            Editora editora = new Editora(cod, nome, cnpj);
                            editoraDao.inserir(editora);
                            break;
                        
                        case '2':
                            System.out.println("==== ALTERAR =====");
                            System.out.println("Novo Nome: ");
                            teclado.nextLine();
                            nome = teclado.nextLine();
                            System.out.println("Novo Cnpj: ");
                            cnpj = teclado.nextLine();
                            System.out.println("O codigo do autor que deseja alterar: ");
                            cod = teclado.nextInt();
                            editora  = new Editora(cod, nome, cnpj);
                            editoraDao.alterar(editora);
                            break;
                            
                        case '3':
                            System.out.println("===== BUSCAR ====");
                            System.out.println("Digite o cod da editora para selecionar");
                            cod = teclado.nextInt();
                            
                            for(Editora edi : editoraDao.listar()){
                                if(edi.getCod() == cod){
                                    System.out.println("Autor: Nome: "+edi.getNome()+" - Cnpj: "+edi.getCnpj());
                                    break;
                                }
                            }
                            break;
                        
                        case '4':
                            System.out.println("====== DELETAR =====");
                            System.out.println("Entre com o codigo da editora para deletar: ");
                            cod = teclado.nextInt();
                            editoraDao.deletar(cod);
                            
                            break;
                        case '5':
                            opcoes();
                        default:
                            System.out.println("Opcação inválida");
                    }
                    
                    
                    break;
                    
                case '0':
                    System.out.println("Saindo");
                    menu = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
    
    public static void opcoes(){
        System.out.println("1- Autor\n2- Categoria\n3- Editora\n0 - Sair");
    }
    
    public static void tipoOpcoes(){
        System.out.println("1- Incluir\n2- Alterar\n3- Buscar\n4- Deletar\n5- Voltar");
    }
    
}
