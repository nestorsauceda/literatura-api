package com.nestorliteratura.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "autores")
public class DatosAutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fechaDeNacimiento;
    private String fechaDeFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatosLibroEntity> libros;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFechaDeNacimiento() { return fechaDeNacimiento; }
    public void setFechaDeNacimiento(String fechaDeNacimiento) { this.fechaDeNacimiento = fechaDeNacimiento; }

    public String getFechaDeFallecimiento() { return fechaDeFallecimiento; }
    public void setFechaDeFallecimiento(String fechaDeFallecimiento) { this.fechaDeFallecimiento = fechaDeFallecimiento; }

    public List<DatosLibroEntity> getLibros() { return libros; }
    public void setLibros(List<DatosLibroEntity> libros) { this.libros = libros; }
}
