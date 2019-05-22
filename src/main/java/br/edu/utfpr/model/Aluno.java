package br.edu.utfpr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private int id;

    @Column(name = "nome_aluno")
    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Set<Matricula> matricula;

}
