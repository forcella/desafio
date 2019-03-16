package br.com.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.biblioteca.exception.ElementNotFoundException;
import br.com.biblioteca.exception.ExclusionNotAllowedException;
import br.com.biblioteca.exception.StringNotAllowedException;
import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import br.com.biblioteca.model.dto.NewProjeto;
import br.com.biblioteca.model.dto.UpdateProjeto;
import br.com.biblioteca.repository.ProjetoRepository;
import br.com.biblioteca.utils.StringUtils;

@Component
public class ProjetoService {
	@Autowired
	private ProjetoRepository projetoRepo;
	@Autowired
	private PessoaService pessoaService;

	public List<Projeto> listProjetos() {
		return projetoRepo.findAll();

	}

	public Projeto getProjetoById(Long id) {
		Projeto p = projetoRepo.findOne(id);
		if (p == null) {
			throw new ElementNotFoundException(Projeto.class.getSimpleName() + " not found with id: " + id);
		}
		return p;
	}

	public Projeto saveProjeto(NewProjeto newObj) {
		if (newObj.getStatus().equals(null) || newObj.getStatus().trim().equals("")) {
			newObj.setStatus("");
		}
		newObj.setRisco(StringUtils.removerAcentos(newObj.getRisco().toUpperCase().trim()));
		newObj.setStatus(StringUtils.removerAcentos(newObj.getStatus().toUpperCase().trim()));
		Projeto obj = newObj.toProjeto(pessoaService.getPessoaById(newObj.getIdGerente()));

		if (!obj.getStatus().equals("") && !obj.getStatus().equals("EM ANALISE")
				&& !obj.getStatus().equals("ANALISE REALIZADA") && !obj.getStatus().equals("ANALISE APROVADA")
				&& !obj.getStatus().equals("INICIADO") && !obj.getStatus().equals("PLANEJADO")
				&& !obj.getStatus().equals("EM ANDAMENTO") && !obj.getStatus().equals("ENCERRADO")
				&& !obj.getStatus().equals("CANCELADO")) {
			throw new StringNotAllowedException("STATUS: " + newObj.getStatus()
					+ ", not allowed excpected: em análise, análise realizada, análise aprovada,iniciado, planejado, em andamento, encerrado, cancelado.");
		}
		if (!obj.getRisco().equals("BAIXO") && !obj.getRisco().equals("MEDIO") && !obj.getRisco().equals("ALTO")) {
			throw new StringNotAllowedException(
					"RISCO: " + newObj.getRisco() + ", not allowed excpected: BAIXO,MEDIO,ALTO.");
		}
		return projetoRepo.save(obj);
	}

	public Projeto updateProjeto(UpdateProjeto newObj, Projeto obj) {
		// Projeto obj = getProjetoById(newObj.getId());
		if (newObj.getDataFim() != null) {
			obj.setDataFim(newObj.getDataFim());
		}
		if (newObj.getDataInicio() != null) {
			obj.setDataInicio(newObj.getDataInicio());
		}
		if (newObj.getDataPrevisaoFim() != null) {
			obj.setDataPrevisaoFim(newObj.getDataPrevisaoFim());
		}
		if (newObj.getDescricao() != null) {
			obj.setDescricao(newObj.getDescricao());
		}
		if (newObj.getIdGerente() != null) {
			Pessoa gerente = pessoaService.getPessoaById(newObj.getIdGerente());
			obj.setGerente(gerente);
		}
		if (newObj.getNome() != null) {
			obj.setNome(newObj.getNome());
		}
		if (newObj.getOrcamento() != null) {
			obj.setOrcamento(newObj.getOrcamento());
		}
		if (newObj.getRisco() != null) {
			obj.setRisco(newObj.getRisco());
		}
		if (newObj.getStatus() != null) {
			obj.setStatus(newObj.getStatus());
		}

		return projetoRepo.save(obj);
	}

	public void removeProjeto(Projeto obj) {
		if (obj.getStatus().equals("INICIADO") || obj.getStatus().equals("EM ANDAMENTO")
				|| obj.getStatus().equals("ENCERRADO")) {
			throw new ExclusionNotAllowedException(
					Projeto.class.getSimpleName() + " with STATUS: " + obj.getStatus() + " cannot be deleted.");
		}
		Projeto entity = projetoRepo.findOne(obj.getId());
		try {
			projetoRepo.delete(entity);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new ExclusionNotAllowedException(Projeto.class.getSimpleName() + " cannot be deleted");
		}
	}
}
