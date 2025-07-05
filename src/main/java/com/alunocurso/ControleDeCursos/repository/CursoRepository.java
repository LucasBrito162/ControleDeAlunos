package com.alunocurso.ControleDeCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunocurso.ControleDeCursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
