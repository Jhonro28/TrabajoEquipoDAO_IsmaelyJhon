package DAO;

import Clases.Autor;
import Clases.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroAutorDAOImpl implements LibroAutorDAO {

    @Override
    public void insertar(int idLibro, int idAutor) throws Exception {
        String sql = "INSERT INTO libro_autor (idLibro, idAutor) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLibro);
            stmt.setInt(2, idAutor);
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(int idLibro, int idAutor) throws Exception {
        String sql = "DELETE FROM libro_autor WHERE idLibro = ? AND idAutor = ?";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLibro);
            stmt.setInt(2, idAutor);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Autor> obtenerAutoresDeLibro(int idLibro) throws Exception {
        List<Autor> autores = new ArrayList<>();
        String sql = "SELECT a.id, a.nombre FROM autor a JOIN libro_autor la ON a.id = la.idAutor WHERE la.idLibro = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idLibro);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNombre(rs.getString("nombre"));
                autores.add(autor);
            }
        }
        return autores;
    }

    @Override
    public List<Libro> obtenerLibrosDeAutor(int idAutor) throws Exception {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT l.id, l.titulo, l.isbn FROM libro l JOIN libro_autor la ON l.id = la.idLibro WHERE la.idAutor = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAutor);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Libro libro = new Libro();
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setIsbn(rs.getString("isbn"));
                libros.add(libro);
            }
        }
        return libros;
    }
}