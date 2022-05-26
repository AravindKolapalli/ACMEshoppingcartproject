package io.recruitment.assessment.api.model;


import javax.persistence.*;

@Entity
@Table(name = "Products")
public class Products  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer productId;
    private String productName;
    private int productPrice;
    private String productCategory;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

//    public void addAttribute(String listProducts, List<Products> listProducts1) {
//    }
}
