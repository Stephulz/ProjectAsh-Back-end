package com.stephulz.ProjectAsh.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.stephulz.ProjectAsh.domain.Jogo;


public interface JogoRepository extends JpaRepository<Jogo, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Jogo obj WHERE obj.nome LIKE %:nome%")
	Page<Jogo> findDistinctByNome(@Param("nome") String nome, Pageable pageRequest);
	
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Jogo obj WHERE obj.genero.id = :genero")
	Page<Jogo> findDistinctByGenero(@Param("genero") Integer genero, Pageable pageRequest);

}
