package Servicio;

import DAO.UsuarioDAO;
import Clases.Usuario;
import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void registrarUsuario(String nombre) {
        try {
            Usuario u = new Usuario(nombre);
            usuarioDAO.addUsuario(u);
        } catch (Exception e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDAO.getAllUsuarios();
        } catch (Exception e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        }
        return null;
    }

    public void modificarUsuario(int id, String nuevoNombre) {
        try {
            Usuario u = new Usuario(id, nuevoNombre);
            usuarioDAO.updateUsuario(u);
        } catch (Exception e) {
            System.err.println("Error al modificar usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioDAO.deleteUsuario(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}

