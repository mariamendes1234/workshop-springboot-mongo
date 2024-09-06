package com.mariamendes.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariamendes.workshopmongo.domain.Post;
import com.mariamendes.workshopmongo.repository.PostRepository;
import com.mariamendes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text){
		//http://localhost:8080/posts/search?test=bom%20dia (codificado)
		return repo.findByTitle(text);
	}
}
