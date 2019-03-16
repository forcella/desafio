package br.com.biblioteca.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRemoveMembros implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long membroId;
	private Long projetoId;
	
}
