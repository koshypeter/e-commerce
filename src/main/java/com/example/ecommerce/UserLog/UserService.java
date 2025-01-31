package com.example.ecommerce.UserLog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public ResponseEntity<?> add(UserModel userModel) {
        UserModel userModel1=new UserModel();
        userModel1.setName(userModel.getName());
        userModel1.setEmail(userModel.getEmail());
        userModel1.setPassword(userModel.getPassword());
        userRepo.save(userModel1);
        return new ResponseEntity<>(userModel1, HttpStatus.OK);
    }

    public ResponseEntity<?> login(String email, String password) {
        Optional<UserModel> userModelOptional=userRepo.findByEmailAndPassword(email,password);
        if (userModelOptional.isPresent())
            return new ResponseEntity<>("Login Success",HttpStatus.OK);
        else
            return new ResponseEntity<>("Invalid Credentials",HttpStatus.NOT_FOUND);
    }
}
