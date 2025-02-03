package com.example.ecommerce.Products;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_table")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="product_id")
    private Integer pid;

    @Column(name = "product_name")
    private String pname;

    @Column(name = "product_description")
    private String pdesc;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount_percent")
    private Double discount;

    //@Column(name = "final_price")
    //private Double final_price=price-(price*(discount/100));

    @Lob
    @Column(name = "product_image")
    private byte[] prod_image;

    public ProductModel() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public byte[] getProd_image() {
        return prod_image;
    }

    public void setProd_image(byte[] prod_image) {
        this.prod_image = prod_image;
    }

    //public Double getFinal_price() {
      //  return final_price;
   // }

    //public void setFinal_price(Double final_price) {
       // this.final_price = final_price;
    //}
}
