package com.redSocial.RedSocial.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="private_messages")
@Access(value=AccessType.FIELD)
public class PrivateMessages {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String message;
	private int emitter;
	private int receiver;
	private String File;
	private String image;
	private String readed;
	private Date created_At;
	
	
	public PrivateMessages() {
		
	}


	public PrivateMessages(int id, String message, int emitter, int receiver, String file, String image, String readed,
			Date created_At) {
		this.id = id;
		this.message = message;
		this.emitter = emitter;
		this.receiver = receiver;
		this.created_At = created_At;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getEmitter() {
		return emitter;
	}


	public void setEmitter(int emitter) {
		this.emitter = emitter;
	}


	public int getReceiver() {
		return receiver;
	}


	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}


	public String getFile() {
		return File;
	}


	public void setFile(String file) {
		File = file;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getReaded() {
		return readed;
	}


	public void setReaded(String readed) {
		this.readed = readed;
	}


	public Date getCreated_At() {
		return created_At;
	}


	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	
	
	
	
	
	
}
