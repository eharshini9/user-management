package com.usermanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.usermanagement.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
