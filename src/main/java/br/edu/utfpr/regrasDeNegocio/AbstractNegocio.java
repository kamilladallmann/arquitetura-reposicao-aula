package br.edu.utfpr.regrasDeNegocio;

import br.edu.utfpr.exceptions.ProfessorJaExisteException;
import br.edu.utfpr.exceptions.dataDeAntecipaçãoForaDoLimiteCalendarioException;
import br.edu.utfpr.exceptions.limiteAulasDiariasAtingidoException;
import br.edu.utfpr.model.DTO.ProfessorDTO;
import br.edu.utfpr.model.DTO.ReposicaoDTO;

import java.util.List;

public abstract class AbstractNegocio<T> {
    public abstract void incluir(T t);

    public abstract void incluir(ProfessorDTO professorDTO) throws ProfessorJaExisteException;

    public abstract void alterar(T t);

    public abstract void incluir(ReposicaoDTO reposicaoDTO) throws dataDeAntecipaçãoForaDoLimiteCalendarioException, limiteAulasDiariasAtingidoException;

    public abstract List<T> listar();

    public abstract void alterar(ReposicaoDTO reposicaoDTO);
}
