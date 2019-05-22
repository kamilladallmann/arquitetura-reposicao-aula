package br.edu.utfpr.regrasDeNegocio;

import br.edu.utfpr.DAO.CursoDAO;

import br.edu.utfpr.exceptions.CursoJaExisteException;
import br.edu.utfpr.model.Curso;
import br.edu.utfpr.model.DTO.CursoDTO;

import org.springframework.beans.BeanUtils;

import java.util.List;

public abstract class CursoNegocio extends AbstractNegocio<Curso> {

    private CursoDAO cursoDAO;


    @Override
    public void incluir(CursoDTO cursoDTO) throws CursoJaExisteException {
        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        cursoDAO.save(curso);
    }

    @Override
    public List<Curso> listar() {
        return cursoDAO.findAll();
    }

    @Override
    public void alterar(CursoDTO cursoDTO) {
        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        cursoDAO.update(curso);
    }
}
