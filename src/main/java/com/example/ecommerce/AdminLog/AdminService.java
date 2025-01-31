package com.example.ecommerce.AdminLog;

import com.example.ecommerce.UserLog.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;
    //data add
    public ResponseEntity<?> add(AdminModel adminModel) {
        AdminModel adminModel1=new AdminModel();
        adminModel1.setUsername(adminModel.getUsername());
        adminModel1.setPassword(adminModel.getPassword());
        adminRepo.save(adminModel1);
        return new ResponseEntity<>(adminModel1, HttpStatus.OK);
    }

    //login
    public ResponseEntity<?> login(String username, String password) {
        Optional<AdminModel> adminModelOptional=adminRepo.findByUsernameAndPassword(username,password);
        if (adminModelOptional.isPresent())
            return new ResponseEntity<>("Login Success",HttpStatus.OK);
        else
            return new ResponseEntity<>("Invalid Credentials",HttpStatus.NOT_FOUND);
    }

}
