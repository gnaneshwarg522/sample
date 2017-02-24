package com.yelp;

import org.openqa.selenium.By;

public class YelpLocators {

	/// this is a sample change 
	//another commits
			public static By FindRestaurants = By.id("find_desc");
			public static By SearchIcon = By.id("header-search-submit"); 
			public static By FindResults = By.xpath("//div[@data-component-bound='true']/span");
			public static By AddFiltersbtn = By.xpath("//span[contains(text(),'All Filters')]");
			public static By PriceFilter$ = By.xpath("//input[@value='RestaurantsPriceRange2.1')");
			public static By Features = By.xpath("//input[@value='PlatformDelivery')");
			public static By FirstResult = By.xpath("//div[@class='search-results-content']/ul[2]/li//a/span");
			public static By Address = By.xpath("//Strong[@class='street-address']/address");
			public static By PhoneNumber = By.xpath("//span[@class='biz-phone']");
			public static By CustomerReview1 = By.xpath("//ul[@class='review-highlights-list']/li/div[2]/p");
			public static By CustomerReview2 = By.xpath("//ul[@class='review-highlights-list']/li[2]/div[2]/p");
			public static By CustomerReview3 = By.xpath("//ul[@class='review-highlights-list']/li[3]/div[2]/p");
			
}
 