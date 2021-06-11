package br.com.itaumon.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ITMN_EVENTO")
public class Evento {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="num_seq")
	private int numSeq;
	
	@Column(name="data_evt")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyy")
	private Date dataEvt;
	
	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Equipamento equipamento;
	
	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Alarme alarme;
	
	
	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Alarme getAlarme() {
		return alarme;
	}

	public void setAlarme(Alarme alarme) {
		this.alarme = alarme;
	}

	public Evento() {
		super();
	}

	

	public Evento(int numSeq, Date dataEvt, Equipamento equipamento, Alarme alarme) {
		super();
		this.numSeq = numSeq;
		this.dataEvt = dataEvt;
		this.equipamento = equipamento;
		this.alarme = alarme;
	}

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public Date getDataEvt() {
		return dataEvt;
	}

	public void setDataEvt(Date dataEvt) {
		this.dataEvt = dataEvt;
	}



}
