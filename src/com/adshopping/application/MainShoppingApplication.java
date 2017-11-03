package com.adshopping.application;

import java.util.Map;

import com.adshopping.core.DiscountHelperImpl;
import com.adshopping.core.IDiscountHelper;
import com.adshopping.core.IInventoryHelper;
import com.adshopping.core.IShoppingCartHelper;
import com.adshopping.core.InventoryHelperImpl;
import com.adshopping.core.ShoppingCartHelperImpl;
import com.adshopping.model.Product;
import com.adshopping.model.ShoppingCart;
import com.adshopping.util.ShoppingUtils;

public class MainShoppingApplication {

	private IShoppingCartHelper shoppingCartHelper;
	private IDiscountHelper discountHelper;
	private IInventoryHelper inventoryHelper;

	public MainShoppingApplication() {
		shoppingCartHelper = new ShoppingCartHelperImpl();
		discountHelper = new DiscountHelperImpl();
		inventoryHelper = new InventoryHelperImpl();

	}

	public static void main(String[] args) {
		MainShoppingApplication myApp = new MainShoppingApplication();

		Map<Long, Product> inventories = myApp.getInventoryHelper()
				.loadInventory();

		String[] productIdsToBeAddedInCart = ShoppingUtils
				.getProductIdsToBeAddedToCartFromConsole();

		ShoppingCart shoppingCart = myApp.getShoppingCartHelper().doSubmit(
				productIdsToBeAddedInCart, inventories);

		shoppingCart = myApp.getDiscountHelper().doSubmit(shoppingCart);

		System.out.println("Total Original Billable Amount in Rs."
				+ shoppingCart.getTotalOriginalProductPrice());
		System.out.println("Total Discounted Billable Amount in Rs."
				+ shoppingCart.getTotalDiscountedProductPrice());
	}

	public IShoppingCartHelper getShoppingCartHelper() {
		return shoppingCartHelper;
	}

	public void setShoppingCartHelper(IShoppingCartHelper shoppingCartHelper) {
		this.shoppingCartHelper = shoppingCartHelper;
	}

	public IDiscountHelper getDiscountHelper() {
		return discountHelper;
	}

	public void setDiscountHelper(IDiscountHelper discountHelper) {
		this.discountHelper = discountHelper;
	}

	public IInventoryHelper getInventoryHelper() {
		return inventoryHelper;
	}

	public void setInventoryHelper(IInventoryHelper inventoryHelper) {
		this.inventoryHelper = inventoryHelper;
	}

}
