package com.springlearnig.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springlearnig.util.AbstractEntity;


@Entity
@Table(name = "TAB_PESSOA")
public class PessoaEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("NOME")
	private String nome;
	
	@JsonProperty("DATA_NASC")
	private String nascimento;
	
	public PessoaEntity(String nome, String nascimento) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
	}

	public PessoaEntity() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

}
