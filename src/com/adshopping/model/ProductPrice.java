package com.adshopping.model;

import java.math.BigDecimal;

public class ProductPrice extends AbstractBaseModel {

	private BigDecimal amount = null;
	private CurrencyCode curencyCode = CurrencyCode.INR;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CurrencyCode getCurencyCode() {
		return curencyCode;
	}

	public void setCurencyCode(CurrencyCode curencyCode) {
		this.curencyCode = curencyCode;
	}

}
