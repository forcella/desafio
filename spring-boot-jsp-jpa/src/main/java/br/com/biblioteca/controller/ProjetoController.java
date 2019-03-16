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

import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.model.dto.NewProjeto;
import br.com.biblioteca.model.dto.UpdateProjeto;
import br.com.biblioteca.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<Projeto>> listAllProjetos() {
		return new ResponseEntity<List<Projeto>>(projetoService.listProjetos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Projeto> getProjetoId(@PathVariable(value = "id") Long id) {
		Projeto obj = projetoService.getProjetoById(id);
		return new ResponseEntity<Projeto>(obj, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<Projeto> saveProjeto(@RequestBody NewProjeto obj) {
		return new ResponseEntity<Projeto>(projetoService.saveProjeto(obj), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	private ResponseEntity<Projeto> deleteProjeto(@PathVariable(value = "id") Long id) {
		Projeto obj = projetoService.getProjetoById(id);
		projetoService.removeProjeto(obj);
		return new ResponseEntity<Projeto>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Projeto> updateProjeto(@PathVariable(value = "id") Long id,
			@RequestBody UpdateProjeto updateProjeto) {
		Projeto oldObj = projetoService.getProjetoById(id);
		return new ResponseEntity<Projeto>(projetoService.updateProjeto(updateProjeto, oldObj), HttpStatus.OK);
	}

}
