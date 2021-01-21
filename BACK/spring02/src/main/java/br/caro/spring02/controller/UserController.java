package br.caro.spring02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.caro.spring02.dto.UserDto;
import br.caro.spring02.model.User;
import br.caro.spring02.repository.UserRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    
    @Autowired // injeção de dependência
    private UserRepo repo;

    @GetMapping("/id/{id}")
    public ResponseEntity<User> buscaPorId(@PathVariable int id){  // @PathVariable - Variável vem da URI
        User user = repo.findById(id).orElse(null);
        
        if (user != null) {
            user.setSenha("********");
            return ResponseEntity.ok(user); // 200
        }
        return ResponseEntity.notFound().build(); // 404

    }

    @GetMapping("/id2/{id}")
    public ResponseEntity<UserDto> buscaPorId2(@PathVariable int id){  // @PathVariable - Variável vem da URI
        User user = repo.findById(id).orElse(null);
        
        if (user != null) {
            //user.setPassword("********");
            UserDto userDto = new UserDto(user);
            return ResponseEntity.ok(userDto); // 200
        }
        return ResponseEntity.notFound().build(); // 404

    }

    @GetMapping("/all")
    public List<User> listarTodos(){
        List<User> lista = (List<User>)repo.findAll();

        return lista;
    }

    @PostMapping("/new")
    public ResponseEntity<User> novoUsuario(@RequestBody User user){
        User newUser = repo.save(user);

        return ResponseEntity.ok(newUser);

    }
    @PostMapping("/update")
    public ResponseEntity<User> atualizaUsuario(@RequestBody User user){
        if(user.getId() > 0){
            User newUser = repo.save(user);
            return ResponseEntity.ok(newUser);
        }
        return ResponseEntity.status(400).build();


    }

    /* @PostMapping("/email")
    public ResponseEntity<UserDto> buscaPorEmail(@RequestBody User userParam){
        User user = repo.findByEmail(userParam.getEmail());

        if (user != null) {
            UserDto userDto = new UserDto(user);
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    } */

   /*  @PostMapping("/loginemail")
    public ResponseEntity<User> loginPorEmail(@RequestBody User user){
        User userFinded = repo.findByEmailAndPassword(user.getEmail(), user.getSenha());

        if (userFinded != null) {
            return ResponseEntity.ok(userFinded);
        }
        return ResponseEntity.status(401).build();
    } */

    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User userFinded = repo.findByEmailOrRacf(user.getEmail(), user.getRacf());

        if (userFinded != null) {
            if (userFinded.getSenha().equals(user.getSenha())) {
                return ResponseEntity.ok(userFinded);
            }
        }
        return ResponseEntity.status(401).build();
    }
    /* @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User userFinded = repo.findByRacfOrSenha(user.getEmail(), user.getSenha());

        if (userFinded != null) {
            if (userFinded.getSenha().equals(user.getSenha())) {
                return ResponseEntity.ok(userFinded);
            }
        }
        return ResponseEntity.status(401).build();
    } */
    

}
