package com.nestorliteratura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(

        @JsonAlias("title") String titulo,

        @JsonAlias("authors") List<DatosAutor> autor,

        @JsonAlias("languages") List<String> idioma,

        @JsonAlias("download_count") int numeroDeDescargas
) {
    @Override
    public String toString() {
        return
                "\n*********** LIBRO ***********" +
                        "\nTitulo: " + titulo +
                        "\nAutor: " + autor.get(0).nombre() +
                        "\nIdioma: " + String.join(", ", idioma) +
                        "\nNúmero de descargas: " + numeroDeDescargas +
                        "\n*****************************";
    }
}
