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
import com.stephulz.ProjectAsh.domain.Jogo;
import com.stephulz.ProjectAsh.dto.JogoDTO;
import com.stephulz.ProjectAsh.repositories.JogoRepository;
import com.stephulz.ProjectAsh.service.exception.DataIntegrityException;
import com.stephulz.ProjectAsh.service.exception.ObjectNotFoundException;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository repo;
	
	@Autowired
	private JogoService jogoService;

	public Jogo find(Integer id) {

		Optional<Jogo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Jogo.class.getName()));
	}
	
	public Jogo insert(Jogo obj) {
		obj.setJogoId(null);		
		return repo.save(obj);
	}
	
	public Jogo update(Jogo obj, Genero generoId) {
		Jogo newObj = find(obj.getJogoId());
		newObj.setGenero(generoId);
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public Page<Jogo> search(String nome,Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByNome(nome, pageRequest);		
	}
	
	public Page<Jogo> selectByGenero(Integer genero,Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findDistinctByGenero(genero, pageRequest);		
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Jogo que possui relações");
		}	
	}
	
	public List<Jogo> findAll() {
		return repo.findAll();
	}
	
	public Page<Jogo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Jogo fromDTO(JogoDTO objDto) {
		return new Jogo(objDto.getJogoId(), objDto.getNome(), objDto.getDesenvolvedora(), objDto.getDataLancamento(),
				objDto.getPreco(), objDto.getDescricao(), objDto.getPlataforma(), objDto.getQuantJogadores(),
				objDto.getCompatControle(), objDto.getUrlImagem());
	}
	
	private void updateData(Jogo newObj, Jogo obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setDataLancamento(obj.getDataLancamento());
		
		newObj.setPreco(obj.getPreco());
		newObj.setDescricao(obj.getDescricao());
		newObj.setPlataforma(obj.getPlataforma());
		newObj.setQuantJogadores(obj.getQuantJogadores());
		newObj.setCompatControle(obj.getCompatControle());
		newObj.setDesenvolvedora(obj.getDesenvolvedora());
		newObj.setUrlImagem(obj.getUrlImagem());
	}
}
