package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Departamento;
import br.edu.utfpr.model.Disciplina;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO {
    private String nome;
    private Boolean ativo;
    private String siape;
    private Disciplina disciplina;
    private Departamento departamento;
}
