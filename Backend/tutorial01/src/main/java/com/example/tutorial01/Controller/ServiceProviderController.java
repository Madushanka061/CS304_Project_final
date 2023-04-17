package com.example.tutorial01.Controller;
import com.example.tutorial01.dto.ServiceProviderDTO;
import com.example.tutorial01.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/service_provider")
@CrossOrigin
public class ServiceProviderController {
    @Autowired
    private ServiceProviderService serviceProviderService;

    @PostMapping("/saveServiceProvider")
    public ServiceProviderDTO saveServiceProvider(@RequestBody ServiceProviderDTO serviceProviderDTO){
        return serviceProviderService.saveServiceProvider(serviceProviderDTO);
    }

    @GetMapping("/getallproviders")
    public List<ServiceProviderDTO> getAllProviders(){
        return serviceProviderService.getAllProviders();
    }

    @GetMapping("/detailsByServiceproviderId/{providerId}")
    public ServiceProviderDTO getDetailsById(@PathVariable int providerId){
        return serviceProviderService.getDetailsBySId(providerId);
    }
}
