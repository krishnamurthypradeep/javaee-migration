package javamodularity.productsearch.cli;

import javamodularity.productsearch.analysis.internal.SearchProduct;

public class Main {
    public static void main(String[] args) {
        SearchProduct.searchByName("Iphone15")
                .forEach(product -> System.out.println(product));
    }
}
