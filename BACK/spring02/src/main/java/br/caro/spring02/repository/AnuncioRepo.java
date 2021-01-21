package br.caro.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.caro.spring02.model.Anuncio;

//CRUD - Create, Read, Update, Delete - ou Comitê Revolucionário Ultra Developer
public interface AnuncioRepo extends CrudRepository<Anuncio, Integer>{
    
}
