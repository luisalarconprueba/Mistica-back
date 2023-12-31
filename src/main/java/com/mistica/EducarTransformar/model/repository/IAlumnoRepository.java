package com.mistica.EducarTransformar.model.repository;

import com.mistica.EducarTransformar.model.entity.Alumno;
import com.mistica.EducarTransformar.model.entity.Materia;
import com.mistica.EducarTransformar.model.entity.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {
    @Query("SELECT a.id FROM Alumno a WHERE a.usuario.id = :usuarioId")
    Long findAlumnoIdByUsuarioId(@Param("usuarioId") Long usuarioId);

    @Query("SELECT a FROM Alumno a JOIN a.materias m WHERE m.id = :materiaId")
    List<Alumno> findAlumnosByMateriaId(@Param("materiaId") Long materiaId);
}
