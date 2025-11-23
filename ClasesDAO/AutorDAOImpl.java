package DAO;

import Clases.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDAOImpl implements AutorDAO {
    @Override
    public void addAutor(Autor autor) throws Exception {
        String sql = "INSERT INTO autor (nombre) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.executeUpdate();
        }
    }

    @Override
    public List<Autor> getAllAutores() throws Exception {
        List<Autor> lista = new ArrayList<>();
        String sql = "SELECT * FROM autor";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Autor a = new Autor();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                lista.add(a);
            }
        }
        return lista;
    }

    @Override
    public Autor getAutorById(int id) throws Exception {
        Autor autor = null;
        String sql = "SELECT * FROM autor WHERE id = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNombre(rs.getString("nombre"));
            }
        }
        return autor;
    }

    @Override
    public void updateAutor(Autor autor) throws Exception {
        String sql = "UPDATE autor SET nombre=? WHERE id=?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setInt(2, autor.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteAutor(int id) throws Exception {
        String sql = "DELETE FROM autor WHERE id=?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}