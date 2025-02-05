package com.example.ecommerce.UserLog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/UserLog")
public class UserController {
   @Autowired
    private UserService userService;

   //data add api
   @PostMapping(path = "/add")
    public ResponseEntity<?>addData(@RequestBody UserModel userModel){
       try{
           return userService.add(userModel);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
   }

   //login api
   @PostMapping(path = "/login")
    public ResponseEntity<?>login(@RequestParam String email,@RequestParam String password){
       try{
           return userService.login(email,password);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return new ResponseEntity<>("Wrong credentials",HttpStatus.NOT_FOUND);
   }

   // address api
    @PostMapping(path = "/newaddress")
    public ResponseEntity<?>newaddress(@RequestParam String email,@RequestParam String address){
       try{
           return userService.newaddress(email,address);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return new ResponseEntity<>("Invalid email",HttpStatus.NOT_FOUND);
    }
}
