package com.example.ecommerce.Seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SellerRepo extends JpaRepository<SellerModel,Integer> {
    Optional<SellerModel> findBySellerunameAndSellerpass(String selleruname, String sellerpass);
}
