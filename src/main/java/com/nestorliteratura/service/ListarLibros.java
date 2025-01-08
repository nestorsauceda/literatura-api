package com.nestorliteratura.service;

import com.nestorliteratura.entity.DatosLibroEntity;
import com.nestorliteratura.repository.DatosLibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarLibros {

    private final DatosLibroRepository libroRepository;

    public ListarLibros(DatosLibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void listarTodosLosLibros() {
        List<DatosLibroEntity> libros = libroRepository.findAll();

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
            return;
        }

        libros.forEach(libro -> {
            System.out.println("""
                    
                    *********** LIBRO ***********
                    Titulo: %s
                    Autor: %s
                    Idioma: %s
                    Número de descargas: %d
                    *****************************
                    """.formatted(
                    libro.getTitulo(),
                    libro.getAutor().getNombre(),
                    libro.getIdioma(),
                    libro.getNumeroDeDescargas()
            ));
        });
    }

    public void listarLibrosPorIdioma(String idioma) {
        List<DatosLibroEntity> libros = libroRepository.findByIdioma(idioma);

        if (libros.isEmpty()) {
            System.out.println("No hay libros en el idioma " + idioma + " registrados en la base de datos.");
            return;
        }

        libros.forEach(libro -> {
            System.out.println("""
                    
                    *********** LIBRO ***********
                    Titulo: %s
                    Autor: %s
                    Idioma: %s
                    Número de descargas: %d
                    *****************************
                    """.formatted(
                    libro.getTitulo(),
                    libro.getAutor().getNombre(),
                    libro.getIdioma(),
                    libro.getNumeroDeDescargas()
            ));
        });
    }
}