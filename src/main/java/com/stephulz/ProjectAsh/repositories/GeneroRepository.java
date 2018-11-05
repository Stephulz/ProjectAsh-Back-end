package com.stephulz.ProjectAsh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stephulz.ProjectAsh.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
