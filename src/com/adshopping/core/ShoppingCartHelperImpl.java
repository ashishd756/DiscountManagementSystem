package com.adshopping.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.adshopping.model.Product;
import com.adshopping.model.ShoppingCart;
import com.adshopping.model.ShoppingCartItem;

public class ShoppingCartHelperImpl implements IShoppingCartHelper {

	@Override
	public ShoppingCart doSubmit(String[] shoppingCartProductIdArr,
			Map<Long, Product> inventories) {
		if (shoppingCartProductIdArr == null) {
			return null;
		}
		ShoppingCart shoppingCart = new ShoppingCart();
		int i = 0;
		List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();
		BigDecimal totalOriginalPrice = BigDecimal.ZERO;
		while (i < shoppingCartProductIdArr.length) {
			Long productId = Long.valueOf(shoppingCartProductIdArr[i]);
			Product p = inventories.get(productId);
			ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
			shoppingCartItem.setProductId(productId);
			if (p == null) {
				shoppingCartItem.setAvailable(false);
			} else {
				shoppingCartItem.setAvailable(true);
				shoppingCartItem.setProductCategory(p.getCategory());
				shoppingCartItem.setBrandName(p.getBrand().getName());
				shoppingCartItem.setProductPrice(p.getPrice().getAmount());
				totalOriginalPrice = totalOriginalPrice.add(p.getPrice()
						.getAmount());
			}
			shoppingCartItems.add(shoppingCartItem);
			i++;
		}
		shoppingCart.setShoppingCartItems(shoppingCartItems);
		shoppingCart.setTotalDiscountedProductPrice(totalOriginalPrice);
		shoppingCart.setTotalOriginalProductPrice(totalOriginalPrice);
		return shoppingCart;
	}

}
