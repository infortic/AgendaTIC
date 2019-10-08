package com.springlearnig.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springlearnig.abstractEntity.AbstractPessoa;

@Entity
@Table(name="TAB_MEDICO")
public class MedicoEntity extends AbstractPessoa implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@JsonProperty("CRM")
	private String crm;
	@JsonProperty("ESPECIALIDA")
	private String especialidade;
	@JsonProperty("ATIVO")
	private Boolean ativo;
	
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public MedicoEntity(String nome, String nascimento, Integer cpf, String email, String celular, String rua,
			Integer cep, String numeroComplemento, String bairro, String cidade, String crm, String especialidade,
			Boolean ativo) {
		super(nome, nascimento, cpf, email, celular, rua, cep, numeroComplemento, bairro, cidade);
		this.crm = crm;
		this.especialidade = especialidade;
		this.ativo = ativo;
	}
	
	public MedicoEntity() {
		super();
		
	}
	
}
