package br.com.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itaumon.modelo.Equipamento;

public interface EquipamentoDAO extends CrudRepository<Equipamento, Integer>{ 

}
