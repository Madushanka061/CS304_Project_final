package com.example.tutorial01.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Table(name="serviceprovider")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "providerId")
    private int providerId;
    @Column(name = "providerName")
    private String providerName;
    @Column(name = "contact")
    private String contact;
    @Column(name = "location")
    private String location;
    @Column(name = "rate", columnDefinition = "integer default 0")
    private int rate;
    private String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "serviceId",referencedColumnName = "serviceId")
    private Services service;

    @OneToMany(mappedBy = "provider",cascade = CascadeType.REMOVE)
    private List<Order> orderList;

}