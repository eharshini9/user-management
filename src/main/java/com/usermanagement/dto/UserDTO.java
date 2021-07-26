package com.usermanagement.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usermanagement.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String name;

    private String company;

    private List<AddressDTO> addresses;

    @JsonIgnore
    public User asEntity() {
        User user = new User();
        user.setName(this.name);
        user.setCompany(this.company);
        user.setAddresses(this.addresses.stream()
                                        .map(AddressDTO::asEntity)
                                        .collect(Collectors.toList()));
        return user;

    }

}
