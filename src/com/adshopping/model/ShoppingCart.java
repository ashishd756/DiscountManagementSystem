package com.adshopping.model;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart extends AbstractBaseModel {
	private List<ShoppingCartItem> shoppingCartItems;
	private BigDecimal totalOriginalProductPrice;
	private BigDecimal totalDiscountedProductPrice;

	public List<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	public BigDecimal getTotalOriginalProductPrice() {
		return totalOriginalProductPrice;
	}

	public void setTotalOriginalProductPrice(
			BigDecimal totalOriginalProductPrice) {
		this.totalOriginalProductPrice = totalOriginalProductPrice;
	}

	public BigDecimal getTotalDiscountedProductPrice() {
		return totalDiscountedProductPrice;
	}

	public void setTotalDiscountedProductPrice(
			BigDecimal totalDiscountedProductPrice) {
		this.totalDiscountedProductPrice = totalDiscountedProductPrice;
	}

}
