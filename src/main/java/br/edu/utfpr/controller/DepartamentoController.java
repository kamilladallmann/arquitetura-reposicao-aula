package br.edu.utfpr.controller;

import br.edu.utfpr.DAO.DepartamentoDAO;
import br.edu.utfpr.model.Departamento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class DepartamentoController extends DepartamentoDAO{

    private DepartamentoDAO dao;

    @PostMapping(value = "departamento")
    public Departamento insert(@Valid @RequestBody Departamento departamento){
        return dao.save(departamento);
    }

    @GetMapping(value = "/departamento")
    public List<Departamento> findAll(){
        return dao.findAll();
    }

    @PutMapping(value = "/departamento/{id}")
    public Departamento update(@PathVariable("id") int id, @Valid @RequestBody Departamento departamento){
        return dao.update(departamento);
    }

    @DeleteMapping(value = "/departamento/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        dao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
