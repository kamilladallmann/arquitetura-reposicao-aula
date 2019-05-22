package br.edu.utfpr.controller;

import br.edu.utfpr.DAO.AlunoDAO;
import br.edu.utfpr.model.Aluno;
import br.edu.utfpr.model.DTO.AlunoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AlunoController extends AlunoDAO {

    private AlunoDAO dao;

    @PostMapping(value = "aluno")
    public Aluno insert(@Valid @RequestBody AlunoDTO alunoDTO){
        return dao.save(alunoDTO);
    }

    @GetMapping(value = "/aluno")
    public List<Aluno> findAll(){
        return dao.findAll();
    }

    @PutMapping(value = "/aluno/{id}")
    public Aluno update(@PathVariable("id") int id, @Valid @RequestBody Aluno aluno){
        return dao.update(aluno);
    }

    @DeleteMapping(value = "/aluno/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
