package DAO;

import Clases.Usuario;

import java.util.List;

public interface AutorDAO {
    void addAutor(Usuario usuario) throws Exception;
    List<Usuario> getAllAutor() throws Exception;
    void updateAutor(Usuario usuario) throws Exception;
    void deleteAutor(int id) throws Exception;

}
