package com.alunocurso.ControleDeCursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alunocurso.ControleDeCursos.model.Curso;
import com.alunocurso.ControleDeCursos.repository.CursoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso create(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> buscarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com id: " + id));
    }

    public void delete(Long id) {
        if (!cursoRepository.existsById(id)) {
            throw new EntityNotFoundException("Curso não encontrado com id: " + id);
        }
        cursoRepository.deleteById(id);
    }
}
