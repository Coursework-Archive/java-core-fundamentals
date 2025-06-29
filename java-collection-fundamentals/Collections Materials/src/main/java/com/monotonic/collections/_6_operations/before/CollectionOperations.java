package com.monotonic.collections._6_operations.before;

import com.monotonic.collections.common.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.print.attribute.SupportedValuesAttribute;

public class CollectionOperations
{
    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    public static void main(String[] args)
    {
        //var products = List.of(door, floorPanel, window);
        var products = new ArrayList<Product>();
        Collections.addAll(products, door, floorPanel, window);

        System.out.println(products);

        Collections.shuffle(products);

        //Collections.fill(products, null);

        System.out.println("products = " + products);


        Product lightestProduct = Collections.min(products, Product.BY_WEIGHT);

        Product heavyProduct = Collections.max(products, Product.BY_WEIGHT);

        System.out.println("lightestProduct = " + lightestProduct);

        System.out.println("heavyProduct = " + heavyProduct);

    }
}
