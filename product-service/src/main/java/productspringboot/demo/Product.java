package productspringboot.demo;

// Used to hold the info so we can send back the respond
public class Product {
    private int productId;
    private String productName;
    private int productPrice;
    private boolean productInStock;

    public Product(int id, String name, int price, boolean inStock){
        productId = id;
        productName = name;
        productPrice = price;
        productInStock = inStock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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

    public boolean isProductInStock() {
        return productInStock;
    }

    public void setProductInStock(boolean productInStock) {
        this.productInStock = productInStock;
    }
}
