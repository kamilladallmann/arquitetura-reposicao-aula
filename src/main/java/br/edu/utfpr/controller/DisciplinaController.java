package br.edu.utfpr.controller;

import br.edu.utfpr.DAO.DisciplinaDAO;
import br.edu.utfpr.model.Disciplina;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class DisciplinaController extends DisciplinaDAO{
    private DisciplinaDAO dao;

    @PostMapping(value = "disciplina")
    public Disciplina insert(@Valid @RequestBody Disciplina disciplina){
        return dao.save(disciplina);
    }

    @GetMapping(value = "/disciplina")
    public List<Disciplina> findAll(){
        return dao.findAll();
    }

    @PutMapping(value = "/disciplina/{id}")
    public Disciplina update(@PathVariable("id") int id, @Valid @RequestBody Disciplina disciplina){
        return dao.update(disciplina);
    }

    @DeleteMapping(value = "/disciplina/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
