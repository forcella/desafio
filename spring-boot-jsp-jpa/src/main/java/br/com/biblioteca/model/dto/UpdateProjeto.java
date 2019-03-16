package br.com.biblioteca.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.biblioteca.model.Pessoa;
import br.com.biblioteca.model.Projeto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataInicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataPrevisaoFim;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataFim;
	private String descricao;
	private String status;
	private Double orcamento;
	private String risco;
	private Long idGerente;

	public Projeto toProjeto(Long id, Pessoa gerente) {
		return new Projeto(id, nome, dataInicio, dataPrevisaoFim, dataFim, descricao, status, orcamento, risco,
				gerente);
	}

}
