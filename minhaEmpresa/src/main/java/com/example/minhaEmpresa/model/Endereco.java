package com.example.minhaEmpresa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity //Entidade no BD
@Table(name="endereco")
public class Endereco {
    @Id //ID no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment
    private Long id;

    @Column //Coluna na tabela do BD
    @NotBlank(message = "Favor inserir logradouro!") //Impede caso haja resultados vazios
    private String logradouro;

    @Column
    @NotBlank(message = "Favor inserir numero!")
    private String numero;

    @Column
    @NotBlank(message = "Favor inserir complemento!")
    private String complemento;

    @Column
    @NotBlank(message = "Favor inserir cidade!")
    private String cidade;

    public Endereco(Long id, String logradouro, String numero, String complemento, String cidade, String email) { //Construtor com parametros
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Endereco() { //Construtor vazio
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
