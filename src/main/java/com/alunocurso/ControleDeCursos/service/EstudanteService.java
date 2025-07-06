package com.alunocurso.ControleDeCursos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alunocurso.ControleDeCursos.model.Curso;
import com.alunocurso.ControleDeCursos.model.Estudante;
import com.alunocurso.ControleDeCursos.repository.CursoRepository;
import com.alunocurso.ControleDeCursos.repository.EstudanteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    private final CursoRepository cursoRepository;

    public EstudanteService(EstudanteRepository estudanteRepository, CursoRepository cursoRepository) {
        this.estudanteRepository = estudanteRepository;
        this.cursoRepository = cursoRepository;
    }

    public Estudante create(Estudante estudante) {

        List<Curso> validarCurso = estudante.getCursos().stream()
                .map(curso -> cursoRepository.findById(curso.getId())
                        .orElseThrow(
                                () -> new EntityNotFoundException("Curso não encontrado com ID: " + curso.getId())))
                .toList();

        estudante.setCursos(validarCurso);

        return estudanteRepository.save(estudante);
    }

    public List<Estudante> buscarEstudante() {
        return estudanteRepository.findAll();
    }

    public Estudante buscarId(Long id) {
        return estudanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Estudante não encontrado com id: " + id));
    }

    public Estudante atualizar(Long id, Estudante novoestudante) {
        Estudante existing = buscarId(id);
        existing.setNome(novoestudante.getNome());
        existing.setIdade(novoestudante.getIdade());
        existing.setEmail(novoestudante.getEmail());
        existing.setCursos(novoestudante.getCursos());
        existing.setPeriodo(novoestudante.getPeriodo());
        return estudanteRepository.save(existing);
    }

    public void delete(Long id) {
        if (!estudanteRepository.existsById(id)) {
            throw new EntityNotFoundException("Estudante não encontrado com id: " + id);
        }
        estudanteRepository.deleteById(id);
    }
}
