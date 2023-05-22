package com.example.WorkshopMongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.WorkshopMongo.domain.Post;
import com.example.WorkshopMongo.services.PostServices;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostServices service;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET) // ou GetMapping()
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
