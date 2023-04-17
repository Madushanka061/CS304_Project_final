package com.example.tutorial01.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderName;
    private String location;
    private String budget;
    private String orderDes;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "providerId", referencedColumnName = "providerId")
    private ServiceProvider provider;
}
