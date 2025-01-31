package com.example.ecommerce.AdminLog;

import com.example.ecommerce.UserLog.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/Adminreg")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //api to add admin username and password
    @PostMapping(path = "/add")
    public ResponseEntity<?> addData(@RequestBody AdminModel adminModel){
        try{
            return adminService.add(adminModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //login api
    @PostMapping(path = "/login")
    public ResponseEntity<?>login(@RequestParam String username, @RequestParam String password){
        try{
            return adminService.login(username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Wrong credentials",HttpStatus.NOT_FOUND);
    }
}
