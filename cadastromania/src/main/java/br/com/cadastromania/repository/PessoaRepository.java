package br.com.cadastromania.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastromania.model.Pessoa;

@Repository // definir uma classe como pertencente à camada de persistência.
                                            //Classe de modelo - Tipo de Primary Key
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

}
