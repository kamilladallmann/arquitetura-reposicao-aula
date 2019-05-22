package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Curso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoDTO {
    private String nome;
    private Curso curso;
}
