package com.springlearnig.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.springlearnig.abstractEntity.AbstractId;

@Entity
@Table(name="TAB_SALA")
public class SalaEntity extends AbstractId implements Serializable{
	private static final long serialVersionUID = 1L;
   
	private Integer numero;
	private String nome;
	private String piso;
    private Boolean ativo;
	
    
	public SalaEntity(Integer numero, String nome, String piso, Boolean ativo) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.piso = piso;
		this.ativo = ativo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SalaEntity() {
		super();
		
	}
}
