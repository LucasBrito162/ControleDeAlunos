package com.alunocurso.ControleDeCursos.service;

import java.util.List;

import com.alunocurso.ControleDeCursos.model.Estudante;
import com.alunocurso.ControleDeCursos.repository.EstudanteRepository;

import jakarta.persistence.EntityNotFoundException;

public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public Estudante create(Estudante estudante) {
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
