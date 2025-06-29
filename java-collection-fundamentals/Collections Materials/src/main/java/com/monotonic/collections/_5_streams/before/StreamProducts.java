package com.monotonic.collections._5_streams.before;

import com.monotonic.collections._3_lists.Shipment;
import com.monotonic.collections._5_streams.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;

public class StreamProducts
{
    public static void main(String[] args)
    {
        Product door = new Product(1, "Wooden Door", 35);
        Product floorPanel = new Product(2, "Floor Panel", 25);
        Product window = new Product(3, "Glass Window", 10);

        List<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        products.add(floorPanel);
        products.add(window);

        namesOfLightProductsWeightSortedStreams(products);

        // namesOfLightProductsWeightSortedLoop(products);
    }

    private static void namesOfLightProductsWeightSortedStreams(List<Product> products) {

        products
        .stream()
        .filter(product -> product.getWeight() < 30)
        .sorted(comparingInt(Product::getWeight))
        .map(Product::getName)
        .forEach(System.out::println);

        // Sort objects with a specified comparator
        Comparator<Product> byName = Comparator.comparing(Product::getName);
        products.sort(byName);


    }

    private static void namesOfLightProductsWeightSortedLoop(
        List<Product> products)
    {
        List<Product> lightProducts = new ArrayList<>();

        for (Product product : products)
        {
            if (product.getWeight() < 30)
            {
                lightProducts.add(product);
            }
        }

        lightProducts.sort(comparingInt(Product::getWeight));

        for (Product product : lightProducts)
        {
            System.out.println(product.getName());
        }
    }

    private static void filterProducts(Stream<Product> products, Integer value) {

        // Discard next N elements
        //products.skip(elementsOnPage * pageNumber)

        // Only keep next N elements
        //products.limit(elementsOnPage)


        // max (or min) element fiven a sort order 
        products.max(Comparator.comparingInt(Product::getWeight));


        // Side effecting action for each element
        products.forEach(prod -> System.out.println(prod.getName()));

        // findFirst (or findAny()) get the element
        products.filter(prod -> prod.getName().contains("Chair")).findFirst();

        products.filter(product -> (product.getWeight() > value));
        System.out.println(products);

        // Count number of elements in a stream 
        products.filter(prod -> prod.getName().contains("Chair")).count();

        }

    private void ProductFamilies(List<Product> products, Integer value) {

        //Match the family, returns bolean, terminal operation, if any / none / all elements match a Predicate 
        
        // products.anyMatch(prod -> prod.getWeight() > value);
        // System.out.println(products);

        
        // products.allMatch(prod -> prod.getWeight() > 20);
        // System.out.println(products);


        // products.noneMatch(prod -> prod.getWeight() > value);
        // System.out.println(products);


    }





    
    private static void transformProducts(Stream<Product> products, Stream<Shipment> shipment, Integer removeValue) {

        products.map(Product::getName);


        shipment.flatMap(shipments -> shipments.getLightVanProducts().stream());

        //products.reduce(0, (acc, product) -> acc + product.getWeight());

    }




}
