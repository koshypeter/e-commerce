package com.example.ecommerce.Seller;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
@Data
@Table(name = "seller_table")
public class SellerModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer sid;

    @Column(name = "username")
    private String selleruname;

    @Column(name = "password")
    private String sellerpass;

    public SellerModel() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSelleruname() {
        return selleruname;
    }

    public void setSelleruname(String selleruname) {
        this.selleruname = selleruname;
    }

    public String getSellerpass() {
        return sellerpass;
    }

    public void setSellerpass(String sellerpass) {
        this.sellerpass = sellerpass;
    }
}
