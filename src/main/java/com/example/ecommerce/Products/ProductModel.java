package com.example.ecommerce.Products;
import com.example.ecommerce.Category.CategoryModel;


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

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Integer cid;

    @Column(name = "product_name")
    private String pname;

    @Column(name = "product_description")
    private String pdesc;

    @Lob
    @Column(name = "product_image")
    private byte[] prod_image;

    @Column(name = "Stock-availability")
    private String stock;

    public ProductModel() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public byte[] getProd_image(byte[] bytes) {
        return prod_image;
    }

    public void setProd_image(byte[] prod_image) {
        this.prod_image = prod_image;
    }

}
