package com.redSocial.RedSocial.entity;

import java.io.File;

public class UsuarioForm {
	private int id;
	private String role;
	private String email;
	private String name;
	private String surname;
	private String password;
	private String nick;
	private String bio;
	private String active;
	private File image;
	
	
	
	public UsuarioForm() {
	}


	public UsuarioForm(int id, String email, String password, String nick) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.nick = nick;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}

}
