package br.com.andre.exercicio4.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PaymentService_Tests {
    private @Mock ShoppingCart shoppingCart;
    private @Mock FreightService freightService;
    private @Captor ArgumentCaptor<ZipCode> zipCodeCaptor;
    private PaymentService paymentService;

    public @BeforeEach void setUp() {
        MockitoAnnotations.openMocks(this);
        when(freightService.calculateFreightPrice(zipCodeCaptor.capture())).thenReturn(new Money(25));
        paymentService = new PaymentService(freightService);
    }

    public @Test void Purchase_Without_Freight_Cost() {
        when(shoppingCart.totalProductsPrice()).thenReturn(new Money(500));
        var expected = new Money(500);
        var actual = paymentService.purchasePrice(shoppingCart);
        assertEquals(expected, actual);
        verify(shoppingCart).totalProductsPrice();
    }

    public @Test void Purchase_With_Freight_Cost() {
        when(shoppingCart.totalProductsPrice()).thenReturn(new Money(50));
        var expected = new Money(75);
        var actual = paymentService.purchasePrice(shoppingCart);
        assertEquals(expected, actual);
        verify(shoppingCart).totalProductsPrice();
        verify(freightService).calculateFreightPrice(zipCodeCaptor.capture());
    }
}