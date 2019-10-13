package com.rondinellepessoa.services;

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
}
