package br.caro.spring02.dto;

import br.caro.spring02.model.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto {
    private String nome;
    private String email;
    private String senha;

    public UserDto(User user){
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
    }

    
}
