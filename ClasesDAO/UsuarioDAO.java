package DAO;

import Clases.Libro;
import Clases.Usuario;

import java.util.List;

public interface UsuarioDAO {

        void addUsuario(Usuario usuario) throws Exception;
        List<Usuario> getAllUsuarios() throws Exception;
        void updateUsuario(Usuario usuario) throws Exception;
        void deleteUsuario(int id) throws Exception;

}
