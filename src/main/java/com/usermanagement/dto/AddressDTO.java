package com.usermanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usermanagement.entity.Address;

import lombok.Data;

@Data
public class AddressDTO {

    private Integer addressid;

    private Integer id;

    private Integer houseNum;

    private String streetName;

    private String city;

    private Integer pincode;

    private String addressType;

    @JsonIgnore
    public Address asEntity() {

        Address address = new Address();
        address.setAddressType(this.addressType);
        address.setCity(this.city);
        address.setHouseNum(this.houseNum);
        address.setPincode(this.pincode);
        address.setStreetName(this.streetName); // what happens if we dont use this keyword
        return address;

    }

    public Address asEntity(Integer addressId, Integer id) {
        Address address = asEntity();
        if (addressId != null) {
            address.setAddressId(addressId);
        }
        if (id != null) {
            address.setId(id);
        }
        return address;

    }

}
