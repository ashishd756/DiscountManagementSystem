package com.adshopping.model;

import java.util.List;

public class Category extends AbstractBaseModel {
	private CategoryType name;
	List<Category> parentCategories;

	public CategoryType getName() {
		return name;
	}

	public void setName(CategoryType name) {
		this.name = name;
	}

	public List<Category> getParentCategories() {
		return parentCategories;
	}

	public void setParentCategories(List<Category> parentCategories) {
		this.parentCategories = parentCategories;
	}

}
