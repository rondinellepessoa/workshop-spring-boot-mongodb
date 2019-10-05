package com.rondinellepessoa.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rondinellepessoa.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
