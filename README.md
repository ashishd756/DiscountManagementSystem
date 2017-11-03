# DiscountManagementSystem

This is a very basic Shopping Cart system with emphasis on the Discounting flow.

## Assumptions

#### It is assumed that there is some existing system which is there to load Inventory from csv and Product Categories. 
##### Currently I have hard coded the product categories and its parent categories in the code. Code is provided in ShoppingUtils.java. This ShoppingUtils.java class represents the existing system.

#### Brand and Category discounts are loaded from properties file provided in the resources folder in the project. 
##### For example: BrandDiscountPercentage.properties and CategoryDiscountPercentage.properties

#### All the model objects are in com.adshopping.model package

#### All the core business logic is in com.adshopping.core package

##### InventoryHelperImpl.java class is for loading the Inventory
##### ShoppingCartHelperImpl.java class is for adding the entered product id in Shopping Cart 
##### DiscountHelperImpl.java class which has the core Discounting logic

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

What things you need to install

```
Java 1.6 or higher

Eclipse IDE is used for creating this project(It is not mandatory)

```


## How to run the application

### Run com.adshopping.application.MainShoppingApplication.java

### You will be promted to enter the absolute path of the CSV file which contains the inventory data. Sample CSV file data given below: 


### Sample CSV Content. (Included in resources folder of thhe project)
Id,Brand,Category,Price
1, Arrow,Shirts,800
2, Vero Moda,Dresses,1400
3, Provogue,Footwear,1800
4, Wrangler,Jeans,2200
5, UCB,Shirts,1500

### You will be promted enter the comma separated the product id which you want to add in shopping cart. For example enter: 1,2,3,4

### Output will be the total original billable amount and total discounted billable amount





## Area of improvement

### Test Cases: No test available now because of time constraint.

### Logging: No logging used currently

### Exception: Custom exception handling needs to be added.

