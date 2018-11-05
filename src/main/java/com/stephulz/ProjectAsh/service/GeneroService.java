package com.stephulz.ProjectAsh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.stephulz.ProjectAsh.domain.Genero;
import com.stephulz.ProjectAsh.dto.GeneroDTO;
import com.stephulz.ProjectAsh.repositories.GeneroRepository;
import com.stephulz.ProjectAsh.service.exception.DataIntegrityException;
import com.stephulz.ProjectAsh.service.exception.ObjectNotFoundException;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repo;

	public Genero find(Integer id) {

		Optional<Genero> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Genero.class.getName()));
	}
	
	public Genero insert(Genero obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Genero update(Genero obj) {
		Genero newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Genero que possui jogos");
		}	
	}
	
	public List<Genero> findAll() {
		return repo.findAll();
	}
	
	public Page<Genero> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Genero fromDTO(GeneroDTO objDto) {
		return new Genero(objDto.getId(), objDto.getNome());
	}
	
	private void updateData(Genero newObj, Genero obj) {
		newObj.setNome(obj.getNome());
	}

}
