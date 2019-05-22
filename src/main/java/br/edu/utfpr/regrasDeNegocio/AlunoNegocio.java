package br.edu.utfpr.regrasDeNegocio;

import br.edu.utfpr.DAO.AlunoDAO;

import br.edu.utfpr.exceptions.AlunoJaExisteException;
import br.edu.utfpr.model.Aluno;
import br.edu.utfpr.model.DTO.AlunoDTO;

import org.springframework.beans.BeanUtils;

import java.util.List;

public abstract class AlunoNegocio extends AbstractNegocio<Aluno> {
    private AlunoDAO alunoDAO;

    @Override
    public void incluir(AlunoDTO alunoDTO) throws AlunoJaExisteException {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        alunoDAO.save(aluno);

    }

    @Override
    public List<Aluno> listar() {
        return alunoDAO.findAll();
    }

    @Override
    public void alterar(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        alunoDAO.update(aluno);
    }
}
