import java.util.ArrayList;

public class Autor extends Pessoa{

    static ArrayList<Livro> listaLivrosAutor = new ArrayList<>();

    public ArrayList<Livro> getListaLivrosAutor() {
        return listaLivrosAutor;
    }

    public void setListaLivrosAutor(ArrayList<Livro> listaLivros) {
        this.listaLivrosAutor = listaLivros;
    }

    public Autor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
