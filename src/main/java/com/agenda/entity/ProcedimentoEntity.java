package com.agenda.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.agenda.abstractEntity.AbstractId;

@Entity
@Table(name="TAB_SALA")
public class ProcedimentoEntity extends AbstractId implements Serializable{
	private static final long serialVersionUID = 1L;
   
	private String nome;
	private Boolean ativo;
	private float preco; 
	
	
	
	public ProcedimentoEntity(String nome, Boolean ativo, float preco) {
		super();
		this.nome = nome;
		this.ativo = ativo;
		this.preco = preco;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public ProcedimentoEntity() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	
	

}
