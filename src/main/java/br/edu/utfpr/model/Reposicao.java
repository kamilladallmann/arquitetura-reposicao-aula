package br.edu.utfpr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "reposicao")
public class Reposicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reposicao")
    private int id;

    @Column(name = "data_reposicao")
    private Date data;

    @Column(name = "qtdd_reposicao")
    private int qtddReposicao;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id_aula")
    private Aula aula;
}
