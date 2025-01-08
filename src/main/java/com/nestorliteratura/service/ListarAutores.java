
package com.nestorliteratura.service;

import com.nestorliteratura.repository.DatosAutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@Service
public class ListarAutores {

    private final DatosAutorRepository autorRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ListarAutores(DatosAutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Transactional
    public void listarTodosLosAutores() {
        var autores = autorRepository.findAll();

        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados en la base de datos.");
        } else {
            autores.forEach(autor -> {
                String libros = autor.getLibros()
                        .stream()
                        .map(libro -> libro.getTitulo())
                        .collect(Collectors.joining(", "));

                System.out.println("""

                        Autor: %s
                        Fecha de nacimiento: %s
                        Fecha de fallecimiento: %s
                        Libros: [%s]
                        """.formatted(
                        autor.getNombre(),
                        autor.getFechaDeNacimiento() != null ? autor.getFechaDeNacimiento() : "Desconocida",
                        autor.getFechaDeFallecimiento() != null ? autor.getFechaDeFallecimiento() : "Desconocida",
                        libros
                ));
            });
        }
    }

    @Transactional
    public void listarAutoresVivosEnAno(int ano) {
        var autores = autorRepository.findAll();

        var autoresVivos = autores.stream()
                .filter(autor -> {
                    LocalDate fechaNacimiento = autor.getFechaDeNacimiento() != null ? parseDate(autor.getFechaDeNacimiento()) : null;
                    LocalDate fechaFallecimiento = autor.getFechaDeFallecimiento() != null ? parseDate(autor.getFechaDeFallecimiento()) : null;
                    return (fechaNacimiento != null && fechaNacimiento.getYear() <= ano) &&
                            (fechaFallecimiento == null || fechaFallecimiento.getYear() >= ano);
                })
                .collect(Collectors.toList());

        if (autoresVivos.isEmpty()) {
            System.out.println("No hay autores vivos en el año " + ano + " registrados en la base de datos.");
        } else {
            autoresVivos.forEach(autor -> {
                String libros = autor.getLibros()
                        .stream()
                        .map(libro -> libro.getTitulo())
                        .collect(Collectors.joining(", "));

                System.out.println("""

                        Autor: %s
                        Fecha de nacimiento: %s
                        Fecha de fallecimiento: %s
                        Libros: [%s]
                        """.formatted(
                        autor.getNombre(),
                        autor.getFechaDeNacimiento() != null ? autor.getFechaDeNacimiento() : "Desconocida",
                        autor.getFechaDeFallecimiento() != null ? autor.getFechaDeFallecimiento() : "Desconocida",
                        libros
                ));
            });
        }
    }

    private LocalDate parseDate(String date) {
        if (date.length() == 4) {
            return LocalDate.of(Integer.parseInt(date), 1, 1);
        } else if (date.length() == 3) {
            return LocalDate.of(Integer.parseInt("0" + date), 1, 1);
        } else {
            return LocalDate.parse(date, formatter);
        }
    }
}