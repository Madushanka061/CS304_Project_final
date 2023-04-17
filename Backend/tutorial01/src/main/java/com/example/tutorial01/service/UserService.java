package com.example.tutorial01.service;

import com.example.tutorial01.dto.SignUpDTO;
import com.example.tutorial01.dto.UserDTO;
import com.example.tutorial01.entity.Login;
import com.example.tutorial01.entity.User;
import com.example.tutorial01.repo.LoginRepo;
import com.example.tutorial01.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

     @Autowired
     private LoginRepo loginRepo;
    public UserDTO saveUser(SignUpDTO userDTO){
        User A = modelMapper.map(userDTO, User.class);
         A.setRole("USER");
        User SavedUser=userRepo.save(A);
        Login l=loginRepo.save(Login.builder().user(SavedUser).email(userDTO.getEmail()).password(userDTO.getPassword()).build());
        if(l!=null && SavedUser !=null){
            return modelMapper.map(SavedUser, new TypeToken<UserDTO>(){}.getType());
        }
        return  null;
    }
    public List<UserDTO> getAllUsers(){
        List<User>userList=userRepo.findAll();
        return modelMapper.map(userList,new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }
    public boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }

    public UserDTO getDetailsById(int Id) {

        User user=userRepo.findById(Id).get();

        return UserDTO.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .userId(user.getUserId())
                .address(user.getAddress())
                .contact(user.getContact())
                .build();
    }

    public int updateUserById(int userId) {
        userRepo.save(modelMapper.map(userId,User.class));
        return userId;
    }
}
