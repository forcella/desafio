package br.com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.biblioteca.exception.ElementNotFoundException;
import br.com.biblioteca.exception.ExclusionNotAllowedException;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.dto.UpdatePessoa;
import br.com.biblioteca.repository.PessoaRepository;

@Component
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepo;

	public List<Pessoa> listPessoas() {
		return pessoaRepo.findAll();

	}

	public Pessoa getPessoaById(Long id) {
		Pessoa p = pessoaRepo.findOne(id);
		if (p == null) {
			throw new ElementNotFoundException(Pessoa.class.getSimpleName() + " not found with id: " + id);
		}
		return p;
	}

	public Pessoa savePessoa(Pessoa obj) {
		return pessoaRepo.save(obj);
	}

	public Pessoa updatePessoa(Pessoa newObj) {
		// Pessoa obj = getPessoaById(newObj.getId());
		return pessoaRepo.save(newObj);
	}

	public void removePessoa(Pessoa obj) {
		Pessoa entity = pessoaRepo.findOne(obj.getId());
		try {
			pessoaRepo.delete(entity);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new ExclusionNotAllowedException(Pessoa.class.getSimpleName()
					+ " cannot be deleted there is projetos related with: " + obj.getNome());
		}
	}

	public Pessoa updatePessoa(UpdatePessoa newObj, Pessoa obj) {
		if (newObj.getFuncionario() != null) {
			obj.setFuncionario(newObj.getFuncionario());
		}
		if (newObj.getCargo() != null) {
			obj.setCargo(newObj.getCargo());
		}
		if (newObj.getCpf() != null) {
			obj.setCpf(newObj.getCpf());
		}
		if (newObj.getDataDeNascimento() != null) {
			obj.setDataDeNascimento(newObj.getDataDeNascimento());
		}
		if (newObj.getNome() != null) {
			obj.setNome(newObj.getNome());
		}
		return pessoaRepo.save(obj);
	}
}
