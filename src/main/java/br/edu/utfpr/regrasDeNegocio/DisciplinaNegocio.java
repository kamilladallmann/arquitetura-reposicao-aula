package br.edu.utfpr.regrasDeNegocio;

import br.edu.utfpr.DAO.DisciplinaDAO;

import br.edu.utfpr.exceptions.disciplinaJaExisteException;

import br.edu.utfpr.model.DTO.DisciplinaDTO;

import br.edu.utfpr.model.Disciplina;
import org.springframework.beans.BeanUtils;

import java.util.List;

public abstract class DisciplinaNegocio extends AbstractNegocio<Disciplina> {

    private DisciplinaDAO disciplinaDAO;

    @Override
    public void incluir(Disciplina disciplinaDTO) throws disciplinaJaExisteException {


        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        disciplinaDAO.save(disciplina);

    }

    @Override
    public List<Disciplina> listar() { return disciplinaDAO.findAll(); }


    @Override
    public void alterar(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        disciplinaDAO.update(disciplina);
    }
}
