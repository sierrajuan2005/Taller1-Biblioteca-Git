package com.mycompany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Libro> libros = new ArrayList<>();
    static ArrayList<Prestamo> prestamos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTION DE BIBLIOTECA =====");
            System.out.println("--- Clientes ---");
            System.out.println("1. Crear cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("--- Libros ---");
            System.out.println("6. Crear libro");
            System.out.println("7. Listar libros");
            System.out.println("8. Buscar libro");
            System.out.println("9. Actualizar libro");
            System.out.println("10. Eliminar libro");
            System.out.println("--- Prestamos ---");
            System.out.println("11. Registrar prestamo");
            System.out.println("12. Registrar devolucion");
            System.out.println("13. Listar prestamos activos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    crearCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    System.out.print("ID del cliente a buscar: ");
                    String idBuscarCliente = sc.nextLine();
                    Cliente clienteEncontrado = buscarCliente(idBuscarCliente);
                    System.out.println(clienteEncontrado != null ? clienteEncontrado : "Cliente no encontrado.");
                    break;
                case 4:
                    actualizarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 6:
                    crearLibro();
                    break;
                case 7:
                    listarLibros();
                    break;
                case 8:
                    System.out.print("Codigo del libro a buscar: ");
                    String codigoBuscarLibro = sc.nextLine();
                    Libro libroEncontrado = buscarLibro(codigoBuscarLibro);
                    System.out.println(libroEncontrado != null ? libroEncontrado : "Libro no encontrado.");
                    break;
                case 9:
                    actualizarLibro();
                    break;
                case 10:
                    eliminarLibro();
                    break;
                case 11:
                    crearPrestamo();
                    break;
                case 12:
                    devolucion();
                    break;
                case 13:
                    listarPrestamos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    public static void crearCliente() {
        System.out.println("\n--- Crear Cliente ---");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Telefono: ");
        String telefono = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(id, nombre, telefono, email);
        clientes.add(cliente);
        System.out.println("Cliente creado exitosamente.");
    }

    public static void listarClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }
    public static Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static void actualizarCliente() {
        System.out.print("\nID del cliente a actualizar: ");
        String id = sc.nextLine();
        Cliente cliente = buscarCliente(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (" + cliente.getNombre() + "): ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo telefono (" + cliente.getTelefono() + "): ");
        String telefono = sc.nextLine();
        System.out.print("Nuevo email (" + cliente.getEmail() + "): ");
        String email = sc.nextLine();

        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);
        cliente.setEmail(email);

        System.out.println("Cliente actualizado exitosamente.");
    }

    public static void eliminarCliente() {
        System.out.print("\nID del cliente a eliminar: ");
        String id = sc.nextLine();
        Cliente cliente = buscarCliente(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        clientes.remove(cliente);
        System.out.println("Cliente eliminado exitosamente.");
    }
// --------------------------- CRUD lIBRO---------------------------------

    public static void crearLibro() {
        System.out.println("\n--- Crear Libro ---");
        System.out.print("Codigo: ");
        String codigo = sc.nextLine();
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Año de publicacion: ");
        String anio = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();

        Libro libro = new Libro(codigo, titulo, anio, autor, true);
        libros.add(libro);
        System.out.println("Libro creado exitosamente.");
    }


    public static void listarLibros() {
        System.out.println("\n--- Lista de Libros ---");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public static Libro buscarLibro(String codigo) {
        for (Libro l : libros) {
            if (l.getCodigo().equals(codigo)) {
                return l;
            }
        }
        return null;
    }

    public static void actualizarLibro() {
        System.out.print("\nCodigo del libro a actualizar: ");
        String codigo = sc.nextLine();
        Libro libro = buscarLibro(codigo);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.print("Nuevo titulo (" + libro.getTitulo() + "): ");
        String titulo = sc.nextLine();
        System.out.print("Nuevo año (" + libro.getAnioPublicacion() + "): ");
        String anio = sc.nextLine();
        System.out.print("Nuevo autor (" + libro.getAutor() + "): ");
        String autor = sc.nextLine();

        libro.setTitulo(titulo);
        libro.setAnioPublicacion(anio);
        libro.setAutor(autor);

        System.out.println("Libro actualizado exitosamente.");
    }

    public static void eliminarLibro() {
        System.out.print("\nCodigo del libro a eliminar: ");
        String codigo = sc.nextLine();
        Libro libro = buscarLibro(codigo);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        libros.remove(libro);
        System.out.println("Libro eliminado exitosamente.");
    }

    //--------------------- prestamos ---------------------------

    public static void crearPrestamo() {
        System.out.println("\n--- Registrar Prestamo ---");
        System.out.print("ID del prestamo: ");
        String idPrestamo = sc.nextLine();

        System.out.print("ID del cliente: ");
        String idCliente = sc.nextLine();
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Codigo del libro: ");
        String codigoLibro = sc.nextLine();
        Libro libro = buscarLibro(codigoLibro);
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        if (!libro.isDisponible()) {
            System.out.println("El libro no esta disponible.");
            return;
        }

        Prestamo prestamo = new Prestamo(idPrestamo, cliente, libro, LocalDate.now(), "ACTIVO");
        prestamos.add(prestamo);
        libro.setDisponible(false);

        System.out.println("Prestamo registrado exitosamente.");
    }



    public static void devolucion() {
        System.out.print("\nID del prestamo a devolver: ");
        String idPrestamo = sc.nextLine();

        for (Prestamo p : prestamos) {
            if (p.getIdPrestamo().equals(idPrestamo) && p.getEstado().equals("ACTIVO")) {
                p.setEstado("DEVUELTO");
                p.getLibro().setDisponible(true);
                System.out.println("Devolucion registrada exitosamente.");
                return;
            }
        }
        System.out.println("Prestamo activo no encontrado.");
    }

    public static void listarPrestamos() {
        System.out.println("\n--- Prestamos Activos ---");
        boolean hayActivos = false;
        for (Prestamo p : prestamos) {
            if (p.getEstado().equals("ACTIVO")) {
                System.out.println(p);
                hayActivos = true;
            }
        }
        if (!hayActivos) {
            System.out.println("No hay prestamos activos.");
        }
    }

}