package com.stephulz.ProjectAsh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stephulz.ProjectAsh.domain.Genero;
import com.stephulz.ProjectAsh.repositories.GeneroRepository;

@SpringBootApplication
public class ProjectAshApplication implements CommandLineRunner{
	
	@Autowired
	private GeneroRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjectAshApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
