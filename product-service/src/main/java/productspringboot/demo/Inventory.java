package productspringboot.demo;

public class Inventory {
    private int inventoryId;
    private int productId;
    private boolean inStock;

    public Inventory(int inventoryId, int productId, boolean inStock){
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.inStock = inStock;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
