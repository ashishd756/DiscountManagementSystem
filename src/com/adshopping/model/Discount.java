package com.adshopping.model;

import java.math.BigDecimal;
import java.util.Date;

public class Discount extends AbstractBaseModel {

	private DiscountType type;
	private BigDecimal amount;
	private AmountType amountType;
	private boolean isDateBasedDiscount;
	private Date startDate = null;
	private Date endDate = null;
	
	
	public DiscountType getType() {
		return type;
	}
	public void setType(DiscountType type) {
		this.type = type;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public AmountType getAmountType() {
		return amountType;
	}
	public void setAmountType(AmountType amountType) {
		this.amountType = amountType;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isDateBasedDiscount() {
		return isDateBasedDiscount;
	}
	public void setDateBasedDiscount(boolean isDateBasedDiscount) {
		this.isDateBasedDiscount = isDateBasedDiscount;
	}
	
	
}
