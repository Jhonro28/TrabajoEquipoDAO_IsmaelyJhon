package Servicio;

import DAO.LibroAutorDAO;
import Clases.Autor;
import Clases.Libro;
import java.util.List;

public class LibroAutorService {

    private LibroAutorDAO libroAutorDAO;

    public LibroAutorService(LibroAutorDAO libroAutorDAO) {
        this.libroAutorDAO = libroAutorDAO;
    }

    public void relacionarLibroAutor(int idLibro, int idAutor) {
        try {
            libroAutorDAO.insertar(idLibro, idAutor);
        } catch (Exception e) {
            System.err.println("Error al relacionar libro y autor: " + e.getMessage());
        }
    }

    public void eliminarRelacion(int idLibro, int idAutor) {
        try {
            libroAutorDAO.eliminar(idLibro, idAutor);
        } catch (Exception e) {
            System.err.println("Error al eliminar relación libro-autor: " + e.getMessage());
        }
    }

    public List<Autor> obtenerAutoresDeLibro(int idLibro) {
        try {
            return libroAutorDAO.obtenerAutoresDeLibro(idLibro);
        } catch (Exception e) {
            System.err.println("Error al obtener autores del libro: " + e.getMessage());
        }
        return null;
    }

    public List<Libro> obtenerLibrosDeAutor(int idAutor) {
        try {
            return libroAutorDAO.obtenerLibrosDeAutor(idAutor);
        } catch (Exception e) {
            System.err.println("Error al obtener libros del autor: " + e.getMessage());
        }
        return null;
    }
}

