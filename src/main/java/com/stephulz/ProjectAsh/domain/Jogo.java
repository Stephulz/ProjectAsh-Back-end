package com.stephulz.ProjectAsh.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jogo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String desenvolvedora;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataLancamento;
	
	private Double preco;
	
	private String descricao;
	
	private String plataforma;
	
	private String quantJogadores;
	
	private String compatControle;

	@JsonIgnore
	@OneToMany
	@JoinTable(name = "JOGO_CDKEY",
	joinColumns = @JoinColumn(name = "jogo_id"),
	inverseJoinColumns = @JoinColumn(name = "cdkey_id"))
	private List<Cdkey> cdkeys = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "JOGO_GENERO",
	joinColumns = @JoinColumn(name = "jogo_id"),
	inverseJoinColumns = @JoinColumn(name = "genero_id"))
	@Column(name = "genero_id")
	private List<Genero> generos = new ArrayList<>();
	
	public Jogo(){
		
	}
	
	public Jogo(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Cdkey> getCdKeys() {
		return cdkeys;
	}

	public void setCdKeys(List<Cdkey> cdKeys) {
		this.cdkeys = cdKeys;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
}
