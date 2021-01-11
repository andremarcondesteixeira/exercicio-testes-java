package br.com.andre.exercicio4.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShoppingCart {
    private Map<Product, Integer> products = new HashMap<>();

    public void add(Product product) {
        add(1, product);
    }

    public void add(int amount, Product product) {
        Product copy = new Product(product.getName(), product.getValue());
        products.put(copy, amountOf(product) + amount);
    }

    public void removeOne(Product product) {
        int amount = amountOf(product);
        if (amount > 1)
            products.put(product, amount - 1);
        else
            removeAll(product);
    }

    public void removeAll(Product product) {
        products.remove(product);
    }

    public void changeAmount(int amount, Product product) {
        products.put(product, amount);
    }

    public int amountOf(Product product) {
        return Optional.ofNullable(products.get(product)).orElse(0);
    }

    public int totalAmountOfProducts() {
        return products.values().stream().reduce((previous, sum) -> {
            return previous + sum;
        }).orElse(0);
    }

    public void clear() {
        products.clear();
    }
}