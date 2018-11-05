package com.stephulz.ProjectAsh.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.stephulz.ProjectAsh.domain.Genero;

public class GeneroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimnento obrigatório")
	@Length(min = 3, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;

	public GeneroDTO() {

	}

	public GeneroDTO(Genero obj) {
		id = obj.getId();
		nome = obj.getNome();
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
}
