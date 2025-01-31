package com.example.ecommerce.Seller;

import com.example.ecommerce.AdminLog.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    //data add api
    @PostMapping(path = "/add")
    public ResponseEntity<?> addData(@RequestBody SellerModel sellerModel){
        try{
            return sellerService.add(sellerModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //login api
    @PostMapping(path = "/login")
    public ResponseEntity<?>login(@RequestParam String selleruname, @RequestParam String sellerpass){
        try{
            return sellerService.login(selleruname,sellerpass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Wrong credentials",HttpStatus.NOT_FOUND);
    }

}
