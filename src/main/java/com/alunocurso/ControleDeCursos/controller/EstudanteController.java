package com.alunocurso.ControleDeCursos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunocurso.ControleDeCursos.model.Estudante;
import com.alunocurso.ControleDeCursos.repository.EstudanteRepository;

@RestController
@RequestMapping("/estudante")

public class EstudanteController {

    private final EstudanteRepository estudanteRepository;

    public EstudanteController(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    @PostMapping
    public ResponseEntity<Estudante> create(@RequestBody Estudante estudante) {
        Estudante saved = estudanteRepository.save(estudante);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Estudante>> buscarEstudante() {
        List<Estudante> list = estudanteRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarId(@PathVariable Long id) {
        return estudanteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizar(@PathVariable Long id, @RequestBody Estudante atualizarEstudante) {
        return estudanteRepository.findById(id)
                .map(existeEstudante -> {
                    existeEstudante.setNome(atualizarEstudante.getNome());
                    existeEstudante.setIdade(atualizarEstudante.getIdade());
                    existeEstudante.setPeriodo(atualizarEstudante.getPeriodo());
                    existeEstudante.setEmail(atualizarEstudante.getEmail());
                    existeEstudante.setCursos(atualizarEstudante.getCursos());

                    Estudante saved = estudanteRepository.save(existeEstudante);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!estudanteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estudanteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
