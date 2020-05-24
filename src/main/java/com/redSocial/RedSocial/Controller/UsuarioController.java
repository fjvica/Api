package com.redSocial.RedSocial.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redSocial.RedSocial.Util.UtilUsuario;
import com.redSocial.RedSocial.dao.UsuarioDAO;
import com.redSocial.RedSocial.entity.Usuario;
import com.redSocial.RedSocial.entity.UsuarioForm;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("usuario") //localhost:8080/usuario
@Api(value="User Microservice", description="Implements CRUD methods of User")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
	@ApiOperation(value = "Find a List of Users", notes = "Return a users List" )
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuario(){
		List<Usuario> usuarios = usuarioDAO.findAll();
		return ResponseEntity.ok(usuarios);
	}
	
	
	@ApiOperation(value = "Find a Users", notes = "Return User" )
	@GetMapping(value="{userId}") //usuario/{userId}
	public ResponseEntity<Usuario> getUsuarioById( @PathVariable("userId") Integer userId){
		Optional<Usuario> usuario = usuarioDAO.findById(userId);
		if(!usuario.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuario.get());
	}
	
	@ApiOperation(value = "Create a Users", notes = "Return the created User" )
	@PostMapping(value="register")
	public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioForm usuario){
		UtilUsuario uU = new UtilUsuario();
		Usuario newUsuario = uU.parseUsuario(usuario);
		newUsuario =usuarioDAO.save(newUsuario);
		return ResponseEntity.ok(newUsuario);
	}
	
	@ApiOperation(value = "Delete a Users", notes = "Return anything" )
	@DeleteMapping(value="{userId}")
	public ResponseEntity<Usuario> deleteUsuario(@PathVariable("userId") Integer userId){
		usuarioDAO.deleteById(userId);
		return ResponseEntity.ok(null);
	}

	@ApiOperation(value = "Update a Users", notes = "Return the updated user" )
	@PutMapping
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario){
		Optional<Usuario> optionalUsuario = usuarioDAO.findById(usuario.getId());
		if(optionalUsuario.isPresent()) {
			Usuario updateUser = optionalUsuario.get();
			updateUser.setRole(usuario.getRole());
			updateUser.setEmail(usuario.getEmail());
			updateUser.setName(usuario.getName());
			updateUser.setSurname(usuario.getSurname());
			updateUser.setPassword(usuario.getPassword());
			updateUser.setNick(usuario.getNick());
			updateUser.setBio(usuario.getBio());
			updateUser.setActive(usuario.getActive());
			updateUser.setImage(usuario.getImage());
			usuarioDAO.save(updateUser);
			return ResponseEntity.ok(updateUser);
		}else {
			return ResponseEntity.notFound().build();
		}

	}
	
	
}
