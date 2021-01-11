package br.com.andre.exercicio4.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PaymentService_Tests {
    private @Mock FreightService freightService;
    private @Captor ArgumentCaptor<ZipCode> captor;

    public @BeforeEach void setUp() {
        MockitoAnnotations.openMocks(this);
        when(freightService.calculateFreightPrice(captor.capture())).thenReturn(new Money(25));
    }

    public @Test void Purchase_Price() {
        var product = new Product("Monstro Marinho Assassino", new Money(399.9));
        var shoppingCart = new ShoppingCart(new User("André", new ZipCode("82.900-070")));
        shoppingCart.add(10, product);
        var service = new PaymentService(freightService);
        assertEquals(new Money(399.9 * 2 + 25), service.purchasePrice(shoppingCart));
    }
}