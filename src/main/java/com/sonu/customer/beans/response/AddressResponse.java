package com.sonu.customer.beans.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private String addressId;
    private String addressType;
    private String flatNumber;
    private String plotNumber;
    private Long buildingName;
    private LocalDate roadNumber;
    private String street;
    private String city;
    private String country;
    private String pinCode;
}
