package com.rparenato.cursoSpringBootMongoDB.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rparenato.cursoSpringBootMongoDB.domain.Post;
import com.rparenato.cursoSpringBootMongoDB.repository.PostRepository;
import com.rparenato.cursoSpringBootMongoDB.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		//return postRepository.findByTitleContainingIgnoreCase(text);
		return postRepository.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 *60 * 1000); // Para somar 24 horas em milisegudos
		return postRepository.fullSearch(text, minDate, maxDate);
	}

}
