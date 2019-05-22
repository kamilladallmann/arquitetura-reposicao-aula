package br.edu.utfpr.regrasDeNegocio;

import br.edu.utfpr.DAO.ReposicaoDAO;
import br.edu.utfpr.exceptions.dataDeAntecipaçãoForaDoLimiteCalendario;
import br.edu.utfpr.exceptions.limiteAulasDiariasAtingido;
import br.edu.utfpr.model.DTO.CalendarioAcademicoDTO;
import br.edu.utfpr.model.DTO.ReposicaoDTO;
import br.edu.utfpr.model.Reposicao;
import lombok.var;
import org.springframework.beans.BeanUtils;

public class RegrasReposicao {

    private ReposicaoDAO reposicaoDAO;

    private Boolean checarSeReposicaoEstDentroDoCalendarioAcademico(ReposicaoDTO reposicaoDTO){
        CalendarioAcademicoDTO calendarioAcademicoDTO = new CalendarioAcademicoDTO();

        if((reposicaoDTO.getData().compareTo(calendarioAcademicoDTO.getDataInicio())) > 0 && (reposicaoDTO.getData().compareTo(calendarioAcademicoDTO.getDataFim()) < 0)){
            return true;
        }else{
            return false;
        }
    }

    private Boolean checarLimiteMaximoAulasDiarias(ReposicaoDTO reposicaoDTO){
        if(reposicaoDTO.getQtddReposicao() > 6){
            return true;
        }else{
            return false;
        }
    }

    public Reposicao salvar(ReposicaoDTO reposicaoDTO) throws dataDeAntecipaçãoForaDoLimiteCalendario, limiteAulasDiariasAtingido {
            if (!this.checarSeReposicaoEstDentroDoCalendarioAcademico(reposicaoDTO)) {
                throw new dataDeAntecipaçãoForaDoLimiteCalendario("A reposição de aulas deve ser feita dentro do prazo do calendário acadêmico");
            }
            if(!this.checarLimiteMaximoAulasDiarias(reposicaoDTO)){
                throw new limiteAulasDiariasAtingido("O limite de aulas diárias dessa disciplina foi atingido");
            }

            Reposicao reposicao = new Reposicao();
            BeanUtils.copyProperties(reposicaoDTO, reposicao);
            return this.reposicaoDAO.save(reposicao);
    }




}
