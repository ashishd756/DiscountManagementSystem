package com.adshopping.core;

import java.util.Comparator;

import com.adshopping.model.Discount;

public class DiscountDescComparator implements Comparator<Discount>{

	@Override
	public int compare(Discount d1, Discount d2) {
		// TODO Auto-generated method stub
		if(d1.getAmount().compareTo(d2.getAmount())>0)
		{
			return -1;
		} else if(d1.getAmount().compareTo(d2.getAmount())==0){
			return 0;
		} else {
			return 1;
		}
		
	}

}
