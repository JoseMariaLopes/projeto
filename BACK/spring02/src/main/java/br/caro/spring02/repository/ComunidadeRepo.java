package br.caro.spring02.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.caro.spring02.model.Comunidade;
import br.caro.spring02.model.User;


public interface ComunidadeRepo extends CrudRepository<Comunidade, Integer> {
    public List<Comunidade> findByUsuario(User usuario);

}
