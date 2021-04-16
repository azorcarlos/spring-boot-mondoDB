package br.com.spring.mongodb.controller;

import br.com.spring.mongodb.model.Funcionario;
import br.com.spring.mongodb.repository.FuncionarioRepository;
import br.com.spring.mongodb.service.FuncionarioServices;
import br.com.spring.mongodb.service.FuncionarioServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncitonarioController {

    @Autowired
    private FuncionarioServices funcionarioServices;


    @GetMapping
    public List<Funcionario> obterTodos(){
        return funcionarioServices.obterTodos();
    }

    @GetMapping(value = "/{codigo}")
    public Funcionario obterTodos(@PathVariable String codigo){
        return funcionarioServices.obterPorCodigo(codigo);

    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario){
        return funcionarioServices.criar(funcionario);
    }

    @GetMapping(value ="/range")
    public List<Funcionario> obterFuncionarioPorRangeDeIdades(
            @RequestParam("de") Integer de,
            @RequestParam("ate") Integer ate){
        return funcionarioServices.obterFuncionarioPorRangeDeIdade(de, ate);
    }

    @GetMapping(value ="/por-nome")
    public List<Funcionario> obterFuncionariosPorNome(
            @RequestParam("nome") String nome){
        return funcionarioServices.obterFuncionariosPorNome(nome);
    }

}
