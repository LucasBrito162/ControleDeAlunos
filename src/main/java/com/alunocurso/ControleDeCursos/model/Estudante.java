package com.alunocurso.ControleDeCursos.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private Integer idade;
    @Email(message = "Formato de email invalido")
    private String email;

    @ManyToMany
    private List<Curso> cursos;

    @Enumerated(EnumType.STRING)
    private Periodo periodo;

    public enum Periodo {
        MANHA,
        TARDE,
        NOITE
    }

}
