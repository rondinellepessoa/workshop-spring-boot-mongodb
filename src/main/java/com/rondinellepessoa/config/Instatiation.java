package com.rondinellepessoa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rondinellepessoa.domain.User;
import com.rondinellepessoa.repository.UserRepository;

/**
 * Classe responsavel por popular o banco de dados MongoDB
 * @author Rondinelle
 *
 */
@Configuration
public class Instatiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(1, "Maria Brown", "maria@gmail.com");
		User alex = new User(2, "Alex Green", "alex@gmail.com");
		User bob = new User(3, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
