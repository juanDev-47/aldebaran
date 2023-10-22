package com.example.aldebaran.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

}
