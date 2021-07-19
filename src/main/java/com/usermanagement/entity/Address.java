package com.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "HOUSE_NUMBER")
    private Integer houseNum;

    @Column(name = "STREET")
    private String streetName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PINCODE")
    private Integer pincode;

    @Column(name = "ADDRESStYPE")
    private String addressType;

}
