package br.caro.spring02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.caro.spring02.model.Comunidade;
import br.caro.spring02.model.User;
import br.caro.spring02.repository.ComunidadeRepo;

@RestController
@CrossOrigin("*")

@RequestMapping("/comunidade")
public class ComunidadeController {
    @Autowired
    private ComunidadeRepo repo;

    @PostMapping("/user")
    public List<Comunidade> listarComunidadesPorUsuario(@RequestBody User user){
        List<Comunidade> lista = repo.findByUsuario(user);

        return lista;

    }
}
