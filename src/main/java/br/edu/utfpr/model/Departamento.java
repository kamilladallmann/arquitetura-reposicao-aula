package br.edu.utfpr.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private int id;

    @Column(name = "nome_departamento")
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private Set<Curso> curso;

}
