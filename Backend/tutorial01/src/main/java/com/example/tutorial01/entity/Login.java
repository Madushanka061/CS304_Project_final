package com.example.tutorial01.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "login_table")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginId")
    private int loginId;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId")
    private User user;
}
