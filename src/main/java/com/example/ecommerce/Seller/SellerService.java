package com.example.ecommerce.Seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SellerService {

    @Autowired
    private SellerRepo sellerRepo;
    //data add
    public ResponseEntity<?> add(SellerModel sellerModel) {
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
}
