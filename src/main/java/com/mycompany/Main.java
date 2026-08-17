package com.mycompany;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
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



}