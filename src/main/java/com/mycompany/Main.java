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

}