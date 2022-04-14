public class Revisor extends Pessoa{
    static int cont = -1;
    @Override
    public void listarLivros() {
        for(int i =0;i<Main.listaLivros.size();i++){
            if(Main.listaLivros.get(i).getStatus() == 1){
                System.out.println(Main.listaLivros.get(i).toString());
                cont++;
            }
        }
    }

    @Override
    public void editarLivro() {
        int indiceLivro = Main.verificaLivro();
        if(Main.listaLivros.get(indiceLivro).getStatus() == 1){
            Main.listaLivros.get(indiceLivro).setStatus(2);
        }else if(Main.listaLivros.get(indiceLivro).getStatus() == 2){
            int opcaoEdita = Main.selecionaTipoEditar("revisão", indiceLivro);
            switch (opcaoEdita){
                case 1:
                    if(Main.listaLivros.get(indiceLivro).getPorcentagem() == 100){
                        Main.listaLivros.get(indiceLivro).setStatus(4);
                    }
                    break;
                case 2:
                    Main.listaLivros.get(indiceLivro).setStatus(5);
                    break;
                case 3:
                    Main.listaLivros.get(indiceLivro).setStatus(3);
                    break;
            }
        }
    }

    @Override
    public void listarAtividade() {
        cont = -1;
        for(int i =0;i< Main.listaLivros.size();i++){
            if(Main.listaLivros.get(i).getStatus() == 2){
                System.out.println(Main.listaLivros.get(i).toString());
                cont++;
            }
        }
    }


    public Revisor(String nome, String cpf, String sobrenome, String email, String genero, String senha) {
        super(nome, cpf, sobrenome, email, genero, senha);
    }



}
