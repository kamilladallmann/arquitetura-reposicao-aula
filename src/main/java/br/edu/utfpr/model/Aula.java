package br.edu.utfpr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "aula")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private int id;

    @Column(name = "nome_aula")
    private String nome;

    @Column(name = "eh_presencial")
    private Boolean presencial;

    @Column(name = "data_aula")
    private Date data;

    @Column(name = "qtdd_aula")
    private int qtddAula;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;
}
