package com.nestorliteratura.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class DatosLibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private int numeroDeDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false) // Clave foránea a la tabla `autores`
    private DatosAutorEntity autor;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public int getNumeroDeDescargas() { return numeroDeDescargas; }
    public void setNumeroDeDescargas(int numeroDeDescargas) { this.numeroDeDescargas = numeroDeDescargas; }

    public DatosAutorEntity getAutor() { return autor; }
    public void setAutor(DatosAutorEntity autor) { this.autor = autor; }
}
