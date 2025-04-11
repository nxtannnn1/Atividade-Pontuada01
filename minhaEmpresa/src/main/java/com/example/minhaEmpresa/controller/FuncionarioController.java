package com.example.minhaEmpresa.controller;

import com.example.minhaEmpresa.exceptions.FuncionarioJaCadastradoException;
import com.example.minhaEmpresa.exceptions.FuncionarioNaoAchadoException;
import com.example.minhaEmpresa.model.Funcionario;
import com.example.minhaEmpresa.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController //Controller REST da API
@RequestMapping("/funcionarios") //Define a URL básica do site
public class FuncionarioController {

    @Autowired //Injeção de dependência, em tese, não precisaria de construtor, mas durante os testes não funcionou
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody @Valid Funcionario funcionario) { //Requere, de forma válida, o objeto funcionário para seu cadastro, e ao final, informa uma mensagem de sucesso
        try {
            funcionarioService.cadastrarUsuario(funcionario);
        }
        catch (FuncionarioJaCadastradoException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Já existe um funcionario com esse e-mail cadastrado!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("O funcionario "+funcionario.getNome()+" foi cadastrado!");
    }

    @GetMapping
    public List<Funcionario> listarUsuarios() {
        return funcionarioService.listarUsuarios();
    } //Através dos método,s lista os funcionários cadastrados

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirUsuario(@PathVariable Long id) { //A partir do ID @PathVariable, rastreia o funcionário, e o deleta do CRUD
        try{
        funcionarioService.excluirUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionario excluido do sistema"); //Caso consiga realizar a remoção, retorna ok
        }
        catch (FuncionarioNaoAchadoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionario não encontrado no sistema"); //Caso contrário, erro
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario) {
        funcionario.setId(id);
        funcionarioService.atualizarUsuario(funcionario);
        return ResponseEntity.status(HttpStatus.OK).body("Funcionário atualizado com sucesso!");
    }
}
