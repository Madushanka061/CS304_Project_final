package com.example.tutorial01.service;



import com.example.tutorial01.dto.ServicesDTO;
import com.example.tutorial01.entity.Services;
import com.example.tutorial01.repo.ServicesRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    @Autowired
    private ServicesRepo repo;
    @Autowired
    private ModelMapper modelMapper;

    public List<ServicesDTO> getAllServices() {
        List<Services> list=repo.findAll();

        if(list!=null){
            return modelMapper.map(list, new TypeToken<List<ServicesDTO>>(){}.getType());
        }
        return null;
    }

    public ServicesDTO getServiceById(int serviceId) {
        Services s=repo.getReferenceById(serviceId);
        if(s==null){
            return null;
        }
        return modelMapper.map(s, new TypeToken<ServicesDTO>(){}.getType());
    }
}
