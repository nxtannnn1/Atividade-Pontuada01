package com.example.minhaEmpresa.exceptions;

public class FuncionarioNaoAchadoException extends RuntimeException{ //Tratamento de erros

    public FuncionarioNaoAchadoException (String message){
        super(message);
    }
}
