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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stephulz.ProjectAsh.domain.Jogo;
import com.stephulz.ProjectAsh.dto.JogoDTO;
import com.stephulz.ProjectAsh.repositories.GeneroRepository;
import com.stephulz.ProjectAsh.repositories.JogoRepository;
import com.stephulz.ProjectAsh.service.JogoService;
import com.stephulz.ProjectAsh.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value="api/jogos")
@CrossOrigin(origins = "*")
public class JogoResource {
	
	
	@Autowired
	private JogoService service;
	
	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private GeneroRepository generoRepository;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Jogo> find(@PathVariable Integer id) {
		Jogo obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//NON NELIO MATERIAL ~ START
	// api/jogos/generos/generoid
	@PostMapping(value="generos/{generoId}")
    public Jogo createJogo(@PathVariable (value = "generoId") Integer generoId,
                                 @Valid @RequestBody Jogo jogo) {
        return generoRepository.findById(generoId).map(genero -> {
            jogo.setGenero(genero);
            return jogoRepository.save(jogo);
        }).orElseThrow(() -> new ObjectNotFoundException("GeneroId " + generoId + " not found"));
    }
	//NON NELIO MATERIAL ~ END
	
	/*
	//NON NELIO MATERIAL ~ START
	@RequestMapping(value="/generos/{generoId}", method=RequestMethod.POST)
    public Jogo createJogo(@PathVariable (value = "generoId") Integer generoId,
                                 @Valid @RequestBody Jogo jogo) {
        return generoRepository.findById(generoId).map(genero -> {
            jogo.setGenero(genero);
            return jogoRepository.save(jogo);
        }).orElseThrow(() -> new ObjectNotFoundException("PostId " + generoId + " not found"));
    }
	//NON NELIO MATERIAL ~ END
	*/
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody JogoDTO objDto){
		Jogo obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody JogoDTO objDto, @PathVariable Integer id){
		Jogo obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<JogoDTO>> findAll() {
		List<Jogo> list = service.findAll();
		List<JogoDTO> listDto = list.stream().map(obj -> new JogoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<JogoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="oderBy", defaultValue="nome") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) 
	{
		Page<Jogo> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<JogoDTO> listDto = list.map(obj -> new JogoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}	
	
}
