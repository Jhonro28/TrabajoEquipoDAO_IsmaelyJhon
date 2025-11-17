package Clases;

import java.util.ArrayList;

public class Autor {
    private int id;
    private String nombre;
    private ArrayList<Libro> libros = new ArrayList<>();

    public Autor() {
    }

    public Autor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
