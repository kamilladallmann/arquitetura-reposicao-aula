package br.edu.utfpr.regrasDeNegocio;

import br.edu.utfpr.DAO.ReposicaoDAO;
import br.edu.utfpr.exceptions.dataDeAntecipaçãoForaDoLimiteCalendarioException;
import br.edu.utfpr.exceptions.limiteAulasDiariasAtingidoException;
import br.edu.utfpr.model.DTO.CalendarioAcademicoDTO;
import br.edu.utfpr.model.DTO.ReposicaoDTO;
import br.edu.utfpr.model.Reposicao;
import org.springframework.beans.BeanUtils;

import java.util.List;

public abstract class ReposicaoNegocio extends AbstractNegocio<Reposicao>{

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

    @Override
    public void incluir(ReposicaoDTO reposicaoDTO) throws dataDeAntecipaçãoForaDoLimiteCalendarioException, limiteAulasDiariasAtingidoException {
            if (!checarSeReposicaoEstDentroDoCalendarioAcademico(reposicaoDTO)) {
                throw new dataDeAntecipaçãoForaDoLimiteCalendarioException("A reposição de aulas deve ser feita dentro do prazo do calendário acadêmico");
            }
            if(!checarLimiteMaximoAulasDiarias(reposicaoDTO)){
                throw new limiteAulasDiariasAtingidoException("O limite de aulas diárias dessa disciplina foi atingido");
            }

            Reposicao reposicao = new Reposicao();
            BeanUtils.copyProperties(reposicaoDTO, reposicao);
            reposicaoDAO.save(reposicao);
    }

    @Override
    public List<Reposicao> listar(){
        return reposicaoDAO.findAll();
    }

    @Override
    public void alterar(ReposicaoDTO reposicaoDTO) {
        Reposicao reposicao = new Reposicao();
        BeanUtils.copyProperties(reposicaoDTO, reposicao);
        reposicaoDAO.update(reposicao);
    }
}
