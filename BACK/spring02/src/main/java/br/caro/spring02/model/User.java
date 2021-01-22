package br.caro.spring02.model;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity // classe será mapeada no DB
//@Table(name = "user")
@Table(name = "tbl_usuario")
@Getter

@Setter
public class User {
    @Id // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3,....
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "senha", length = 30, nullable = false)
    private String senha;

    @Column(name = "racf", length = 7, nullable = false, unique = true)
    private String racf;

    @Column(name = "linkfoto", length = 200, nullable = false, unique = true)
    private String linkfoto;

    /*
    @OneToMany(mappedBy = "usuario")
    @JsonIgnoreProperties("usuario") // atributo do anúncio que não deve ser preenchido (para evitar o loop)
    private List<Anuncio> anuncios;*/

    
}
