package productspringboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    List<ProductInfo> productList = new ArrayList<ProductInfo>();

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/product/details/{id}")
    public Product getProductDetails(@PathVariable Long id){
        // Get Name from product-service
        ProductInfo productInfo = getProductInfo(id);

        // Get Price from pricing-service
        Price price = restTemplate.getForObject("http://localhost:8002/price/" + id, Price.class);

        // Get Stock avail from inventory-service
        Inventory inventory = restTemplate.getForObject("http://localhost:8003/inventory/" + id, Inventory.class);

        return new Product(productInfo.getProductId(), productInfo.getProductName(), price.getDiscountedPrice(), inventory.isInStock());
    }

    private ProductInfo getProductInfo(Long id) {
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
