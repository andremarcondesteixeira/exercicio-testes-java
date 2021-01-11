package br.com.andre.exercicio4.business;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentService {
    private FreightService freightService;

    public Money purchasePrice(ShoppingCart shoppingCart) {
        Money total = shoppingCart.totalProductsPrice();
        if (!freightIsFree(total))
            total = total.add(getFreightPrice(shoppingCart));
        return total;
    }

    private boolean freightIsFree(Money productsPrice) {
        return productsPrice.getValue() > 100;
    }

    private Money getFreightPrice(ShoppingCart shoppingCart) {
        ZipCode zipCode = shoppingCart.getUserZipCode();
        return freightService.calculateFreightPrice(zipCode);
    }
}