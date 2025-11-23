package DAO;

import Clases.Autor;
import Clases.Libro;

import java.util.List;

public interface LibroAutorDAO {
    void insertar(int idLibro, int idAutor) throws Exception;
    void eliminar(int idLibro, int idAutor) throws Exception;
    List<Autor> obtenerAutoresDeLibro(int idLibro) throws Exception;
    List<Libro> obtenerLibrosDeAutor(int idAutor) throws Exception;
}