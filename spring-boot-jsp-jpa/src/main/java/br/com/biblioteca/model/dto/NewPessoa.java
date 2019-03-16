package br.com.biblioteca.model.dto;

import java.io.Serializable;

import br.com.biblioteca.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cargo;

	public Pessoa toPessoa() {
		return new Pessoa(null, nome, null, null, true, cargo);
	}
}
