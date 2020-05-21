package com.redSocial.RedSocial.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redSocial.RedSocial.dao.FollowingDAO;
import com.redSocial.RedSocial.entity.Following;
import com.redSocial.RedSocial.entity.Usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("following")
@Api(value="Following Microservice", description="Implements CRUD methods")
public class FollowingController {

	@Autowired
	private FollowingDAO followingDAO;
	
	@ApiOperation(value = "Find a List of followed for the registered user", notes = "Return a followers List" )
	@GetMapping(value="{id}")
	public ResponseEntity<List<Following>> getFollows(@PathVariable("id") Integer userId){
		List<Following> following = followingDAO.findByUser(userId.toString());
		return ResponseEntity.ok(following);
	}
	
	@ApiOperation(value = "Unfollow a follower", notes = "Return anything" )
	@DeleteMapping(value="{followingId}")
	public ResponseEntity<Usuario> deleteFollow(@PathVariable("followingId") Integer followingId){
		followingDAO.deleteById(followingId);
		return ResponseEntity.ok(null);
	}
	
	@ApiOperation(value = "Search a follower that you follow", notes = "Return thre follower" )
	@GetMapping(value="seguidor/{idUser}/{idFollowed}")
	public ResponseEntity<List<Following>> getFollows(@PathVariable("idUser") Integer idUser, @PathVariable("idFollowed") Integer idFollowed){
		List<Following> following = followingDAO.findByUserAndFollowed(idUser.toString(), idFollowed.toString());
		return ResponseEntity.ok(following);
	}
}
