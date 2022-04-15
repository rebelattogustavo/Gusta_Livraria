import java.util.ArrayList;

public class Autor extends Pessoa{

    @Override
    public void listarLivros() {
        int cont = -1;
        for (int i=0;i<Main.listaLivros.size();i++){
            if(Main.user == Main.listaLivros.get(i).getAutor()){
                System.out.println(Main.listaLivros.get(i).toString());
                cont++;
            }
        }
        if (cont == -1){
            System.out.println("Você cadastrou nenhum livro até o momento!");
            Main.menuPrincipal();
        }
    }

    @Override
    public void editarLivro() {
        int indicelivro = Main.verificaLivro();
        if(indicelivro == -1){
            System.out.println("Livro não encontrado!");
            Main.menuPrincipal();
        }
        Main.listaLivros.get(indicelivro).setStatus(1);
    }

    @Override
    public String[] opcoes() {
        return new String[]{
            "1- Listar atividades" ,
            "2- Listar livros" ,
            "3- Cadastrar Livro" ,
            "4- Logout" ,
            "5- Encerrar"
        };
    }

    @Override
    public String listarAtividade() {
        String livros = "";
        int cont = -1;
        for (int i=0;i<Main.listaLivros.size();i++){
            if(Main.user == Main.listaLivros.get(i).getAutor() && Main.listaLivros.get(i).getStatus() == 3){
                livros += Main.listaLivros.get(i).toString();
                cont++;
            }
        }
        if (cont == -1){
            System.out.println("Você cadastrou nenhum livro até o momento!");
            Main.menuPrincipal();
        }
        return livros;
    }


    public Autor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
