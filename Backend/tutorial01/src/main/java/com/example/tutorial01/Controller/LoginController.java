package com.example.tutorial01.Controller;

import com.example.tutorial01.dto.LoginDTO;
import com.example.tutorial01.dto.LoginLogDTO;
import com.example.tutorial01.dto.UserDTO;
import com.example.tutorial01.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin

public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/allLogins")
    public List<LoginDTO> getAllLogins(){
        return loginService.getAllLoginDetails();
    }

    @GetMapping("/detailByLoginId/{id}")
    public LoginDTO getDetailsById(@PathVariable int id){
        return loginService.getByLoginId(id);
    }
    @GetMapping("/detailByUserId/{userId}")
    public LoginDTO getDetailsByUserId(@PathVariable int userId){
        return loginService.getDetailsByUserId(userId);
    }
    @GetMapping("/data/{email}")
    public LoginLogDTO getDetailsById(@PathVariable String email){
        return loginService.getDetailsByEmail(email);
    }
    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginDTO data){
        return loginService.login(data);
    }
}
