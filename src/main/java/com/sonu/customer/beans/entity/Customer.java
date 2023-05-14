package com.sonu.customer.beans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = -4439114469417994000L;

    @Id
    private String customerId;
    private String customerName;
    private LocalDate customerDOB;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Address> addresses;
}
