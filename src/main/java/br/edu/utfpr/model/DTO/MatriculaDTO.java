package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Aluno;
import br.edu.utfpr.model.Disciplina;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatriculaDTO {
    private Aluno aluno;
    private Disciplina disciplina;
}
