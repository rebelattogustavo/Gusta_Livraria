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
    public void editarLivro(int indicelivro) {
        Main.listaLivros.get(indicelivro).setStatus(1);
    }

    @Override
    public void listarAtividade() {

    }


    public Autor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
