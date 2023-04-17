package com.example.tutorial01.service;


import com.example.tutorial01.dto.LoginDTO;
import com.example.tutorial01.dto.LoginLogDTO;
import com.example.tutorial01.dto.UserDTO;
import com.example.tutorial01.entity.Login;
import com.example.tutorial01.repo.LoginRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRepo loginRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    public List<LoginDTO> getAllLogins(){
        List<Login> logins=loginRepo.findAll();
        return modelMapper.map(logins,new TypeToken<ArrayList<LoginDTO>>(){}.getType());
    }
    public boolean validateEmail(String email){
        Login l=loginRepo.validateEmail1(email);
        if (l==null){
            return true;
        }return false;
    }
    public  LoginDTO addLoginDetails(LoginDTO data){
        Login login=modelMapper.map(data,Login.class);
        Login l=loginRepo.save(login);
        if (login!=null){
            return modelMapper.map(l,new TypeToken<LoginDTO>(){}.getType());
        }
        return  null;
    }

    public  List<LoginDTO> getAllLoginDetails(){
        try {
            List<Login> logins=loginRepo.findAll();
            return modelMapper.map(logins,new TypeToken<LoginDTO>(){}.getType());
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    public  LoginDTO getByLoginId(int loginId){
        Login login=loginRepo.getLoginDetailsById(loginId);
        return modelMapper.map(login,LoginDTO.class);
    }

    public LoginLogDTO getDetailsByEmail(String email){
        Login login = loginRepo.getDetailsByEmail(email);
        return modelMapper.map(login,LoginLogDTO.class);
    }

    public LoginDTO getDetailsByUserId(int userId){
        Login login = loginRepo.getLoginDetailsByUserId(userId);
        return modelMapper.map(login,LoginDTO.class);
    }

    public UserDTO login(LoginDTO data){
        Login login=loginRepo.login(data.getEmail(),data.getPassword());
        if (login!=null){
            System.out.println("user is there");
            return userService.getDetailsById(login.getUser().getUserId());
        }
        return null;
    }
}
