package com.adshopping.core;

import java.util.Map;

import com.adshopping.model.Product;

public interface IInventoryHelper {

	Map<Long, Product> loadInventory();
	
}
