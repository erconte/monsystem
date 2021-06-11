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
@Table(name="ITMN_EQUIPAMENTO")
public class Equipamento {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="id_equip")
	private int idEquip;
	
	@Column(name="hostname", length=50)
	private String hostname;
	
	@Column(name="ipaddr", length=15)
	private String ipaddr;
	
	@JsonIgnoreProperties("equipamento")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="equipamento")
	private List<Evento> eventos;
	
	

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Equipamento() {
		super();
	}


	public Equipamento(int idEquip, String hostname, String ipaddr, List<Evento> eventos) {
		super();
		this.idEquip = idEquip;
		this.hostname = hostname;
		this.ipaddr = ipaddr;
		this.eventos = eventos;
	}

	public int getIdEquip() {
		return idEquip;
	}

	public void setIdEquip(int idEquip) {
		this.idEquip = idEquip;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	
	
		

}
