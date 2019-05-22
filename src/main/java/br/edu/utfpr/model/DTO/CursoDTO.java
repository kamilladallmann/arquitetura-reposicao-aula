package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Aluno;
import br.edu.utfpr.model.Departamento;
import br.edu.utfpr.model.Disciplina;
import br.edu.utfpr.model.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDTO {

    private String nome;
    private Disciplina disciplina;
    private Professor professor;
    private Departamento departamento;
    private Aluno aluno;
}
