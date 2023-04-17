package com.example.tutorial01.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    private String username;
    private String address;
    private String contact;
    private String role;


    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<ServiceProvider> providerList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Order> orderList;

}
