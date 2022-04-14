public class Diretor extends Pessoa{
    static int cont;
    @Override
    public void listarLivros() {
        cont = -1;
        for(int i =0;i<Main.listaLivros.size();i++){
            System.out.println(Main.listaLivros.get(i).toString());
            cont++;
        }
        if (cont == -1) {
            System.out.println("Nenhum livro para listar!");
            Main.menuPrincipal();
        }
    }

    @Override
    public void editarLivro() {
        int indiceLivro = Main.verificaLivro();
        int opcaoEdita = Main.selecionaTipoEditar("passagem pelo revisor", indiceLivro);
        switch (opcaoEdita){
            case 1:
                Main.listaLivros.get(indiceLivro).setStatus(6);
                Main.listaLivros.get(indiceLivro).setEditora(Main.editora);
                break;
            case 2:
                Main.listaLivros.get(indiceLivro).setStatus(5);
                break;
            case 3:
                Main.listaLivros.get(indiceLivro).setStatus(1);
                break;
        }
    }

    @Override
    public void listarAtividade() {
        cont = -1;
        for (int i =0;i<Main.listaLivros.size();i++){
            if(Main.listaLivros.get(i).getStatus() == 4){
                System.out.println(Main.listaLivros.get(i).toString());
                cont++;
            }
        }
    }


    public Diretor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }
}
