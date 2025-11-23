package Principal;

import Clases.*;
import DAO.*;
import Servicio.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final LibroDAO libroDAO = new LibroDAOImpl();
    private static final LibroService servicioLibro = new LibroService(libroDAO);
    private static final AutorDAO autorDAO = new AutorDAOImpl();
    private static final AutorService servicioAutor = new AutorService(autorDAO);
    private static final UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    private static final UsuarioService servicioUsuario = new UsuarioService(usuarioDAO);
    private static final PrestamoDAO prestamoDAO = new PrestamoDAOImpl();
    private static final PrestamoService servicioPrestamo = new PrestamoService(prestamoDAO);
    private static final LibroAutorDAO libroAutorDAO = new LibroAutorDAOImpl();
    private static final LibroAutorService servicioLibroAutor = new LibroAutorService(libroAutorDAO);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== MENÚ BIBLIOTECA =====");
            System.out.println("1. Gestionar Autores");
            System.out.println("2. Gestionar Usuarios");
            System.out.println("3. Gestionar Préstamos");
            System.out.println("4. Gestionar Libro-Autor");
            System.out.println("5. Gestionar Libros");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> menuAutores();
                case 2 -> menuUsuarios();
                case 3 -> menuPrestamos();
                case 4 -> menuLibroAutor();
                case 5 -> menuLibros();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción incorrecta.");
            }
        } while (opcion != 0);
    }

    private static void menuAutores() {
        int op;
        do {
            System.out.println("\n--- Gestión de Autores ---");
            System.out.println("1. Añadir autor");
            System.out.println("2. Listar autores");
            System.out.println("3. Buscar autor por ID");
            System.out.println("4. Modificar autor");
            System.out.println("5. Eliminar autor");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1 -> {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        servicioAutor.registrarAutor(nombre);
                    }
                    case 2 -> {
                        var lista = servicioAutor.listarAutores();
                        lista.forEach(x -> System.out.println(x.getId() + " - " + x.getNombre()));
                    }
                    case 3 -> {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Nuevo nombre: ");
                        String nombre = sc.nextLine();
                        servicioAutor.cambiarNombre(id, nombre);
                    }
                    case 4 -> {
                        System.out.print("ID: ");
                        servicioAutor.eliminarAutor(Integer.parseInt(sc.nextLine()));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (op != 0);
    }

    private static void menuUsuarios() {
        int op;
        do {
            System.out.println("\n--- Gestión de Usuarios ---");
            System.out.println("1. Añadir usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Modificar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1 -> {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        servicioUsuario.registrarUsuario(nombre);
                    }
                    case 2 -> servicioUsuario.listarUsuarios()
                            .forEach(u -> System.out.println(u.getId() + " - " + u.getNombre()));
                    case 3 -> {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Nuevo nombre: ");
                        String nombre = sc.nextLine();
                        servicioUsuario.modificarUsuario(id, nombre);
                    }
                    case 4 -> {
                        System.out.print("ID: ");
                        servicioUsuario.eliminarUsuario(Integer.parseInt(sc.nextLine()));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (op != 0);
    }

    private static void menuPrestamos() {
        int op;
        do {
            System.out.println("\n--- Gestión de Préstamos ---");
            System.out.println("1. Añadir préstamo");
            System.out.println("2. Listar préstamos");
            System.out.println("3. Eliminar préstamo");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1 -> {
                        System.out.print("ID usuario: ");
                        Usuario u = new Usuario(Integer.parseInt(sc.nextLine()), null);
                        System.out.print("ID libro: ");
                        Libro l = new Libro(Integer.parseInt(sc.nextLine()), null, null);
                        System.out.print("Fecha inicio (YYYY-MM-DD): ");
                        LocalDate fi = LocalDate.parse(sc.nextLine());
                        System.out.print("Fecha fin (YYYY-MM-DD): ");
                        LocalDate ff = LocalDate.parse(sc.nextLine());
                        Prestamo p = new Prestamo(0, fi, ff, u, l);
                        servicioPrestamo.registrarPrestamo(p);
                    }
                    case 2 -> servicioPrestamo.listarPrestamos()
                            .forEach(p -> System.out.println(p.getId() + " - " + p.getFechaInicio() + " a " + p.getFechaFin()));
                    case 3 -> {
                        System.out.print("ID: ");
                        servicioPrestamo.eliminarPrestamo(Integer.parseInt(sc.nextLine()));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (op != 0);
    }

    private static void menuLibroAutor() {
        int op;
        do {
            System.out.println("\n--- Relación Libro-Autor ---");
            System.out.println("1. Relacionar libro con autor");
            System.out.println("2. Eliminar relación libro-autor");
            System.out.println("3. Ver autores de un libro");
            System.out.println("4. Ver libros de un autor");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1 -> {
                        System.out.print("ID libro: ");
                        int idL = Integer.parseInt(sc.nextLine());
                        System.out.print("ID autor: ");
                        int idA = Integer.parseInt(sc.nextLine());
                        servicioLibroAutor.relacionarLibroAutor(idL, idA);
                    }
                    case 2 -> {
                        System.out.print("ID libro: ");
                        int idL = Integer.parseInt(sc.nextLine());
                        System.out.print("ID autor: ");
                        int idA = Integer.parseInt(sc.nextLine());
                        servicioLibroAutor.eliminarRelacion(idL, idA);
                    }
                    case 3 -> {
                        System.out.print("ID libro: ");
                        servicioLibroAutor.obtenerAutoresDeLibro(Integer.parseInt(sc.nextLine()))
                                .forEach(a -> System.out.println(a.getId() + " - " + a.getNombre()));
                    }
                    case 4 -> {
                        System.out.print("ID autor: ");
                        servicioLibroAutor.obtenerLibrosDeAutor(Integer.parseInt(sc.nextLine()))
                                .forEach(l -> System.out.println(l.getId() + " - " + l.getTitulo()));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (op != 0);
    }
    private static void menuLibros() {
        int op;
        do {
            System.out.println("\n--- Gestión de Libros ---");
            System.out.println("1. Añadir libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro por ID");
            System.out.println("4. Modificar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1 -> {
                        System.out.print("Título: ");
                        String titulo = sc.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = sc.nextLine();
                        servicioLibro.registrarLibro(titulo, isbn);
                    }
                    case 2 -> {
                        var lista = servicioLibro.listarLibros();
                        lista.forEach(l -> System.out.println(l.getId() + " - " + l.getTitulo() + " (ISBN: " + l.getIsbn() + ")"));
                    }
                    case 3 -> {
                        System.out.print("ID del libro: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Nuevo título: ");
                        String titulo = sc.nextLine();
                        System.out.print("Nuevo ISBN: ");
                        String isbn = sc.nextLine();
                        servicioLibro.modificarLibro(id, titulo, isbn);
                    }
                    case 4 -> {
                        System.out.print("ID del libro: ");
                        int id = Integer.parseInt(sc.nextLine());
                        servicioLibro.eliminarLibro(id);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (op != 0);
    }

}