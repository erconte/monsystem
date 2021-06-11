package br.com.itaumon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itaumon.dao.EquipamentoDAO;
import br.com.itaumon.modelo.Equipamento;

@RestController
@CrossOrigin("*")
public class EquipamentoController {

	@Autowired
	private EquipamentoDAO dao;
	
	@GetMapping("/equipamentos")
	public ResponseEntity<List<Equipamento>> getAll(){

		List<Equipamento> lista = (List<Equipamento>) dao.findAll();
		if (lista.size()==0) {
			return ResponseEntity.status(404).build();
		}

		return ResponseEntity.ok(lista);

	}
	
	
	
}
