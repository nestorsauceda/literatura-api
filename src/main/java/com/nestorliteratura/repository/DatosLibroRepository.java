package com.nestorliteratura.repository;

import com.nestorliteratura.entity.DatosLibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DatosLibroRepository extends JpaRepository<DatosLibroEntity, Long> {
    Optional<DatosLibroEntity> findByTitulo(String titulo);
    List<DatosLibroEntity> findByIdioma(String idioma);
}