package com.redSocial.RedSocial.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redSocial.RedSocial.Util.UtilUsuario;
import com.redSocial.RedSocial.dao.PrivateMessageDAO;
import com.redSocial.RedSocial.entity.PrivateMessages;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("message") //localhost:8080/message
@Api(value="Message Microservice", description="Implements CRUD methods of PrivateMessages")
public class PrivateMessageController {
	
	@Autowired
	private PrivateMessageDAO privateMessageDAO;
	
	@ApiOperation(value = "Find the messages of one user", notes = "Return a List of messages" )
	@GetMapping(value="{userId}") //message/{userId}
	public ResponseEntity<List<PrivateMessages>> getUsuarioById( @PathVariable("userId") Integer userId){
		List<PrivateMessages> messages = privateMessageDAO.findByEmitterOrReceiver(userId, userId);
		
		return ResponseEntity.ok(messages);
	}
	
	@ApiOperation(value = "Create a Message", notes = "Return the created message" )
	@PostMapping(value="newmessage")
	public ResponseEntity<PrivateMessages> createUsuario(@RequestBody PrivateMessages message){
		PrivateMessages newUsuario = privateMessageDAO.save(message);
		return ResponseEntity.ok(newUsuario);
	}

}
