package com.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogPessoal.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> { // 1 - Pegando a interface temarepository e da um extends
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao); // 2 - para utilizar todos os recursos do JPA

}
