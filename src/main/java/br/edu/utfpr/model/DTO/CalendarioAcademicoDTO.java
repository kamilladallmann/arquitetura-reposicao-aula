package br.edu.utfpr.model.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import java.util.Date;

@Getter
@Setter
public class CalendarioAcademicoDTO {
    private Date dataInicio;
    private Date dataFim;

}
