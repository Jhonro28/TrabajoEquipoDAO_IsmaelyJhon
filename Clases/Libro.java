package Clases;

import java.util.ArrayList;

public class Libro {
    private int id;
    private String titulo;
    private String isbn;
    private ArrayList<Autor> autores = new ArrayList<>();

    public Libro() {
    }

    public Libro(int id, String titulo, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void addAutor(Autor autor) {
        autores.add(autor);
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
