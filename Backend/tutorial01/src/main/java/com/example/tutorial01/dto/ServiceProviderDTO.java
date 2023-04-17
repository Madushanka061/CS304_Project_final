package com.example.tutorial01.dto;

import com.example.tutorial01.entity.Services;
import com.example.tutorial01.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServiceProviderDTO {
    private int providerId;
    private String providerName;
    private String contact;
    private String location;
    private int rate;
    private String description;
    private int userId;
    private int serviceId;
}
