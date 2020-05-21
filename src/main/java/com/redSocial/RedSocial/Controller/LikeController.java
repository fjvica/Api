package com.redSocial.RedSocial.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redSocial.RedSocial.dao.LikeDAO;
import com.redSocial.RedSocial.entity.Like;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("like") //localhost:8080/usuario
@Api(value="Like Microservice", description="Implements CRUD methods of Like")
public class LikeController {

	@Autowired
	private LikeDAO likeDAO;
	
	
	@ApiOperation(value = "Find a List of likes of one publication", notes = "Return a likes List" )
	@GetMapping(value="{idPublication}")
	public ResponseEntity<List<Like>> getFollows(@PathVariable("idPublication") Integer idPublication){
		List<Like> like = likeDAO.findByPublication(idPublication.toString());
		return ResponseEntity.ok(like);
	}
}
