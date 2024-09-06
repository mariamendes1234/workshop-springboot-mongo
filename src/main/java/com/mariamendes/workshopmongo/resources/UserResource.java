package com.mariamendes.workshopmongo.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mariamendes.workshopmongo.DTO.UserDTO;
import com.mariamendes.workshopmongo.domain.User;
import com.mariamendes.workshopmongo.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findAll();
		List<UserDTO> listDto= list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		 User u = userService.findById(id);
		 return ResponseEntity.ok().body(new UserDTO(u));
		
	}
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO dto){
		 User u = userService.fromDTO(dto);
		 u= userService.insert(u);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		 
		 return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		 userService.delete(id);
		 return ResponseEntity.noContent().build();
		
	}
}
