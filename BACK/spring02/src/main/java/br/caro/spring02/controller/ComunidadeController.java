package br.caro.spring02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.caro.spring02.model.Comunidade;
import br.caro.spring02.repository.ComunidadeRepo;

@RestController
@RequestMapping("/comunidades")
public class ComunidadeController {
    @Autowired
    private ComunidadeRepo repo;

    @GetMapping("/id/{id}")
    public ResponseEntity<Comunidade> buscaPorId(@PathVariable int id){
        Comunidade comunidade = repo.findById(id).orElse(null);
        if (comunidade != null) {
            return ResponseEntity.ok(comunidade); // 200
        }
        return ResponseEntity.notFound().build(); // 404

    }
}
