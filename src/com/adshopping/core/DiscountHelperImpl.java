package com.adshopping.core;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.adshopping.model.Category;
import com.adshopping.model.CategoryType;
import com.adshopping.model.Discount;
import com.adshopping.model.ShoppingCart;
import com.adshopping.model.ShoppingCartItem;
import com.adshopping.util.ShoppingUtils;

public class DiscountHelperImpl implements IDiscountHelper {

	private Map<String, Discount> brandDiscounts;
	private Map<CategoryType, Discount> categoryDiscounts;

	public DiscountHelperImpl() {
		this.brandDiscounts = ShoppingUtils.loadBrandDiscount();
		this.categoryDiscounts = ShoppingUtils.loadCategoryDiscount();
	}

	@Override
	public ShoppingCart doSubmit(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		if (shoppingCart == null || shoppingCart.getShoppingCartItems() == null) {
			return shoppingCart;
		}
		return applyDiscount(shoppingCart);
	}

	private ShoppingCart applyDiscount(ShoppingCart shoppingCart) {

		List<ShoppingCartItem> items = shoppingCart.getShoppingCartItems();
		BigDecimal totalDiscountedAmount = BigDecimal.ZERO;
		for (ShoppingCartItem item : items) {
			Discount discount = getApplicableDiscount(item);
			if (discount != null) {
				item.setDiscountApplied(true);
				BigDecimal discountInAmt = discount.getAmount()
						.divide(BigDecimal.valueOf(100))
						.multiply(item.getProductPrice())
						.setScale(2, RoundingMode.HALF_DOWN);
				item.setDiscountAmount(discountInAmt);

				BigDecimal discountedTotalAmount = item.getProductPrice()
						.subtract(discountInAmt);
				item.setDicountedProductPrice(discountedTotalAmount);
				item.setDiscountApplied(true);
				item.setDiscountPercentage(discount.getAmount());
				totalDiscountedAmount = totalDiscountedAmount.add(discountedTotalAmount);
			}
		}
		shoppingCart.setTotalDiscountedProductPrice(totalDiscountedAmount);

		return shoppingCart;
	}

	private Discount getApplicableDiscount(ShoppingCartItem item) {
		String brandName = item.getBrandName();
		Category brandCategory = item.getProductCategory();

		Discount brandDiscount = null;
		Discount categoryDiscount = null;
		Discount parentCategoryDiscount = null;
		Discount finalApplicableDiscount = null;
		if (brandDiscounts.containsKey(brandName.toUpperCase())) {
			brandDiscount = brandDiscounts.get(brandName.toUpperCase());
		}

		if (categoryDiscounts.containsKey(item.getProductCategory().getName())) {
			categoryDiscount = categoryDiscounts.get(item.getProductCategory()
					.getName());
		}

		DiscountDescComparator discountComparator = new DiscountDescComparator();
		List<Discount> parentDiscountList = new ArrayList<Discount>();
		for (Category parentCategory : brandCategory.getParentCategories()) {
			if (categoryDiscounts.containsKey(parentCategory.getName())) {
				parentDiscountList.add(categoryDiscounts.get(parentCategory
						.getName()));
			}

		}
		if (parentDiscountList.size() > 0) {
			Collections.sort(parentDiscountList, discountComparator);
			parentCategoryDiscount = parentDiscountList.get(0);
		}

		List<Discount> finalDiscountList = new ArrayList<Discount>();
		if (brandDiscount != null) {
			finalDiscountList.add(brandDiscount);
		}

		if (categoryDiscount != null) {
			finalDiscountList.add(categoryDiscount);
		}

		if (parentCategoryDiscount != null) {
			finalDiscountList.add(parentCategoryDiscount);
		}
		if (finalDiscountList.size() > 0) {
			Collections.sort(finalDiscountList, discountComparator);
			finalApplicableDiscount = finalDiscountList.get(0);
		}
		return finalApplicableDiscount;
	}

}
