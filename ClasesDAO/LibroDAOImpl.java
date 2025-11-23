package DAO;

import Clases.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO{
    private Connection conn = ConnectionManager.getConnection();

    public LibroDAOImpl() throws SQLException {
    }

    @Override
    public void addLibro(Libro libro) throws Exception {
        String sql = "INSERT INTO libros(titulo, isbn) VALUES(?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getIsbn());
        ps.executeUpdate();
    }

    @Override
    public List<Libro> getAllLibros() throws Exception {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, isbn FROM libros";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Libro(rs.getInt("id"), rs.getString("titulo"), rs.getString("isbn")));
            }
        return lista;
    }

    public void updateLibro(Libro libro) throws Exception {
        String sql = "UPDATE libro SET titulo=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setInt(2, libro.getId());
        ps.executeUpdate();
        System.out.println("DAO: Libro actualizado -> " + libro);
    }

    @Override
    public void deleteLibro(int id) throws Exception {
        String sql = "DELETE FROM libro WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("DAO: Libro eliminado (id=" + id + ")");
    }
}

