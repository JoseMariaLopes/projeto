package br.caro.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.caro.spring02.model.Comunidade;

public interface ComunidadeRepo extends CrudRepository<Comunidade, Integer> {
    
}
