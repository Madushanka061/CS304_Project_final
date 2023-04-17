package com.example.tutorial01.service;

import com.example.tutorial01.dto.ServiceProviderDTO;
import com.example.tutorial01.dto.UserDTO;
import com.example.tutorial01.entity.Login;
import com.example.tutorial01.entity.ServiceProvider;
import com.example.tutorial01.entity.User;
import com.example.tutorial01.repo.ServiceProviderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProviderService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ServiceProviderRepo serviceProviderRepo;

    public ServiceProviderDTO saveServiceProvider(ServiceProviderDTO serviceProviderDTO){
        ServiceProvider A = modelMapper.map(serviceProviderDTO, ServiceProvider.class);

        ServiceProvider SavedServiceProvider=serviceProviderRepo.save(A);

        return serviceProviderDTO;
    }

    public List<ServiceProviderDTO> getAllProviders() {
        List<ServiceProvider> list= serviceProviderRepo.findAll();
        if(list == null){
            return null;
        }
        return modelMapper.map(list, new TypeToken<List<ServiceProviderDTO>>(){}.getType());
    }


    public ServiceProviderDTO getDetailsBySId(int providerId) {
        ServiceProvider sp = serviceProviderRepo.getReferenceById(providerId);
        return modelMapper.map(sp,new TypeToken<ServiceProviderDTO>(){}.getType());
    }
}
