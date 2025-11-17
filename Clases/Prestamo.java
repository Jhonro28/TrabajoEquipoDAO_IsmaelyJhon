package Clases;

import java.time.LocalDate;

public class Prestamo {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Usuario usuario;
    private Libro libro;

    public Prestamo() {
    }

    public Prestamo(int id, LocalDate fechaInicio, LocalDate fechaFin, Usuario usuario, Libro libro) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.libro = libro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", fechaInicio='" + fechaInicio.toString() + '\'' +
                ", fechaFin='" + fechaFin.toString() + '\'' +
                '}';
    }
}
