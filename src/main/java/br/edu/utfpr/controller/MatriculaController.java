package br.edu.utfpr.controller;

import br.edu.utfpr.DAO.MatriculaDAO;
import br.edu.utfpr.model.Matricula;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class MatriculaController extends MatriculaDAO {
    private MatriculaDAO dao;

    @PostMapping(value = "matricula")
    public Matricula insert(@Valid @RequestBody Matricula matricula){
        return dao.save(matricula);
    }

    @GetMapping(value = "/matricula")
    public List<Matricula> findAll(){
        return dao.findAll();
    }

    @PutMapping(value = "/matricula/{id}")
    public Matricula update(@PathVariable("id") int id, @Valid @RequestBody Matricula matricula){
        return dao.update(matricula);
    }

    @DeleteMapping(value = "/matricula/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
