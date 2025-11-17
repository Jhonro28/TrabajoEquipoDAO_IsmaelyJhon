package DAO;

import java.util.List;
import Clases.Libro;

    public interface LibroDAO {
        void addLibro(Libro libro) throws Exception;
        List<Libro> getAllLibros() throws Exception;
        void updateLibro(Libro libro) throws Exception;
        void deleteLibro(int id) throws Exception;
    }

