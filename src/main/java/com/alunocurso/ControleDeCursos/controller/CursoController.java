package com.alunocurso.ControleDeCursos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunocurso.ControleDeCursos.model.Curso;
import com.alunocurso.ControleDeCursos.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        Curso saved = cursoRepository.save(curso);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> buscaCursos() {
        List<Curso> list = cursoRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{/id}")
    public ResponseEntity<Curso> buscarId(@PathVariable Long id) {
        return cursoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
