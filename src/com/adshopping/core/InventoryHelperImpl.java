package com.adshopping.core;

import java.util.Map;

import com.adshopping.model.Category;
import com.adshopping.model.CategoryType;
import com.adshopping.model.Product;
import com.adshopping.util.ShoppingUtils;

public class InventoryHelperImpl implements IInventoryHelper {

	@Override
	public Map<Long, Product> loadInventory() {
		Map<CategoryType, Category> categories = ShoppingUtils
				.loadProductCategory();
		
		Map<Long, Product> inventories = null;
		try {
			inventories = ShoppingUtils
					.loadInventoryFromConsole(categories);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return inventories;
	}

}
