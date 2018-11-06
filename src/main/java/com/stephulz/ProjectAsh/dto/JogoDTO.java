package com.stephulz.ProjectAsh.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stephulz.ProjectAsh.domain.Cdkey;
import com.stephulz.ProjectAsh.domain.Genero;
import com.stephulz.ProjectAsh.domain.Jogo;

public class JogoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String nome;

	private String desenvolvedora;
	
	private Date dataLancamento;
	
	private Double preco;
	
	private String descricao;
	
	private String plataforma;
	
	private String quantJogadores;
	
	private String compatControle;
	
	private List<Cdkey> cdKeys = new ArrayList<>();
	
	private List<Genero> generos = new ArrayList<>();
	
	public JogoDTO() {
		
	}

	public JogoDTO(Jogo obj) {
		id = obj.getId();
		nome = obj.getNome();
		desenvolvedora = obj.getDesenvolvedora();
		dataLancamento = obj.getDataLancamento();
		preco = obj.getPreco();
		descricao = obj.getDescricao();
		plataforma = obj.getPlataforma();
		quantJogadores = obj.getQuantJogadores();
		compatControle = obj.getCompatControle();
		cdKeys = obj.getCdKeys();
		generos = obj.getGeneros();
	}


	public List<Cdkey> getCdKeys() {
		return cdKeys;
	}

	public void setCdKeys(List<Cdkey> cdKeys) {
		this.cdKeys = cdKeys;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getQuantJogadores() {
		return quantJogadores;
	}

	public void setQuantJogadores(String quantJogadores) {
		this.quantJogadores = quantJogadores;
	}

	public String getCompatControle() {
		return compatControle;
	}

	public void setCompatControle(String compatControle) {
		this.compatControle = compatControle;
	}
}
