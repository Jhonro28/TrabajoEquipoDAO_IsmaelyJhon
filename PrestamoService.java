package Servicio;

import DAO.PrestamoDAO;
import Clases.Prestamo;
import java.util.List;

public class PrestamoService {

    private PrestamoDAO prestamoDAO;

    public PrestamoService(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public void registrarPrestamo(Prestamo prestamo) {
        try {
            prestamoDAO.addPrestamo(prestamo);
        } catch (Exception e) {
            System.err.println("Error al registrar préstamo: " + e.getMessage());
        }
    }

    public List<Prestamo> listarPrestamos() {
        try {
            return prestamoDAO.getAllPrestamo();
        } catch (Exception e) {
            System.err.println("Error al listar préstamos: " + e.getMessage());
            return List.of();
        }
    }

    public void actualizarPrestamo(Prestamo prestamo) {
        try {
            prestamoDAO.updatePrestamo(prestamo);
        } catch (Exception e) {
            System.err.println("Error al actualizar préstamo: " + e.getMessage());
        }
    }

    public void eliminarPrestamo(int id) {
        try {
            prestamoDAO.deletePrestamo(id);
        } catch (Exception e) {
            System.err.println("Error al eliminar préstamo: " + e.getMessage());
        }
    }
}