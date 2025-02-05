package com.example.ecommerce.Seller;

import com.example.ecommerce.AdminLog.AdminModel;
import com.example.ecommerce.Category.CategoryModel;
import com.example.ecommerce.Products.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    //registration api
    @PostMapping(path = "/add")
    public ResponseEntity<?> addData(@RequestBody SellerModel sellerModel){
        try{
            return sellerService.reg(sellerModel);
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


    @PostMapping(path = "/addproduct")
    public ResponseEntity<?>addproduct(@RequestPart ProductModel productModel, @RequestPart MultipartFile prod_image) throws IOException {
        try{
            return sellerService.addproduct(productModel,prod_image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }
}
