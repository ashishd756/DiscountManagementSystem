package com.adshopping.model;

import java.math.BigDecimal;

public class FinalPrice extends AbstractBaseModel {
	private BigDecimal discountedPrice = null;
	private BigDecimal originalPrice = null;
	private BigDecimal discountAmount = null;
	private Discount appliedDiscountType = null;

	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Discount getAppliedDiscountType() {
		return appliedDiscountType;
	}

	public void setAppliedDiscountType(Discount appliedDiscountType) {
		this.appliedDiscountType = appliedDiscountType;
	}

}
