package com.redSocial.RedSocial.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.redSocial.RedSocial.entity.Following;

public interface FollowingDAO extends JpaRepository<Following, Integer> {

	@Query(value="select * from following t Where t.user = ?1")
	List<Following> findByUser(String id);
	
	@Query(value="select * from following t Where t.user = ?1 and t.followed = ?2")
	List<Following> findByUserAndFollowed(String idUser, String idFollowed);
	
	
}
