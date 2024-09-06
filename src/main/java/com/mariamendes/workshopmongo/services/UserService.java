package com.mariamendes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariamendes.workshopmongo.DTO.UserDTO;
import com.mariamendes.workshopmongo.domain.User;
import com.mariamendes.workshopmongo.repository.UserRepository;
import com.mariamendes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User findById(String id) {
		Optional<User> u = userRepository.findById(id);
		return u.orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado"));	
	}

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User insert(User u) {
		return userRepository.insert(u);
	}
	
	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(),dto.getName(),dto.getEmail());
	}
}
