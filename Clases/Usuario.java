package Clases;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nombre;
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int id, String nombre) {
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

    public void addPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
