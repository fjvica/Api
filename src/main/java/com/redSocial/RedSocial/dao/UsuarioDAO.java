package com.redSocial.RedSocial.dao;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.redSocial.RedSocial.entity.Usuario;;

public interface UsuarioDAO extends JpaRepository<Usuario,Integer>{

	@Query(value="select * from users t Where t.nick = ?1")
	Optional<Usuario> findByNick(String nick);

}
