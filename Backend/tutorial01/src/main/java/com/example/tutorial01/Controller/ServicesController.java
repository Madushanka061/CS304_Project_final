package com.example.tutorial01.Controller;
import com.example.tutorial01.dto.ServicesDTO;
import com.example.tutorial01.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/service")
@CrossOrigin
public class ServicesController {

    @Autowired
    private ServicesService service;

    @GetMapping("/getallservices")
    public List<ServicesDTO> getAllServices(){
        return service.getAllServices();
    }

    @GetMapping("/getservicebyid/{serviceId}")
    public ServicesDTO getServiceById(@PathVariable int serviceId){
        return service.getServiceById(serviceId);
    }
}
