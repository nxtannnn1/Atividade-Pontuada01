package com.example.minhaEmpresa.service;

import com.example.minhaEmpresa.exceptions.FuncionarioNaoAchadoException;
import com.example.minhaEmpresa.exceptions.FuncionarioJaCadastradoException;
import com.example.minhaEmpresa.model.Funcionario;
import com.example.minhaEmpresa.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Regra de negócios da API
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository; //Acesso as funções nativas do JPARepository

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public String cadastrarUsuario(Funcionario funcionario) {

        if(funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
            throw new FuncionarioJaCadastradoException("E-mail já cadastrado");
        }
        funcionarioRepository.save(funcionario);
        return "Funcionário cadastrado";
    }

    public void excluirUsuario(Long id) {
        if (!funcionarioRepository.existsById(id)) { //Verifica se o ID do funcionário existe, caso não haja, lança uma exceção
            throw new FuncionarioNaoAchadoException("Funcionario de ID " + id + " não achado.");
        } else {
            funcionarioRepository.deleteById(id); //Remoção do funcionário
        }
    }

    public Funcionario atualizarUsuario(Funcionario funcionario) {
        if (!funcionarioRepository.existsById(funcionario.getId())) {
            throw new FuncionarioNaoAchadoException("Funcionario de ID " + funcionario.getId() + " não achado.");
        }
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarUsuarios() {
        return funcionarioRepository.findAll();
    }
}
