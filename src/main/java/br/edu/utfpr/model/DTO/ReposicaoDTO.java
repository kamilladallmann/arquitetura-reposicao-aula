package br.edu.utfpr.model.DTO;

import br.edu.utfpr.model.Aula;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
public class ReposicaoDTO {
    private Date data;
    private int qtddReposicao;
    private Aula aula;
}
