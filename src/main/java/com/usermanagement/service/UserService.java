package com.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usermanagement.dto.AddressDTO;
import com.usermanagement.dto.UserDTO;
import com.usermanagement.entity.Address;
import com.usermanagement.entity.User;
import com.usermanagement.repository.AddressRepository;
import com.usermanagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll()
                      .forEach(user -> users.add(user));
        return users;
    }

    @Transactional
    public void addUser(UserDTO user) {
        userRepository.save(user.asEntity());
    }

    @Transactional
    public void updateUser(UserDTO user, Integer id) {
        addOrUpdateAddress(user.getAddresses(), id);

        Optional<User> currentUser = userRepository.findById(id);
        currentUser.get()
                   .setName(user.getName());
        currentUser.get()
                   .setCompany(user.getCompany());

        userRepository.save(currentUser.get());

    }

    private void addOrUpdateAddress(List<AddressDTO> addresses, Integer id) {

        List<Address> newAddresses = addresses.stream()
                                              .map(address -> address.asEntity(address.getAddressid(), id))
                                              .collect(Collectors.toList());
        addressRepository.saveAll(newAddresses);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id)
                             .get();
    }

    public void uploadUsers(List<UserDTO> users) {
        users.stream()
             .forEach(user -> userRepository.save(user.asEntity()));
    }

}
