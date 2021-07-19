package com.usermanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
