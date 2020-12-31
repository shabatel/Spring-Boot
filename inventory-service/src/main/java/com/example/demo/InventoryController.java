package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InventoryController {

    List<Inventory> inventoryList = new ArrayList<Inventory>();

    @GetMapping("/inventory/{productId}")
    public Inventory getPriceDetails(@PathVariable int productId){
        Inventory inventory = getInventoryInfo(productId);

        return inventory;
    }

    private Inventory getInventoryInfo(int productId) {
        populateInventoryList();

        for (Inventory i : inventoryList) {
            if (productId == i.getProductId())
                return i;
        }
        return null;
    }

    private void populateInventoryList() {
        inventoryList.add(new Inventory(101, 101, true));
        inventoryList.add(new Inventory(102, 102, true));
        inventoryList.add(new Inventory(103, 103, true));
    }
}
