package com.example.minhaEmpresa.model;

import com.example.minhaEmpresa.enums.ESTADOCIVIL;
import com.example.minhaEmpresa.enums.SETOR;
import com.example.minhaEmpresa.enums.SEXO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name="funcionarios")
@Validated
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Favor inserir nome!")
    private String nome;

    @Column
    @NotBlank(message = "Favor inserir cpf!")
    private String cpf;

    @Column
    @NotBlank(message = "Favor inserir data de nascimento!")
    private String dataNascimento;

    @Enumerated(EnumType.STRING)
    private ESTADOCIVIL estadocivil;

    @Enumerated(EnumType.STRING)
    private SEXO sexo;

    @Enumerated(EnumType.STRING)
    private SETOR setor;

    @Column
    @Min(value = 1000, message = "Salário não pode ser inferior a 1000!")
    private Double salario;

    @Column
    @NotBlank
    @Email(message = "Favor inserir email!")
    private String email;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ESTADOCIVIL getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(ESTADOCIVIL estadocivil) {
        this.estadocivil = estadocivil;
    }

    public SEXO getSexo() {
        return sexo;
    }

    public void setSexo(SEXO sexo) {
        this.sexo = sexo;
    }

    public SETOR getSetor() {
        return setor;
    }

    public void setSetor(SETOR setor) {
        this.setor = setor;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Funcionario(Long id, String nome, String cpf, String dataNascimento, ESTADOCIVIL estadocivil, SEXO sexo, SETOR setor, Double salario, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.estadocivil = estadocivil;
        this.sexo = sexo;
        this.setor = setor;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    public Funcionario() {
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
