package com.example.ecommerce.price;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "price_table")
public class PriceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "price_id")
    private Integer priceid;

    @Column(name = "category_id")
    private Integer cid;

    @Column(name = "product_id")
    private Integer pid;

    @Column(name = "price")
    private Double price=0.0;

    @Column(name = "discount_percent")
    private Double discount=0.0;        //discount should be in percentage

    @Column(name="final_price")
    private Double final_price=price-(price*(discount/100));

    public PriceModel() {
    }

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(Double final_price) {
        this.final_price = final_price;
    }
}
