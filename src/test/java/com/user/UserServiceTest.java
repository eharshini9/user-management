package com.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.usermanagement.dto.AddressDTO;
import com.usermanagement.dto.UserDTO;
import com.usermanagement.entity.Address;
import com.usermanagement.entity.User;
import com.usermanagement.repository.AddressRepository;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    AddressRepository addressRepository;

    @Test
    public void getAllUsersTest() {

        when(userRepository.findAll()).thenReturn(getUsers());

        List<User> usersList = userService.getAllUsers();

        verify(userRepository, times(1)).findAll();
        assertEquals(2, usersList.size());
        assertEquals(getUsers(), usersList);

    }

    @Test
    public void getUserByIdTest() {

        when(userRepository.findById(1)).thenReturn(Optional.of(getUser()));

        User user = userService.getUser(1);
        assertEquals(user, getUser());

    }

    @Test
    public void addUserTest() {
        userService.addUser(getUserDTO());

        verify(userRepository, times(1)).save(getUserDTO().asEntity());

    }

    @Test
    public void deleteUserTest() {

        userService.deleteUser(1);
        verify(userRepository, times(1)).deleteById(1);

    }

    private UserDTO getUserDTO() {
        AddressDTO ad1 = new AddressDTO(1, 1, "1", "Khesepark", "pune", "411032", "current");
        AddressDTO ad2 = new AddressDTO(2, 1, "2", "Safilguda", "Sec", "50056", "permanent");
        List<AddressDTO> addresses1 = new ArrayList<>();
        addresses1.add(ad1);
        addresses1.add(ad2);
        return new UserDTO(1, "Harshini", "NT", addresses1);

    }

    private User getUser() {
        Address ad1 = new Address(1, 1, "1", "Khesepark", "pune", "411032", "current");
        Address ad2 = new Address(2, 1, "2", "Safilguda", "Sec", "50056", "permanent");
        List<Address> addresses1 = new ArrayList<>();
        addresses1.add(ad1);
        addresses1.add(ad2);
        return new User(1, "Harshini", "NT", addresses1);

    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        Address ad1 = new Address(1, 1, "1", "Khesepark", "pune", "411032", "current");
        Address ad2 = new Address(2, 1, "2", "Safilguda", "Sec", "50056", "permanent");
        List<Address> addresses1 = new ArrayList<>();
        addresses1.add(ad1);
        addresses1.add(ad2);

        User user1 = new User(1, "Harshini", "NT", addresses1);

        Address ad3 = new Address(3, 2, "4", "Khesepark", "pune", "411032", "current");
        Address ad4 = new Address(4, 2, "9", "Akola", "Akkola", "57863", "permanent");
        List<Address> addresses2 = new ArrayList<>();
        addresses2.add(ad3);
        addresses2.add(ad4);

        User user2 = new User(2, "Sarvesh", "NTU", addresses2);

        users.add(user1);
        users.add(user2);
        return users;

    }

}
