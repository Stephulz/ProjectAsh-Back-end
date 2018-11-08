package com.stephulz.ProjectAsh.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stephulz.ProjectAsh.domain.Genero;
import com.stephulz.ProjectAsh.dto.GeneroDTO;
import com.stephulz.ProjectAsh.service.GeneroService;

@RestController
@RequestMapping(value="api/generos")
@CrossOrigin(origins = "*")
public class GeneroResource {

	@Autowired
	private GeneroService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Genero> find(@PathVariable Integer id) {
		Genero obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody GeneroDTO objDto){
		Genero obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody GeneroDTO objDto, @PathVariable Integer id){
		Genero obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GeneroDTO>> findAll() {
		List<Genero> list = service.findAll();
		List<GeneroDTO> listDto = list.stream().map(obj -> new GeneroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<GeneroDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="oderBy", defaultValue="nome") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) 
	{
		Page<Genero> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<GeneroDTO> listDto = list.map(obj -> new GeneroDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
