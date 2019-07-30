package models;

public class Product {
    private int productID;
    private String productName;
    private int quantity;

    public Product(int productID, String productName, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
