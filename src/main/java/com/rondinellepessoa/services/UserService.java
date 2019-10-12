package com.rondinellepessoa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rondinellepessoa.domain.User;
import com.rondinellepessoa.repository.UserRepository;
import com.rondinellepessoa.services.exeception.ObjectNotFoundException;

/**
 * Responsavel pelo acesso ao banco de dados MongoDB
 * @author Rondinelle
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(Integer id) {
		User user = repo.findById(id).orElse(null);
		if (user == null)
			throw new ObjectNotFoundException("Objeto nao encontrado.");
		return user;
	}
	
}
