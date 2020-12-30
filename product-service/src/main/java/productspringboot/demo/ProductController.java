package productspringboot.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    List<ProductInfo> productList = new ArrayList<ProductInfo>();
    @GetMapping("/{id}")
    public Product getProductDetails(@PathVariable int id){
        // Get Name from product-service
        ProductInfo productInfo = getProductInfo(id);
        // Get Price from pricing-service
        // Get Stock avail from inventory-service
        return new Product(productInfo.getProductId(), productInfo.getProductName(), 999, true);
    }

    private ProductInfo getProductInfo(int id) {
        populateProductList();

        for (ProductInfo p : productList) {
            if (id == p.getProductId())
                return p;
        }
        return null;
    }

    private void populateProductList() {
        productList.add(new ProductInfo(101, "iPhone"));
        productList.add(new ProductInfo(102, "Samsung"));
        productList.add(new ProductInfo(103, "Nokia"));
    }
}
