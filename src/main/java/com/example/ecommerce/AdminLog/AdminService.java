package com.example.ecommerce.AdminLog;

import com.example.ecommerce.Category.CategoryModel;
import com.example.ecommerce.Category.CategoryRepo;
import com.example.ecommerce.UserLog.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.io.IOException;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private CategoryRepo categoryRepo;
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

    public ResponseEntity<?> categoryadd(CategoryModel categoryModel, MultipartFile cat_Image) throws IOException {
        CategoryModel categoryModel1=new CategoryModel();
        categoryModel1.setCid(categoryModel.getCid());
        categoryModel1.setCdesc(categoryModel.getCdesc());
        categoryModel1.setCname(categoryModel.getCname());
        categoryModel1.setCat_image(cat_Image.getBytes());
        categoryRepo.save(categoryModel1);
        return new ResponseEntity<>(categoryModel1,HttpStatus.OK);
    }
}
