package br.edu.utfpr.regrasDeNegocio;

import br.edu.utfpr.exceptions.ProfessorJaExisteException;
import br.edu.utfpr.exceptions.CursoJaExisteException;
import br.edu.utfpr.exceptions.AlunoJaExisteException;
import br.edu.utfpr.exceptions.disciplinaJaExisteException;
import br.edu.utfpr.exceptions.dataDeAntecipaçãoForaDoLimiteCalendarioException;
import br.edu.utfpr.exceptions.limiteAulasDiariasAtingidoException;
import br.edu.utfpr.model.DTO.ProfessorDTO;
import br.edu.utfpr.model.DTO.ReposicaoDTO;
import br.edu.utfpr.model.DTO.CursoDTO;
import br.edu.utfpr.model.DTO.AlunoDTO;
import br.edu.utfpr.model.DTO.DisciplinaDTO;


import java.util.List;

public abstract class AbstractNegocio<T> {

    public abstract void incluir(T t);

    public abstract void incluir(ProfessorDTO professorDTO) throws ProfessorJaExisteException;

    public abstract void incluir(CursoDTO cursoDTO) throws CursoJaExisteException;

    public abstract void alterar(T t);

    public abstract void incluir(ReposicaoDTO reposicaoDTO) throws dataDeAntecipaçãoForaDoLimiteCalendarioException, limiteAulasDiariasAtingidoException;

    public abstract List<T> listar();

    public abstract void alterar(ReposicaoDTO reposicaoDTO);
}
