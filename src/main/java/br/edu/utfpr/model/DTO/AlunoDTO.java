package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Matricula;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO {
    private String name;
    private Matricula matricula;
}
