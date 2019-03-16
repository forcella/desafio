package br.com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.biblioteca.exception.AddNotAllowedException;
import br.com.biblioteca.exception.ElementNotFoundException;
import br.com.biblioteca.model.Membros;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.model.dto.AddRemoveMembros;
import br.com.biblioteca.repository.MembrosRepository;

@Component
public class MembrosService {
	@Autowired
	private MembrosRepository membrosRepo;
	@Autowired
	private ProjetoService projetoService;
	@Autowired
	private PessoaService pessoaService;

	public List<Membros> listMembros() {
		return membrosRepo.findAll();

	}

	public Membros getMembrosByProjectId(Long id) {
		Projeto projeto = projetoService.getProjetoById(id);
		Membros membros = membrosRepo.findMembrosByProjeto(projeto);
		if (membros == null) {
			throw new ElementNotFoundException(Membros.class.getSimpleName() + " not found");
		}
		return membros;
	}

	public Membros addMembros(AddRemoveMembros obj) {
		Projeto projeto = projetoService.getProjetoById(obj.getProjetoId());
		Membros membros = membrosRepo.findMembrosByProjeto(projeto);
		Pessoa pessoa = pessoaService.getPessoaById(obj.getMembroId());
		if (!pessoa.getFuncionario()) {
			throw new AddNotAllowedException(pessoa.getNome() + " isnt a funcionario");
		}
		if (membros == null) {
			membros = new Membros();
			membros.setProjeto(projeto);
		}
		membros.getListMembros().add(pessoa);
		membrosRepo.save(membros);

		return membros;
	}

	public Membros removeMembros(AddRemoveMembros obj) {
		Projeto projeto = projetoService.getProjetoById(obj.getProjetoId());
		Membros membros = membrosRepo.findMembrosByProjeto(projeto);
		Pessoa pessoa = pessoaService.getPessoaById(obj.getMembroId());

		membros.getListMembros().remove(pessoa);
		membrosRepo.save(membros);

		return membros;

	}

}
