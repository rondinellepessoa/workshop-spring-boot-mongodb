package com.rondinellepessoa.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rondinellepessoa.domain.Post;
import com.rondinellepessoa.repository.PostRepository;
import com.rondinellepessoa.services.exeception.ObjectNotFoundException;

/**
 * Responsavel pelo acesso ao banco de dados MongoDB 
 * @author Rondinelle
 *
 */
@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(Integer id) {
		Post post = repo.findById(id).orElse(null);
		if (post == null)
			throw new ObjectNotFoundException("Objeto nao encontrado.");
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
//		return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
