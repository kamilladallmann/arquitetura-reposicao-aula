package br.edu.utfpr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int id;

    @Column(name = "nome_curso")
    private String nome;

    @OneToMany(mappedBy = "curso")
    private Set<Disciplina> disciplina;

    @OneToMany(mappedBy = "curso")
    private Set<Professor> professor;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @OneToMany(mappedBy = "curso")
    private Set<Aluno> aluno;
}
