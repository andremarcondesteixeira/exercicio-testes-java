package br.com.andre.exercicio4.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCart_Tests {
    private ShoppingCart shoppingCart;
    private Product product1;
    private Product product2;

    @BeforeEach void setUp() {
        shoppingCart = new ShoppingCart();
        product1 = new Product("Capivara Robô Zumbi Gigante", new Money(1.99));
        product2 = new Product("Monstro Alienígena Mutante", new Money(10));
    }

    @Test void Add_Products() {
        shoppingCart.add(product1);
        shoppingCart.add(2, product1);
        shoppingCart.add(11, product1);
        shoppingCart.add(product2);
        shoppingCart.add(3, product2);

        assertEquals(18, shoppingCart.totalAmountOfProducts()); // Law of Demeter
        assertEquals(14, shoppingCart.amountOf(product1));
        assertEquals(4, shoppingCart.amountOf(product2));
    }

    @Test void Remove_Products() {
        shoppingCart.add(3, product1);
        shoppingCart.add(5, product2);
        assertEquals(3, shoppingCart.amountOf(product1));
        assertEquals(5, shoppingCart.amountOf(product2));
        assertEquals(8, shoppingCart.totalAmountOfProducts());

        shoppingCart.removeOne(product1);
        shoppingCart.removeOne(product2);
        assertEquals(2, shoppingCart.amountOf(product1));
        assertEquals(4, shoppingCart.amountOf(product2));
        assertEquals(6, shoppingCart.totalAmountOfProducts());

        shoppingCart.removeAll(product1);
        shoppingCart.removeAll(product2);
        assertEquals(0, shoppingCart.amountOf(product1));
        assertEquals(0, shoppingCart.amountOf(product2));
        assertEquals(0, shoppingCart.totalAmountOfProducts());
    }

    @Test void Change_Amount_Of_Product() {
        shoppingCart.add(10, product1);
        shoppingCart.add(20, product2);
        assertEquals(10, shoppingCart.amountOf(product1));
        assertEquals(20, shoppingCart.amountOf(product2));
        assertEquals(30, shoppingCart.totalAmountOfProducts());

        shoppingCart.changeAmount(2, product1);
        shoppingCart.changeAmount(5, product2);
        assertEquals(2, shoppingCart.amountOf(product1));
        assertEquals(5, shoppingCart.amountOf(product2));
        assertEquals(7, shoppingCart.totalAmountOfProducts());

        shoppingCart.changeAmount(9, product1);
        shoppingCart.changeAmount(7, product2);
        assertEquals(9, shoppingCart.amountOf(product1));
        assertEquals(7, shoppingCart.amountOf(product2));
        assertEquals(16, shoppingCart.totalAmountOfProducts());
    }

    @Test void changeAmount_Can_Add_Product() {
        shoppingCart.changeAmount(2, product1);
        shoppingCart.changeAmount(5, product2);
        assertEquals(2, shoppingCart.amountOf(product1));
        assertEquals(5, shoppingCart.amountOf(product2));
        assertEquals(7, shoppingCart.totalAmountOfProducts());
    }

    @Test void Clear_Shopping_Cart() {
        shoppingCart.add(2, product1);
        shoppingCart.add(2, product2);
        assertEquals(2, shoppingCart.amountOf(product1));
        assertEquals(2, shoppingCart.amountOf(product2));
        assertEquals(4, shoppingCart.totalAmountOfProducts());

        shoppingCart.clear();
        assertEquals(0, shoppingCart.totalAmountOfProducts());
    }

    @Test void Purchase_Price() {

    }
}