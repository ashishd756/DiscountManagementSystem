package com.adshopping.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class AbstractBaseModel implements IBaseModel {

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
