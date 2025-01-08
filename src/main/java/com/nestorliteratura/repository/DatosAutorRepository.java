package com.nestorliteratura.repository;

import com.nestorliteratura.entity.DatosAutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosAutorRepository extends JpaRepository<DatosAutorEntity, Long> {

    @Query("SELECT a FROM DatosAutorEntity a LEFT JOIN FETCH a.libros WHERE a.nombre = :nombre")
    Optional<DatosAutorEntity> findByNombreWithLibros(String nombre);
}
