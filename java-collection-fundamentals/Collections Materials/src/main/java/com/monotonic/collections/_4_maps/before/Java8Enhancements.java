package com.monotonic.collections._4_maps.before;

import java.lang.module.InvalidModuleDescriptorException;
import java.util.HashMap;
import java.util.Map;

public class Java8Enhancements
{
    public static void main(String[] args)
    {
        Product defaultProd = new Product(
            -1, "Whatever the customer wants", 100);

        Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        System.out.println(idToProduct);


        // lambda 
        idToProduct.replaceAll((id, prod) -> 
        
        new Product(id, prod.getName(), prod.getWeight() + 10));

        System.out.println(idToProduct);

        // compute if absent
        idToProduct.computeIfAbsent(4, id -> new Product(id, "Door Handle", 5));
        idToProduct.computeIfAbsent(3, id -> new Product(id, "Door Handle", 5));

        System.out.println(idToProduct);
        System.out.println(idToProduct.get(4));

        // for each 
        idToProduct.forEach((id, prod) -> {

            System.out.println(prod.getName() + " has an id of " + id);

        });


        

        // Product product = idToProduct.getOrDefault(4, defaultProd);
        // System.out.println(product);
        // System.out.println(idToProduct.get(4));

        // Product oldValue = idToProduct.replace(1, new Product(1, "Big Door", 50));
        // System.out.println(oldValue);
        // System.out.println(idToProduct.get(1));

    }
}
