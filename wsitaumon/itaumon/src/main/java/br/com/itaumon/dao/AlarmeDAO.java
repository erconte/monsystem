package br.com.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itaumon.modelo.Alarme;

public interface AlarmeDAO extends CrudRepository<Alarme, Integer>{

}
