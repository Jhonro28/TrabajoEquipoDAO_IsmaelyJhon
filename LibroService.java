package Servicio;

import DAO.LibroDAO;
import Clases.Libro;
import java.util.List;

public class LibroService {

    private LibroDAO libroDAO;

    public LibroService(LibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    public void registrarLibro(String titulo, String isbn) {
        try {
            Libro libro = new Libro(titulo, isbn);
            libroDAO.addLibro(libro);
        } catch (Exception e) {
            System.err.println("Error al registrar libro: " + e.getMessage());
        }
    }

    public List<Libro> listarLibros() {
        try {
            return libroDAO.getAllLibros();
        } catch (Exception e) {
            System.err.println("Error al listar libros: " + e.getMessage());
        }
        return null;
    }

    public void modificarLibro(int id, String nuevoTitulo, String nuevoIsbn) {
        try {
            Libro libro = new Libro(id, nuevoTitulo, nuevoIsbn);
            libroDAO.updateLibro(libro);
        } catch (Exception e) {
            System.err.println("Error al modificar libro: " + e.getMessage());
        }
    }

    public void eliminarLibro(int id) {
        try {
            libroDAO.deleteLibro(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar libro: " + e.getMessage());
        }
    }
}
