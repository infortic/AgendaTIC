package com.agenda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.agenda.abstractEntity.AbstractId;

@Entity
@Table(name = "TAB_AGENDA")
public class AgendaEntity extends AbstractId implements Serializable {
	private static final long serialVersionUID = 1L;

	private String medico;
	private Date dataDoAgendamento;
	private Date horario;
	private Date data;
	private String sala;
	private String procedimento;
	private String confirmado;
	private String atendido;


	public AgendaEntity(String medico, Date dataDoAgendamento, Date horario, Date data, String sala,
			String procedimento, String confirmado, String atendido) {
		super();
		this.medico = medico;
		this.dataDoAgendamento = dataDoAgendamento;
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

	
	
	
	public Date getDataDoAgendamento() {
		return dataDoAgendamento;
	}




	public void setDataDoAgendamento(Date dataDoAgendamento) {
		this.dataDoAgendamento = dataDoAgendamento;
	}




	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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
