package com.redSocial.RedSocial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redSocial.RedSocial.entity.PrivateMessages;

public interface PrivateMessageDAO extends JpaRepository<PrivateMessages, Integer> {

	List<PrivateMessages> findByEmitterOrReceiver(Integer idEmitter, Integer idReceiver);
}
