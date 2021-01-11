package br.com.andre.exercicio4.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PaymentService_Tests {
    private @Mock FreightService freightService;

    public @BeforeEach void setUp() {

    }

    public @Test void Purchase_Price() {
        var product = new Product("Monstro Marinho Assassino", new Money(399.9));
        var shoppingCart = new ShoppingCart();
        shoppingCart.add(10, product);
        var service = new PaymentService(freightService);
        assertEquals(819.8, service.purchasePrice(shoppingCart).getValue());
    }
}