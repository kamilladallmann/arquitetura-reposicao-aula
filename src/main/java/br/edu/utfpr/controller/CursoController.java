package br.edu.utfpr.controller;

import br.edu.utfpr.DAO.CursoDAO;
import br.edu.utfpr.model.Curso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class CursoController extends CursoDAO {

    private CursoDAO dao;

    @PostMapping(value = "curso")
    public Curso insert(@Valid @RequestBody Curso curso){
        return dao.save(curso);
    }

    @GetMapping(value = "/curso")
    public List<Curso> findAll(){
        return dao.findAll();
    }

    @PutMapping(value = "/curso/{id}")
    public Curso update(@PathVariable("id") int id, @Valid @RequestBody Curso curso){
        return dao.update(curso);
    }

    @DeleteMapping(value = "/curso/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
