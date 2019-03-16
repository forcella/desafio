package br.com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.model.Membros;
import br.com.biblioteca.model.Projeto;

@Repository
public interface MembrosRepository extends JpaRepository<Membros, Long> {

	// @Query("SELECT m FROM Membros m WHERE m.projeto :projeto")
	Membros findMembrosByProjeto(Projeto projeto);
}
