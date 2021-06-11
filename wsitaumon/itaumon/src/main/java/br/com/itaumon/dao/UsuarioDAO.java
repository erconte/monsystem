package br.com.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itaumon.modelo.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{
	

}
