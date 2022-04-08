public class Livro {
    private String titulo;
    private int status, qtdPag, isbn;

    public String getTitulo() {
        return titulo;
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

    public Livro(String titulo, int status, int qtdPag, int isbn, String nome_autor, String sobrenome_autor) {
        this.titulo = titulo;
        this.status = status;
        this.qtdPag = qtdPag;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", status=" + status +
                ", qtdPag=" + qtdPag +
                ", isbn=" + isbn +
                '}';
    }
}
