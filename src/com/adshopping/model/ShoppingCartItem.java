package com.adshopping.model;

import java.math.BigDecimal;

public class ShoppingCartItem extends AbstractBaseModel {

	private Long productId;
	private String brandName;
	private Category productCategory;
	private BigDecimal productPrice;
	private BigDecimal dicountedProductPrice;
	private BigDecimal discountPercentage;
	private BigDecimal discountAmount;
	private boolean isDiscountApplied;
	private boolean isAvailable;
	private CurrencyCode currencyCode = CurrencyCode.INR;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getDicountedProductPrice() {
		return dicountedProductPrice;
	}

	public void setDicountedProductPrice(BigDecimal dicountedProductPrice) {
		this.dicountedProductPrice = dicountedProductPrice;
	}

	public BigDecimal getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(BigDecimal discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public boolean isDiscountApplied() {
		return isDiscountApplied;
	}

	public void setDiscountApplied(boolean isDiscountApplied) {
		this.isDiscountApplied = isDiscountApplied;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public CurrencyCode getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(CurrencyCode currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	
}
