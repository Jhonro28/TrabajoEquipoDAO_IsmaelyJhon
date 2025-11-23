package DAO;

import Clases.Prestamo;
import Clases.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAOImpl implements PrestamoDAO {

    @Override
    public void addPrestamo(Prestamo prestamo) throws Exception {
        String sql = "INSERT INTO prestamo (idUsuario, idLibro, fechaInicio, fechaFin) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestamo.getUsuario().getId());
            stmt.setInt(2, prestamo.getLibro().getId());
            stmt.setDate(3, Date.valueOf(prestamo.getFechaInicio()));
            stmt.setDate(4, Date.valueOf(prestamo.getFechaFin()));

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Prestamo> getAllPrestamo() throws Exception {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setId(rs.getInt("id"));
                p.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                p.setFechaFin(rs.getDate("fechaFin").toLocalDate());

                lista.add(p);
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
    public void deletePrestamo(int id) throws Exception {
        String sql = "DELETE FROM prestamo WHERE id=?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}