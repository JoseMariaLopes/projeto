package br.caro.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.caro.spring02.model.User;

//CRUD - Create, Read, Update, Delete - ou Comitê Revolucionário Ultra Developer
public interface UserRepo extends CrudRepository<User, Integer> {
    //public User findByEmail(String email);
    //public User findByEmailAndSenha(String email, String senha);
    public User findByEmailOrRacf(String email, String racf);
    //public User findByRacfAndSenha(String racf, String senha);
}
