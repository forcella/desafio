package br.com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.biblioteca.model.Membros;
import br.com.biblioteca.model.dto.AddRemoveMembros;
import br.com.biblioteca.service.MembrosService;

@RestController
@RequestMapping("/membros")
public class MembroController {

	@Autowired
	private MembrosService membrosService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Membros> getMembrosByProjectId(@PathVariable(value = "id") Long id) {
		Membros obj = membrosService.getMembrosByProjectId(id);
		return new ResponseEntity<Membros>(obj, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	private ResponseEntity<Membros> addMembros(@RequestBody AddRemoveMembros obj) {
		return new ResponseEntity<Membros>(membrosService.addMembros(obj), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	private ResponseEntity<Membros> removeMembros(@RequestBody AddRemoveMembros obj) {
		return new ResponseEntity<Membros>(membrosService.removeMembros(obj), HttpStatus.OK);
	}

}
