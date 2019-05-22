package br.edu.utfpr.controller;

import br.edu.utfpr.DAO.AulaDAO;
import br.edu.utfpr.model.Aula;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AulaController extends AulaDAO {

    private AulaDAO dao;

    @PostMapping(value = "aula")
    public Aula insert(@Valid @RequestBody Aula aula){
        return dao.save(aula);
    }

    @GetMapping(value = "/aula")
    public List<Aula> findAll(){
        return dao.findAll();
    }

    @PutMapping(value = "/professor/{id}")
    public Aula update(@PathVariable("id") int id, @Valid @RequestBody Aula aula){
        return dao.update(aula);
    }

    @DeleteMapping(value = "/aula/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
