package productspringboot.demo;

// Module Object
public class ProductInfo {
    private int productId;
    private String productName;

    public ProductInfo(int id, String name){
        productId = id;
        productName = name;
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
}

