package com.example.locker_management_system.Services;

import com.example.locker_management_system.CustomException.UserException;
import com.example.locker_management_system.Repository.UserRepository;
import com.example.locker_management_system.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

   @Autowired
    private  UserRepository userRepository;

    @Override
    @Transactional
    public User saveUser(User user) {
        //add user to database
        validatePhone(user);
        return userRepository.save(user);


    }

    public void validatePhone(User user) {
        String phoneNumber = user.getPhoneNumber();

        // Check if the phone number matches Indian phone number norms
        if (phoneNumber == null || !phoneNumber.matches("[6-9]\\d{9}")) {
            throw new UserException("Phone number should be exactly 10 digits, start with 6-9 and be numeric");
        }
    }


}
