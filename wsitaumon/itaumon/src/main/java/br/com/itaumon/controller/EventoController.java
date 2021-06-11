package br.com.itaumon.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.itaumon.dao.EventoDAO;
import br.com.itaumon.modelo.Evento;

@RestController
@CrossOrigin("*")
public class EventoController {
	
	@Autowired
	private EventoDAO dao;
	
	@GetMapping("/intervalo/{ini}/{fim}")
	public ResponseEntity<List<Evento>> getIntervalo(@PathVariable String ini, @PathVariable String fim){
		try {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date inicio = formato.parse(ini);
			Date termino = formato.parse(fim);
			List<Evento> lista = dao.findByDataEvtBetween(inicio, termino);
			if (lista.size()==0) {
				return ResponseEntity.status(404).build();
			}
			return ResponseEntity.ok(lista);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}

		
	}
	
	@GetMapping("/eventos")
	public ResponseEntity<List<Evento>> getAll(){
		List<Evento> lista = (List<Evento>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	}

}
