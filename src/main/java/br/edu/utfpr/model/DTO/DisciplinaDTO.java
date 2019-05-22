package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Aula;
import br.edu.utfpr.model.Curso;
import br.edu.utfpr.model.Matricula;
import br.edu.utfpr.model.Professor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplinaDTO {
    private String nome;
    private Professor professor;
    private Aula aula;
    private Curso curso;
    private Matricula matricula;
}
