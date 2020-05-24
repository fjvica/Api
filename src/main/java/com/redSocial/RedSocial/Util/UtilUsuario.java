package com.redSocial.RedSocial.Util;

import com.redSocial.RedSocial.entity.Usuario;
import com.redSocial.RedSocial.entity.UsuarioForm;

public class UtilUsuario {
	public Usuario parseUsuario(UsuarioForm usuarioFormulario) {
		Usuario usuario = new Usuario();
		usuario.setActive(usuarioFormulario.getActive());
		usuario.setBio(usuarioFormulario.getBio());
		usuario.setEmail(usuarioFormulario.getEmail());
		if(usuarioFormulario.getImage().exists()) {
			usuario.setImage(usuarioFormulario.getImage().getName());
		}
		usuario.setName(usuarioFormulario.getName());
		usuario.setNick(usuarioFormulario.getNick());
		usuario.setPassword(usuarioFormulario.getPassword());
		usuario.setRole(usuarioFormulario.getRole());
		usuario.setSurname(usuarioFormulario.getSurname());
		
		return usuario;
	}

}
