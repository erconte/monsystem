package br.com.itaumon.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ITMN_ALARME")
public class Alarme {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id_alarme")
	private int idAlarme;
	
	@Column(name="nome", length=100)
	private String nome;
	
	@Column(name="descricao", length=200)
	private String descricao;
	
	@JsonIgnoreProperties("alarme")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="alarme")
	private List<Evento> eventos;
	
	

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Alarme() {
		super();
	}

	

	public Alarme(int idAlarme, String nome, String descricao, List<Evento> eventos) {
		super();
		this.idAlarme = idAlarme;
		this.nome = nome;
		this.descricao = descricao;
		this.eventos = eventos;
	}

	public int getIdAlarme() {
		return idAlarme;
	}

	public void setIdAlarme(int idAlarme) {
		this.idAlarme = idAlarme;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
