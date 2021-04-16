package br.com.spring.mongodb.repository;

import br.com.spring.mongodb.model.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {

    //gt abrevi grant  lt last
    @Query("{ $and: [{ 'idade': { $gte: ?0 } }, { 'idade': { $lte: ?1 } } ] }")
    public List<Funcionario> obterFuncionarioPorRangeDeIdade(Integer de, Integer ate);

    public List<Funcionario> findByNome(String nome);



}
