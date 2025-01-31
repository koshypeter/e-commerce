package com.example.ecommerce.Category;


import jakarta.persistence.*;
import lombok.Data;

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

    @Column(name = "image")
    private String imagePath;

}
