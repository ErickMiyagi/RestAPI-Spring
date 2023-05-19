package com.example.WorkshopMongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.WorkshopMongo.domain.User;
import com.example.WorkshopMongo.dto.UserDTO;
import com.example.WorkshopMongo.services.UserServices;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserServices service;
	@RequestMapping(method=RequestMethod.GET) // ou GetMapping()
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = service.findAll();
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //Convertendo a lista em uma listaDTO
		return ResponseEntity.ok().body(	listDTO);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET) // ou GetMapping()
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
}
