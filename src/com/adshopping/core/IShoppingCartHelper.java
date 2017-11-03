package com.adshopping.core;

import java.util.Map;

import com.adshopping.model.Product;
import com.adshopping.model.ShoppingCart;

public interface IShoppingCartHelper {

	ShoppingCart doSubmit(String[] shoppingCartProductIdArr, Map<Long, Product> inventories);
	
}
