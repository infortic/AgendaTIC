package com.agenda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.agenda.abstractEntity.AbstractPessoa;
import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="TAB_CLIENTE")
@Entity
public class ClienteEntity extends AbstractPessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("RG")
    private String rg;
    private Boolean ativo;
	
    
    
    
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
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
	

	public ClienteEntity(String nome, String nascimento, Integer cpf, String email, String celular, String rua,
			Integer cep, String numeroComplemento, String bairro, String cidade, String rg, Boolean ativo) {
		super(nome, nascimento, cpf, email, celular, rua, cep, numeroComplemento, bairro, cidade);
		this.rg = rg;
		this.ativo = ativo;
	} 
	
	public ClienteEntity() {
		super();
		} 
	
}
