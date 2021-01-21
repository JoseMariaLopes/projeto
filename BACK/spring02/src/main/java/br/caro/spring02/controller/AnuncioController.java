package br.caro.spring02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.caro.spring02.model.Anuncio;
import br.caro.spring02.repository.AnuncioRepo;

@RestController
@RequestMapping("/anuncio")
public class AnuncioController {
    @Autowired // injeção de dependência
    private AnuncioRepo repo;

    @GetMapping("/id/{id}")
    public ResponseEntity<Anuncio> buscaPorId(@PathVariable int id){
        Anuncio anuncio = repo.findById(id).orElse(null);

        if (anuncio != null) {
            return ResponseEntity.ok(anuncio); // 200
        }
        return ResponseEntity.notFound().build(); // 404

    }

    @GetMapping("/all")
    public List<Anuncio> listarTodos(){
        List<Anuncio> lista = (List<Anuncio>)repo.findAll();

        return lista;
    }
}
