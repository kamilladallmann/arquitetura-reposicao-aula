package br.edu.utfpr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private int id;

    @Column(name = "nome_professor")
    private String nome;

    @Column(name = "siape")
    private int siape;

    @Column(name = "esta_ativo")
    private Boolean ativo;

    @OneToMany(mappedBy = "professor")
    private Set<Disciplina> disciplina;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}
