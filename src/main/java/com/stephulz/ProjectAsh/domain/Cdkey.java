package com.stephulz.ProjectAsh.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cdkey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String cdkey;
	
	@OneToMany(mappedBy="cdkeys")
	private List<Jogo> jogos = new ArrayList<>();

	public Cdkey() {
		super();
	}

	public Cdkey(Integer id, String cdkey) {
		super();
		this.id = id;
		this.cdkey = cdkey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdkey == null) ? 0 : cdkey.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cdkey other = (Cdkey) obj;
		if (cdkey == null) {
			if (other.cdkey != null)
				return false;
		} else if (!cdkey.equals(other.cdkey))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jogos == null) {
			if (other.jogos != null)
				return false;
		} else if (!jogos.equals(other.jogos))
			return false;
		return true;
	}
}
