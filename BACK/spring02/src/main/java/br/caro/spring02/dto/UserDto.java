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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
 