package com.yelp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RestaurantsSearchScenario {
	
	public static WebDriver driver;
	public static boolean bStatus = false;
	public static String sBrowserName = "firefox";
	public static String sURL = "https://www.yelp.com/sf";
	public static String sSearchText = "Restaurants";
	public static String sAppendedTxt = "Restaurants Pizza";
	public static String sCurrentPageResult;
	public static String sTotalResults;
	
	public static void main(String[] args){
		
		// Launch browser
		bStatus = LaunchBrowser(sBrowserName);
		if(!bStatus){
			System.out.println("Unable to launched the Browser:- "+sBrowserName);
			System.exit(0);
		}
		
		System.out.println("Successfully Launched the Browser:- "+sBrowserName);
		
		//Navigate to URL:- 
		bStatus = NavigateToURL(sURL);
		if(!bStatus){
			System.out.println("Unable to navigate to URL:- "+sURL);
			System.exit(0);
		}		
		System.out.println("Successfully navigated to URL:- "+sURL);
				
		//Type Restaurants in the search box and click on Search button.
		bStatus = SearchReastaruats(sSearchText);
		if(!bStatus){
			System.out.println("Unable to Search:- "+sSearchText);
			System.exit(0);
		}
		System.out.println("Successfully Searched:- "+sSearchText);
		
		//Click on Search Icon
		driver.findElement(YelpLocators.SearchIcon).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Append the Pizza text 		
		bStatus = SearchReastaruats(sAppendedTxt);
		if(!bStatus){
			System.out.println("Unable to Search:- "+sAppendedTxt);
			System.exit(0);
		}
		System.out.println("Successfully Searched:- "+sAppendedTxt);
		
		//Click on Search Icon
		driver.findElement(YelpLocators.SearchIcon).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Getting Search Result
		GetSearchResult();
		
		//Getting the Current Page Search Result;
		System.out.println("Current Page Search Result:- "+ sCurrentPageResult);
		
		//Getting the Total Search Results;
		System.out.println("Total Search Results:- "+ sTotalResults);
		
		//Click on Add Filters button
		driver.findElement(YelpLocators.AddFiltersbtn).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Click Price Filter
		driver.findElement(YelpLocators.PriceFilter$).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//click Feature Filter
		driver.findElement(YelpLocators.Features).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		// After Applying the filters   //Getting Search Result
		GetSearchResult();
				
		//Getting the Current Page Search Result;
		System.out.println("Current Page Search Result:- "+ sCurrentPageResult);
				
		//Getting the Total Search Results;
		System.out.println("Total Search Results:- "+ sTotalResults);
		
		//Getting Star Rating Restarunt info... Need to Write code....
		
		//Expand the First Restarunt.
		driver.findElement(YelpLocators.FirstResult).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Getting the Address and Phone number of First Expanded result
		String sPhoneNumber = driver.findElement(YelpLocators.PhoneNumber).getText();
		System.out.println("Phone Number :- "+sPhoneNumber);
		
		
		String sAddress = driver.findElement(YelpLocators.Address).getText();
		System.out.println("'Address :- "+sAddress);
		
		
		//First 3 Custmer Feedback/reviews
		
		System.out.println(driver.findElement(YelpLocators.CustomerReview1).getText());
		System.out.println(driver.findElement(YelpLocators.CustomerReview2).getText());
		System.out.println(driver.findElement(YelpLocators.CustomerReview3).getText());
		
		
		
		
		
		
		
		}
	public static void GetSearchResult(){
		String sText = driver.findElement(YelpLocators.FindResults).getText();  //Showing 1-10 of 2378
		String sValue[] = sText.split("-");
		String sValue1 = sValue[0];
		String sValue2 = sValue[1];
		
		// sValue2 = 10 of 2378		
		String sResults[] = sValue2.split("of");
		sCurrentPageResult = sResults[0];
		sTotalResults = sResults[1];		
	}
		
	public static boolean SearchReastaruats(String sSearchText){
		try{
			WebElement element = driver.findElement(YelpLocators.FindRestaurants);
			element.clear();
			element.sendKeys(sSearchText);
			return true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return bStatus;
		}
		
	}
	
	public static boolean NavigateToURL(String sURL){
		try{
			
			driver.get(sURL);
			return true;			
		}catch(Exception e){
			System.out.println(e.getMessage());
			return bStatus;
		}
	}
	
	public static boolean LaunchBrowser(String sBrowserName){
		
		try{
			if(sBrowserName.equalsIgnoreCase("firefox")){			
				driver = new FirefoxDriver();
				return true;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return bStatus;
		}
		
	
		
		return bStatus;
		
	}

}
