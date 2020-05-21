package com.redSocial.RedSocial.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="likes")
@Access(value=AccessType.FIELD)
public class Like {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String user;
	private String publication;
	
	public Like(int id, String user, String publication) {
		this.id = id;
		this.user = user;
		this.publication = publication;
	}

	public Like() {
		
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

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	
	
	
	
	
}
