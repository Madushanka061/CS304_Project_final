package com.example.tutorial01.Controller;

import com.example.tutorial01.dto.SignUpDTO;
import com.example.tutorial01.dto.UserDTO;
import com.example.tutorial01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){

        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody SignUpDTO userDTO){

        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO)
    {
        return userService.updateUser(userDTO);
    }
    @PutMapping("/updateUser/{userId}")
    public int updateUser(@PathVariable int userId)
    {
        return userService.updateUserById(userId);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO){

        return userService.deleteUser(userDTO);
    }
}
