package com.stephulz.ProjectAsh.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Jogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jogoId;

	private String nome;

	private String desenvolvedora;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataLancamento;

	private Double preco;

	private String descricao;

	private String plataforma;

	private String quantJogadores;

	private String compatControle;

	private String urlImagem;

	@OneToMany(mappedBy = "jogo")
	private List<Cdkey> cdkey;

	// @JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "genero_id", nullable = false)
	private Genero genero;
	
	public Jogo() {
		
	}

	public Jogo(Integer id, String nome, String desenvolvedora, Date dataLancamento, Double preco,
			String descricao, String plataforma, String quantJogadores, String compatControle, String urlImagem) {
		this.jogoId = id;
		this.nome = nome;
		this.desenvolvedora = desenvolvedora;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.descricao = descricao;
		this.plataforma = plataforma;
		this.quantJogadores = quantJogadores;
		this.compatControle = compatControle;
		this.urlImagem = urlImagem;
		this.cdkey = cdkey;
		this.genero = genero;
	}

	public Integer getJogoId() {
		return jogoId;
	}

	public void setJogoId(Integer jogoId) {
		this.jogoId = jogoId;
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

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public List<Cdkey> getCdkey() {
		return cdkey;
	}

	public void setCdkey(List<Cdkey> cdkey) {
		this.cdkey = cdkey;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}
