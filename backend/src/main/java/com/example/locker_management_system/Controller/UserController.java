package com.example.locker_management_system.Controller;

import com.example.locker_management_system.Services.UserService;
import com.example.locker_management_system.Entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
   private  UserService userService;





    //add user to database
    @PostMapping("/add")
    @ResponseStatus( value = HttpStatus.CREATED)

   public User saveUser ( @Valid @RequestBody User user)
   {
       return userService.saveUser(user);
   }
}
