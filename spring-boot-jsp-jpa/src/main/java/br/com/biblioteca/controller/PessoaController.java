package br.com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.model.dto.NewPessoa;
import br.com.biblioteca.model.dto.UpdatePessoa;
import br.com.biblioteca.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<Pessoa>> listAllPessoas() {
		return new ResponseEntity<List<Pessoa>>(pessoaService.listPessoas(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Pessoa> getPessoaId(@PathVariable(value = "id") Long id) {
		Pessoa obj = pessoaService.getPessoaById(id);
		return new ResponseEntity<Pessoa>(obj, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<Pessoa> savePessoa(@RequestBody NewPessoa newPessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.savePessoa(newPessoa.toPessoa()), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<Projeto> deleteProjeto(@PathVariable(value = "id") Long id) {
		Pessoa obj = pessoaService.getPessoaById(id);
		pessoaService.removePessoa(obj);
		return new ResponseEntity<Projeto>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Pessoa> updateProjeto(@PathVariable(value = "id") Long id,
			@RequestBody UpdatePessoa updatePessoa) {
		Pessoa oldObj = pessoaService.getPessoaById(id);
		return new ResponseEntity<Pessoa>(pessoaService.updatePessoa(updatePessoa, oldObj), HttpStatus.OK);
	}
}
