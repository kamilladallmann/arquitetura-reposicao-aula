package br.edu.utfpr.controller;

import br.edu.utfpr.DAO.ProfessorDAO;
import br.edu.utfpr.model.DTO.ProfessorDTO;
import br.edu.utfpr.model.Professor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services")
public abstract class ProfessorController extends ProfessorDAO {

    private ProfessorDAO dao;

    @PostMapping(value = "professor")
    public Professor insert(@Valid @RequestBody Professor professor){
        return dao.save(professor);
    }

    @GetMapping(value = "/professor")
    public List<Professor> findAll(){
        return dao.findAll();
    }

    @PutMapping(value = "/professor/{id}")
    public Professor update(@PathVariable("id") int id, @Valid @RequestBody Professor professor){
        return dao.update(professor);
    }

    @DeleteMapping(value = "/professor/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
