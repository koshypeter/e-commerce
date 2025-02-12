package com.example.ecommerce.Category;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;
import com.example.ecommerce.Products.ProductModel;

@Entity
@Table(name = "Category")
@Data
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer cid;

    @Column(name = "category_name")
    private String cname;

    @Column(name = "category_description")
    private String cdesc;

    @Lob
    @Column(name = "image")
    private byte[] cat_image;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ProductModel> products;

    public CategoryModel() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public byte[] getCat_image() {
        return cat_image;
    }

    public void setCat_image(byte[] cat_image) {
        this.cat_image = cat_image;
    }
}
