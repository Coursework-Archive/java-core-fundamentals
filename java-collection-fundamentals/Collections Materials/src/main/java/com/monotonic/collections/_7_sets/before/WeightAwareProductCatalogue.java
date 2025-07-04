package com.monotonic.collections._7_sets.before;

import com.monotonic.collections.common.Product;
import com.monotonic.collections.common.Supplier;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class WeightAwareProductCatalogue implements Iterable<Product>
{
    private final NavigableSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);

    public void addSupplier(final Supplier supplier)
    {
        products.addAll(supplier.getProducts());
    }

    @Override
    public Iterator<Product> iterator()
    {
        return products.iterator();
    }

    public Set<Product> findLighterProducts(final Product product)
    {
        return products.headSet(product, false);
    }
}
