package com.nestorliteratura.controller;

import com.nestorliteratura.service.BuscarLibro;
import com.nestorliteratura.service.ListarLibros;
import com.nestorliteratura.service.ListarAutores;
import org.springframework.stereotype.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

@Controller
public class Menu {

    private final BuscarLibro buscarLibro;
    private final ListarLibros listarLibros;
    private final ListarAutores listarAutores;

    public Menu(BuscarLibro buscarLibro, ListarLibros listarLibros, ListarAutores listarAutores) {
        this.buscarLibro = buscarLibro;
        this.listarLibros = listarLibros;
        this.listarAutores = listarAutores;
    }

    public void mostrarMenu() {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("""
                    
                    -------------------------------------------------
                    Elija la Opción deseada:
                    1.- Buscar libro por título
                    2.- Listar libros registrados
                    3.- Listar autores registrados
                    4.- Listar autores vivos en un determinado año
                    5.- Listar libros por idioma
                    0.- Salir
                    -------------------------------------------------
                    """);
            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ingrese el nombre del libro que desea buscar:");
                        String tituloLibro = teclado.nextLine();
                        buscarLibro.searchBook(tituloLibro);
                    }
                    case 2 -> listarLibros.listarTodosLosLibros();
                    case 3 -> listarAutores.listarTodosLosAutores();
                    case 4 -> {
                        System.out.println("Ingrese el año:");
                        int ano = teclado.nextInt();
                        listarAutores.listarAutoresVivosEnAno(ano);
                    }
                    case 5 -> {
                        System.out.println("""
                                Ingrese el idioma para buscar los libros:
                                es - Español
                                en - Inglés
                                fr - Francés
                                pt - Portugués
                                """);
                        String idioma = teclado.nextLine();
                        listarLibros.listarLibrosPorIdioma(idioma);
                    }
                    case 0 -> System.out.println("Saliendo de la aplicación...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                teclado.nextLine();
            }
        } while (opcion != 0);
    }
}