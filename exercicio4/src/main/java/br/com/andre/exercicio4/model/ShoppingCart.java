package br.com.andre.exercicio4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShoppingCart {
    private final User user;
    private List<Product> products = new ArrayList<Product>();

    public void add(Product product) {
        var copy = new Product(product.getName(), product.getValue());
        products.add(copy);
    }

    public void add(int amount, Product product) {
        for (var i = 0; i < amount; i++)
            add(product);
    }

    public void removeOne(Product product) {
        int index = products.indexOf(product);
        if (index >= 0)
            products.remove(index);
    }

    public void removeAll(Product product) {
        findAll(product).forEach(p -> {
            products.remove(p);
        });
    }

    private List<Product> findAll(Product product) {
        return products.stream().filter(p -> {
            return p.hashCode() == product.hashCode();
        }).collect(Collectors.toList());
    }

    public int amountOf(Product product) {
        return findAll(product).size();
    }

    public int totalAmountOfProducts() {
        return products.size();
    }

    public String productNameAt(int index) {
        return products.get(index).getName();
    }

    public Money productValueAt(int index) {
        return products.get(index).getValue();
    }

    public void clear() {
        products.clear();
    }
}