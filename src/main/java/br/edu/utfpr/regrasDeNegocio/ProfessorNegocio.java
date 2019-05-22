package br.edu.utfpr.regrasDeNegocio;
import br.edu.utfpr.DAO.ProfessorDAO;
import br.edu.utfpr.exceptions.ProfessorJaExisteException;
import br.edu.utfpr.model.DTO.ProfessorDTO;
import br.edu.utfpr.model.Professor;
import org.springframework.beans.BeanUtils;

import java.util.List;

public abstract class ProfessorNegocio extends AbstractNegocio<Professor> {
    private ProfessorDAO professorDAO;

    @Override
    public void incluir(Professor professorDTO) throws ProfessorJaExisteException {


        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        professorDAO.save(professor);

    }

    @Override
    public List<Professor> listar() { return professorDAO.findAll(); }


    @Override
    public void alterar(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        professorDAO.update(professor);
    }
}
