package com.redSocial.RedSocial.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.redSocial.RedSocial.entity.Like;

public interface LikeDAO extends JpaRepository<Like, Integer> {
	@Query(value="select * from likes t Where t.publication = ?1")
	List<Like> findByPublication(String id);

}
