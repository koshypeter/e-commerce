package com.example.ecommerce.AdminLog;

import com.example.ecommerce.Category.CategoryModel;
import com.example.ecommerce.UserLog.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api/Admin")
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

    //category add api
    @PostMapping(path = "/categoryadd")
    public ResponseEntity<?>categoryaddmethod(@RequestPart CategoryModel categoryModel, @RequestPart MultipartFile cat_image){
        try{
            return adminService.categoryadd(categoryModel,cat_image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }
    //update category
    @PutMapping(path = "/updatecategory")
    public ResponseEntity<?>updatecategory(@RequestParam Integer cid,@RequestPart CategoryModel categoryModel,@RequestPart MultipartFile cat_image) throws IOException {
        try{
            return adminService.updatecategory(cid,categoryModel,cat_image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
    }
    //get all categories
    @GetMapping(path = "/getallcategory")
    public ResponseEntity<List<CategoryModel>>getallcategory(){
        try{
            return adminService.getallcategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //get category by id
    @GetMapping(path = "/getcategorybyid")
    public ResponseEntity<?>getcategorybyid(Integer cid){
        try{
            return adminService.getcategorybyid(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    //delete category by id
    @DeleteMapping(path = "/deletecategory")
    public ResponseEntity<?>deletecategorybyid(Integer cid){
        try{
            return adminService.deletecategory(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Invalid id",HttpStatus.NOT_FOUND);
    }

}
