package com.sonu.customer.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = -4439114469417994000L;

    private String addressId;
    private String addressType;
    private String customerId;
    private String flatNumber;
    private String plotNumber;
    private String buildingName;
    private Integer roadNumber;
    private String street;
    private String city;
    private String country;
    private Long pinCode;
}
