package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Disciplina;
import br.edu.utfpr.model.Professor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AulaDTO {
    private String nome;
    private Boolean ehPresencial;
    private Date data;
    private int qtdd;
    private Professor professor;
    private Disciplina disciplina;
}
