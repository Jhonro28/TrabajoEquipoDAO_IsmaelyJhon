package DAO;

import Clases.Libro;
import Clases.Prestamo;
import Clases.Usuario;

import java.util.List;

public interface PrestamoDAO {

    void addPrestamo(Prestamo prestamo) throws Exception;
    List<Prestamo> getAllPrestamo() throws Exception;
    void updateUsuario(Usuario usuario) throws Exception;
    void deletePrestamo(int id) throws Exception;

}
