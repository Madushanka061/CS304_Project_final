package com.example.tutorial01.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="services")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceId")
    private int serviceId;
    private String serviceName;

    @OneToMany(mappedBy = "service", cascade = CascadeType.REMOVE)
    private List<ServiceProvider> providerList;

}
