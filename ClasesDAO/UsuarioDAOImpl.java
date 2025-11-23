package DAO;

import Clases.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void addUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (nombre) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Usuario> getAllUsuarios() throws Exception {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                lista.add(u);
            }
        }
        return lista;
    }

    @Override
    public void updateUsuario(Usuario usuario) throws Exception {
        String sql = "UPDATE usuario SET nombre=? WHERE id=?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setInt(2, usuario.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteUsuario(int id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id=?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}