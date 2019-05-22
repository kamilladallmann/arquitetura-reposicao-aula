package br.edu.utfpr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private int id;

    @Column(name = "nome_disciplina")
    private String nome;

    @OneToMany(mappedBy = "disciplina")
    private Set<Professor> professor;

    @OneToMany(mappedBy = "disciplina")
    private Set<Aula> aula;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToMany(mappedBy = "disciplina")
    private Set<Matricula> matricula;
}
