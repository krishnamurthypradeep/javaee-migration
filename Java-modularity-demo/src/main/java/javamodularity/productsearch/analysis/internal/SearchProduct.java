package javamodularity.productsearch.analysis.internal;

import javamodularity.productsearch.analysis.Product;

import java.util.List;
import java.util.stream.Collectors;

public class SearchProduct {

    private static List<Product> products =
            List.of(new Product(1,"IPhone15",865456.5),
                    new Product(4,"Oneplus11R",565456.5),
                    new Product(2,"Pixel",665456.5));
public static List<Product> searchByName(String productName){
return products.stream().filter(product -> product.productName().equalsIgnoreCase(productName))
        .collect(Collectors.toList());
}

}
