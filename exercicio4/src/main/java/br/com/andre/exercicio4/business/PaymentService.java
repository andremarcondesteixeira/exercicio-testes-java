package br.com.andre.exercicio4.business;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PaymentService {
    private FreightService freightService;

	public Money purchasePrice(ShoppingCart shoppingCart) {
        ZipCode zipCode = shoppingCart.getUserZipCode();
        Money freightPrice = freightService.calculateFreightPrice(zipCode);
		return shoppingCart.totalProductsPrice().add(freightPrice);
	}
}