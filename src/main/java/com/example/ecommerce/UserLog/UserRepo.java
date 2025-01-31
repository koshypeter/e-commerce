package com.example.ecommerce.UserLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
    Optional<UserModel> findByEmailAndPassword(String email,String password);
}
