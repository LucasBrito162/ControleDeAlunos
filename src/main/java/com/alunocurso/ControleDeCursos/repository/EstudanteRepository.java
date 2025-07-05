package com.alunocurso.ControleDeCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunocurso.ControleDeCursos.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
