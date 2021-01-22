package br.caro.spring02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import lombok.Getter;
//import lombok.Setter;

@Entity
//@Getter
//@Setter
@Table(name = "itmn_comunidade")
public class Comunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3,....
    @Column(name = "id_comunidade")
    private int id_comunidade;

    @Column(name = "nome_comunidade")
    private String nome_comunidade;

    //@Column(name = "id_usuario")
    //private int id_usuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario") // nome da coluna na tabela
    //@JsonIgnoreProperties("comunidades") // atributo do User que não deve ser preenchido
    private User usuario;

    public int getId_comunidade() {
        return id_comunidade;
    }

    public void setId_comunidade(int id_comunidade) {
        this.id_comunidade = id_comunidade;
    }

    public String getNome_comunidade() {
        return nome_comunidade;
    }

    public void setNome_comunidade(String nome_comunidade) {
        this.nome_comunidade = nome_comunidade;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }



}
