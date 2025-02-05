package com.example.ecommerce.UserLog;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
//user registration
    public ResponseEntity<?> add(UserModel userModel) {
        UserModel userModel1=new UserModel();
        userModel1.setName(userModel.getName());
        userModel1.setEmail(userModel.getEmail());
        userModel1.setPassword(userModel.getPassword());
        userRepo.save(userModel1);
        return new ResponseEntity<>(userModel1, HttpStatus.OK);
    }
//user login
    public ResponseEntity<?> login(String email, String password) {
        Optional<UserModel> userModelOptional=userRepo.findByEmailAndPassword(email,password);
        if (userModelOptional.isPresent())
            return new ResponseEntity<>("Login Success",HttpStatus.OK);
        else
            return new ResponseEntity<>("Invalid Credentials",HttpStatus.NOT_FOUND);
    }
//new address
    public ResponseEntity<?> newaddress(String email, String address) {
        Optional<UserModel> userModelOptional=userRepo.findByEmail(email);
        if(userModelOptional.isPresent()){
            UserModel userModel2=userModelOptional.get();
            userModel2.setAddress(address);
            userRepo.save(userModel2);
            return new ResponseEntity<>("New Address added",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Invalid email id",HttpStatus.NOT_FOUND);
        }

    }
}
