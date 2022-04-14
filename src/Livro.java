public class Livro {
    private String titulo;
    Autor autor;
    Editora editora;
    private int status, qtdPag, isbn;
    private double porcentagem = 0;


    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQtdPag() {
        return qtdPag;
    }

    public void setQtdPag(int qtdPag) {
        this.qtdPag = qtdPag;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Livro(String titulo, Autor autor, int status, int qtdPag, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
        this.qtdPag = qtdPag;
        this.isbn = isbn;
    }

    public void mudarPorcent(int qtdPag, int paglidas){
        this.porcentagem = (paglidas * 100)/qtdPag;
    }

     @Override
    public String toString() {
        String texto =  "Livro: " +
                "Titulo: '" + titulo + '\'' +
                " | Nome do autor: " + getAutor().getNome() + " " + getAutor().getSobrenome() +
                " | Status: " + status +
                " | Quantidade de páginas: " + qtdPag +
                " | ISBN: " + isbn +
                " | Foi revisado: " + getPorcentagem() + "% do livro";
                if(this.getEditora() != null) {
                    texto += " | Editora: " + getEditora().getNome();
                }
            return texto;
    }

}
