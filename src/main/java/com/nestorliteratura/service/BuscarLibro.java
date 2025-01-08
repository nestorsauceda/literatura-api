package com.nestorliteratura.service;

import com.nestorliteratura.entity.DatosAutorEntity;
import com.nestorliteratura.entity.DatosLibroEntity;
import com.nestorliteratura.model.Datos;
import com.nestorliteratura.repository.DatosAutorRepository;
import com.nestorliteratura.repository.DatosLibroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarLibro {

    private final DatosLibroRepository libroRepository;
    private final DatosAutorRepository autorRepository;

    public BuscarLibro(DatosLibroRepository libroRepository, DatosAutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void searchBook(String nombre) {
        final String URL_BASE = "https://gutendex.com/books/";
        var consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + nombre.replace(" ", "+"));
        ConvierteDatos conversor = new ConvierteDatos();
        var datos = conversor.obtenerDatos(json, Datos.class);

        if (datos.resultados() != null && !datos.resultados().isEmpty()) {
            var datosLibro = datos.resultados().get(0);

            // Verificar si el libro ya está en la base de datos
            if (libroRepository.findByTitulo(datosLibro.titulo()).isPresent()) {
                System.out.println("El libro ya existe en la base de datos.");
                return;
            }
            // Imprimir el libro en consola
            System.out.println("""
                    
                    *********** LIBRO ***********
                    Titulo: %s
                    Autor: %s
                    Idioma: %s
                    Número de descargas: %d
                    *****************************
                    """.formatted(
                    datosLibro.titulo(),
                    datosLibro.autor().get(0).nombre(),
                    String.join(", ", datosLibro.idioma()),
                    datosLibro.numeroDeDescargas()
            ));

            // Crear el objeto del libro
            DatosLibroEntity libroEntity = new DatosLibroEntity();
            libroEntity.setTitulo(datosLibro.titulo());
            libroEntity.setIdioma(String.join(", ", datosLibro.idioma()));
            libroEntity.setNumeroDeDescargas(datosLibro.numeroDeDescargas());

            // Verificar si el autor ya existe con sus libros
            String nombreAutor = datosLibro.autor().get(0).nombre();
            DatosAutorEntity autorEntity = autorRepository.findByNombreWithLibros(nombreAutor)
                    .orElseGet(() -> { // Si no existe, crear un nuevo autor
                        DatosAutorEntity nuevoAutor = new DatosAutorEntity();
                        nuevoAutor.setNombre(nombreAutor);
                        nuevoAutor.setFechaDeNacimiento(datosLibro.autor().get(0).fechaDeNacimiento());
                        nuevoAutor.setFechaDeFallecimiento(datosLibro.autor().get(0).fechaDeFallecimiento());
                        nuevoAutor.setLibros(new ArrayList<>());
                        return nuevoAutor;
                    });

            // Asociar el libro al autor
            libroEntity.setAutor(autorEntity);
            autorEntity.getLibros().add(libroEntity);

            // Guardar autor y libro
            autorRepository.save(autorEntity); // Se guarda el autor con los libros relacionados
            System.out.println("Libro y autor guardados exitosamente.");
        } else {
            System.out.println("No se encontraron libros.");
        }
    }
}
