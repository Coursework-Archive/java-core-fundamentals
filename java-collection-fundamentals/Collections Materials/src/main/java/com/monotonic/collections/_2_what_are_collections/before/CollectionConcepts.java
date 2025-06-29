package com.monotonic.collections._2_what_are_collections.before;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionConcepts
{
    public static void main(String[] args)
    {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);



        // System.out.println(products);

        // for (Product product : products) {
        //     System.out.println(product);
        // }

        /* The following for each results in a ConcurrentModificationException error 
        for (Product product : products){
            if(product.getWeight() > 20){
                products.remove(product);
            }
        }
        */



        // Using iterator is a good way to handle elements one at a time
        /*
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getWeight() > 20) {
                iterator.remove();
            }

        }
        System.out.println(products);
        */
        /*
        System.out.println(products.size()); // 3
        System.out.println(products.isEmpty()); // false
        System.out.println(products.contains(window)); // true
        System.out.println(products.remove(window)); // true
        System.out.println(products.contains(window)); // false
        */

        Collection<Product> toRemove = new ArrayList<>();
        toRemove.add(door);
        toRemove.add(floorPanel);
        products.removeAll(toRemove);
        System.out.println(products);




        
    }
}
