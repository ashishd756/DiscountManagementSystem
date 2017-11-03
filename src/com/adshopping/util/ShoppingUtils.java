package com.adshopping.util;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import au.com.bytecode.opencsv.CSVReader;

import com.adshopping.model.AmountType;
import com.adshopping.model.Category;
import com.adshopping.model.CategoryType;
import com.adshopping.model.Discount;
import com.adshopping.model.DiscountType;
import com.adshopping.model.Manufacturer;
import com.adshopping.model.Product;
import com.adshopping.model.ProductPrice;

public class ShoppingUtils {
	private static Scanner scanner = new Scanner(System.in);
	
	public static Map<CategoryType, Category> loadProductCategory() {
		Map<CategoryType, Category> categories = new EnumMap<CategoryType, Category>(
				CategoryType.class);
		// Home Category
		Category home = new Category();
		home.setName(CategoryType.HOME);
		home.setParentCategories(null);
		categories.put(home.getName(), home);

		// Mens Wear Category
		Category mensWear = new Category();
		mensWear.setName(CategoryType.MENSWEAR);
		List<Category> mensWearParents = new ArrayList<Category>();
		mensWearParents.add(home);
		mensWear.setParentCategories(mensWearParents);
		categories.put(mensWear.getName(), mensWear);

		// Shirts Category
		Category shirtsCat = new Category();
		shirtsCat.setName(CategoryType.SHIRTS);
		List<Category> shirtsParents = new ArrayList<Category>();
		shirtsParents.add(home);
		shirtsParents.add(mensWear);
		shirtsCat.setParentCategories(shirtsParents);
		categories.put(shirtsCat.getName(), shirtsCat);

		// Trousers Category
		Category trousersCat = new Category();
		trousersCat.setName(CategoryType.TROUSERS);
		List<Category> trousersParents = new ArrayList<Category>();
		trousersParents.add(home);
		trousersParents.add(mensWear);
		trousersCat.setParentCategories(trousersParents);
		categories.put(trousersCat.getName(), trousersCat);

		// Casuals Category
		Category casualsCat = new Category();
		casualsCat.setName(CategoryType.CASUALS);
		List<Category> casualsParents = new ArrayList<Category>();
		casualsParents.add(home);
		casualsParents.add(mensWear);
		casualsParents.add(trousersCat);
		casualsCat.setParentCategories(casualsParents);
		categories.put(casualsCat.getName(), casualsCat);

		// Jeans Category
		Category jeansCat = new Category();
		jeansCat.setName(CategoryType.JEANS);
		List<Category> jeansParents = new ArrayList<Category>();
		jeansParents.add(home);
		jeansParents.add(mensWear);
		jeansCat.setParentCategories(jeansParents);
		categories.put(jeansCat.getName(), jeansCat);

		// Womens Wear Category
		Category womensWear = new Category();
		womensWear.setName(CategoryType.WOMENSWEAR);
		List<Category> womensWearParents = new ArrayList<Category>();
		womensWearParents.add(home);
		womensWear.setParentCategories(womensWearParents);
		categories.put(womensWear.getName(), womensWear);

		// Dresses Category
		Category dressesCat = new Category();
		dressesCat.setName(CategoryType.DRESSES);
		List<Category> dressesParents = new ArrayList<Category>();
		dressesParents.add(home);
		dressesParents.add(womensWear);
		dressesCat.setParentCategories(dressesParents);
		categories.put(dressesCat.getName(), dressesCat);

		// Footwear Category
		Category footwearCat = new Category();
		footwearCat.setName(CategoryType.FOOTWEAR);
		List<Category> footwearParents = new ArrayList<Category>();
		footwearParents.add(home);
		footwearParents.add(womensWear);
		footwearCat.setParentCategories(footwearParents);
		categories.put(footwearCat.getName(), footwearCat);

		return categories;
	}

	public static Map<Long, Product> loadInventoryFromConsole(
			Map<CategoryType, Category> categories) throws Exception {
		Map<Long, Product> inventory = new HashMap<Long, Product>();
		
		boolean isInvenotryLoaded = false;
		System.out.print("Enter Inventory csv's absolute path. Press q to exit. \n");
		while (!isInvenotryLoaded) {

			
			if (!isInvenotryLoaded) {
				String csvPath = scanner.nextLine();
				if ("q".equals(csvPath)) {
					System.out.println("Exit!");
					break;
				}
				CSVReader csvReader = new CSVReader(new FileReader(csvPath), ',');
				 List<String[]> items;
				    try {
				        items = csvReader.readAll();
				        System.out.println("Inventory Added");
				        System.out.println(Arrays.toString(items.get(0)));
				        for (int i = 1; i < items.size(); i++) {
				        	System.out.println(Arrays.toString(items.get(i)));
				        	ShoppingUtils.addInventory(items.get(i), inventory, categories);
				        }
				        isInvenotryLoaded = true;
				        break;
				    } finally {
				        csvReader.close();
				        
				    }
				
			
			}
		}
		return inventory;
	}

	public static void addInventory(String[] inventoryArr,
			Map<Long, Product> inventory, Map<CategoryType, Category> categories) {

		if (inventoryArr != null && inventoryArr.length > 0) {
			Long productId = Long.valueOf(inventoryArr[0]);

			if (inventory.containsKey(productId)) {
				Product p = inventory.get(productId);
				p.setAvailableQuantity(p.getAvailableQuantity() + 1);
			} else {

				Product p = new Product();
				p.setId(productId);
				Manufacturer brand = new Manufacturer();
				brand.setName(inventoryArr[1].trim().toUpperCase());
				p.setBrand(brand);
				CategoryType catType = CategoryType.valueOf(inventoryArr[2]
						.trim().toUpperCase());
				Category category = categories.get(catType);
				p.setCategory(category);
				p.setAvailableQuantity(1);
				BigDecimal price = BigDecimal.valueOf(Double
						.valueOf(inventoryArr[3].trim()));
				ProductPrice productPrice = new ProductPrice();
				productPrice.setAmount(price);
				p.setPrice(productPrice);
				inventory.put(productId, p);
			}

		}
	}

	public static Map<String, Discount> loadBrandDiscount() {
		Properties prop = new Properties();
		InputStream input = null;
		Map<String, Discount> brandDiscountMap = new HashMap<String, Discount>();
		try {

			// System.out.println(System.getProperty("user.dir"));

			input = new FileInputStream(
					"resources/BrandDiscountPercentage.properties");
			prop.load(input);
			Enumeration e = prop.propertyNames();

			while (e.hasMoreElements()) {
				String brandName = ((String) e.nextElement()).toUpperCase();
				BigDecimal discountPercent = BigDecimal.valueOf(Double
						.valueOf(prop.getProperty(brandName)));
				Discount brandDiscount = new Discount();
				brandDiscount.setAmount(discountPercent);
				brandDiscount.setAmountType(AmountType.PERCENTAGE);
				brandDiscount.setType(DiscountType.BRAND);
				brandDiscountMap.put(brandName.replaceAll("-", " "),
						brandDiscount);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return brandDiscountMap;
	}

	public static Map<CategoryType, Discount> loadCategoryDiscount() {
		Properties prop = new Properties();
		InputStream input = null;
		Map<CategoryType, Discount> catDiscountMap = new EnumMap<CategoryType, Discount>(
				CategoryType.class);
		try {

			input = new FileInputStream(
					"resources/CategoryDiscountPercentage.properties");
			prop.load(input);
			Enumeration e = prop.propertyNames();

			while (e.hasMoreElements()) {
				String catTypeName = (String) e.nextElement();
				BigDecimal discountPercent = BigDecimal.valueOf(Double
						.valueOf(prop.getProperty(catTypeName)));
				Discount categoryDiscount = new Discount();
				categoryDiscount.setAmount(discountPercent);
				categoryDiscount.setAmountType(AmountType.PERCENTAGE);
				categoryDiscount.setType(DiscountType.CATEGORY);
				CategoryType catType = CategoryType.valueOf(catTypeName
						.toUpperCase());
				catDiscountMap.put(catType, categoryDiscount);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return catDiscountMap;
	}

	public static String[] getProductIdsToBeAddedToCartFromConsole() {
		
		System.out
				.println("Enter commma separated Product Ids to be added in the shopping cart. Press q to exit.");
		boolean isProductIdChosenForCart = false;
		String[] productIdArr = null;
		String input = null;
		while (!isProductIdChosenForCart) {

			input = scanner.nextLine();

			if ("q".equals(input)) {
				System.out.println("Exit!");
				break;
			}
			if(StringUtils.isNotBlank(input)){
				isProductIdChosenForCart = true;
				productIdArr = input.split(",");		
			}
		}
		scanner.close();
		return productIdArr;
	}
}
