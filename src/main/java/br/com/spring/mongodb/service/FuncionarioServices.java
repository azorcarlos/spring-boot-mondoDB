package br.com.spring.mongodb.service;

import br.com.spring.mongodb.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FuncionarioServices {

    public List<Funcionario> obterTodos();
    public Funcionario obterPorCodigo(String codigo);
    public Funcionario criar(Funcionario funcionario);
    public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate);
    public List<Funcionario> obterFuncionariosPorNome(String nome);
}
