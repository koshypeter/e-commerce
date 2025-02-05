package com.example.ecommerce.Seller;

import com.example.ecommerce.Products.ProductModel;
import com.example.ecommerce.Products.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class SellerService {

    @Autowired
    private SellerRepo sellerRepo;
    @Autowired
    private ProductRepo productRepo;
    //registration
    public ResponseEntity<?> reg(SellerModel sellerModel) {
        SellerModel sellerModel1=new SellerModel();
        sellerModel1.setSelleruname(sellerModel.getSelleruname());
        sellerModel1.setSellerpass(sellerModel.getSellerpass());
        sellerRepo.save(sellerModel1);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    //login
    public ResponseEntity<?> login(String selleruname, String sellerpass) {
        Optional<SellerModel> sellerModelOptional=sellerRepo.findBySellerunameAndSellerpass(selleruname,sellerpass);
        if(sellerModelOptional.isPresent())
            return new ResponseEntity<>("Login Success",HttpStatus.OK);
        else
            return new ResponseEntity<>("Invalid Credentials",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> addproduct(ProductModel productModel, MultipartFile prod_image) throws IOException {
        ProductModel productModel1=new ProductModel();
        productModel1.setCid(productModel.getCid());
        productModel1.setPdesc(productModel.getPdesc());
        productModel1.setPname(productModel.getPname());
        productModel1.getProd_image(prod_image.getBytes());
        productRepo.save(productModel1);
        return new ResponseEntity<>(productModel1,HttpStatus.OK);
    }
}
