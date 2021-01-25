package br.com.cadastromania.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastromania.model.Pessoa;
import br.com.cadastromania.repository.PessoaRepository;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	// Serviço Restfull

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {

		Pessoa pessoasalva = pessoaRepository.save(pessoa);

		return new ResponseEntity<Pessoa>(pessoasalva, HttpStatus.CREATED);
	}

	// Método para atualizar
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa) {

		Pessoa pessoaatualizada = pessoaRepository.save(pessoa);

		return new ResponseEntity<Pessoa>(pessoaatualizada, HttpStatus.CREATED);

	}

	// Método para listar todas pessoas cadastradas
	@GetMapping(value = "/", produces = "applicaion/json")
	public ResponseEntity<List<Pessoa>> pessoa() {

		List<Pessoa> list = (List<Pessoa>) pessoaRepository.findAll();

		return new ResponseEntity<List<Pessoa>>(list, HttpStatus.OK);
	}

	// Método para buscar dados por id
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Pessoa> bucasPorId(@PathVariable(value = "id") Long id) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(id);

		return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = "application/text")
	public ResponseEntity delete (@PathVariable("id") Long id) {
		
		pessoaRepository.deleteById(id);
		
		return (ResponseEntity) ResponseEntity.ok();
	}
}
