package com.redSocial.RedSocial.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="following")
@Access(value=AccessType.FIELD)
public class Following {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String user;
	private String followed;
	
	
	public Following() {
		super();
	}


	public Following(int id, String user, String followed) {
		this.id = id;
		this.user = user;
		this.followed = followed;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getFollowed() {
		return followed;
	}


	public void setFollowed(String followed) {
		this.followed = followed;
	}
	
	
	

}
