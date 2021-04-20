package br.com.spring.mongodb.service;

import br.com.spring.mongodb.model.Funcionario;
import br.com.spring.mongodb.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServicesImpl implements FuncionarioServices {

    @Autowired
    private FuncionarioRepository repository;

    @Override
    public List<Funcionario> obterTodos() {
        return repository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return repository
                .findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Funcionario não existe."));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        System.out.println(funcionario);
        Funcionario chefe =
                repository.findById(funcionario.getChefe().getCodigo())
                .orElseThrow(()-> new IllegalArgumentException("Chefe não existe"));
        funcionario.setChefe(chefe);
        return repository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate) {
        return repository.obterFuncionarioPorRangeDeIdade(de, ate);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorNome(String nome) {
        return repository.findByNome(nome);
    }
}
