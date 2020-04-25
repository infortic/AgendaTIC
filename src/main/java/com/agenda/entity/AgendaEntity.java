package com.agenda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.agenda.abstractEntity.AbstractId;

@Entity
@Table(name = "TAB_AGENDA")
public class AgendaEntity extends AbstractId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String medico;
	private LocalDateTime horario;
	private LocalDateTime data;
	private String sala;
	private String procedimento;
	private String confirmado;
	private String atendido;

	public AgendaEntity(String medico, LocalDateTime horario, LocalDateTime data, String sala, String procedimento,
			String confirmado, String atendido) {
		super();
		this.medico = medico;
		this.horario = horario;
		this.data = data;
		this.sala = sala;
		this.procedimento = procedimento;
		this.confirmado = confirmado;
		this.atendido = atendido;
	}

	public AgendaEntity() {
		super();
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(String procedimento) {
		this.procedimento = procedimento;
	}

	public String getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(String confirmado) {
		this.confirmado = confirmado;
	}

	public String getAtendido() {
		return atendido;
	}

	public void setAtendido(String atendido) {
		this.atendido = atendido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
