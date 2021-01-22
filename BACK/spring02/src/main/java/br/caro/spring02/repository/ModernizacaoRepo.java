package br.caro.spring02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.caro.spring02.model.Comunidade;
import br.caro.spring02.model.Modernizacao;


public interface ModernizacaoRepo extends CrudRepository<Modernizacao, Integer> {
    public List<Modernizacao> findByComunidadeOrderByDataModernizacao(Comunidade comunidade);

    @Query(value = "select ifnull(round(sum(percentual),2),0) from itmn_modernizacao where id_comunidade = ?1 and year(data_modernizacao) = ?2", nativeQuery = true)
    public double somaPorcentagem(int idComunidade, int ano);

    @Query(value = "select * from itmn_modernizacao where id_comunidade = ?1 and year(data_modernizacao) = ?2 and month(data_modernizacao) = ?3 LIMIT 1", nativeQuery = true)
    public Object existe(int idComunidade, int ano, int mes);
}