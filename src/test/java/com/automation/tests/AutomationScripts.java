package com.automation.tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTestTG;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class AutomationScripts extends BaseTestTG {
@Test
	public void login() {
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle=driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle,30,"username");
		enterText(usernameEle,usernameData,"username");
		WebElement passwordEle=driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData ," password");
		WebElement butonEle=driver.findElement(By.id("Login"));
		clickElement(butonEle,"loginbutton");
		}
@Test
		public void validLoginTest() {
			String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
			String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
			WebElement usernameEle = driver.findElement(By.id("username"));
			waitForVisibility1(usernameEle, 30, "username");
			enterText(usernameEle, usernameData, "username");
			WebElement passwordEle = driver.findElement(By.id("password"));
			passwordEle.clear();
			Assert.assertEquals(passwordEle.getAttribute("value"), "", "Password field is not empty");
			WebElement loginButton = driver.findElement(By.id("Login"));
			clickElement(loginButton, "Login Button");
			WebElement errorMsg = driver.findElement(By.id("error"));
			String expectedErrorMessage = "Please enter your password.";
			Assert.assertEquals(errorMsg.getText(), expectedErrorMessage, "Error message validation failed.");
		}


@Test
public void loginToSalesforce() throws InterruptedException {
	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
	WebElement usernameEle = driver.findElement(By.id("username"));
	waitForVisibility1(usernameEle, 30, "username");
	enterText(usernameEle, usernameData, "username");
	WebElement passwordEle=driver.findElement(By.id("password"));
	enterText(passwordEle, passwordData ," password");
	WebElement butonEle=driver.findElement(By.id("Login"));
	clickElement(butonEle,"loginbutton");
	Thread.sleep(4000);
	WebElement homePageText = driver.findElement(By.xpath("//h1")); 
	waitForVisibility1(homePageText, 30, "homePage");
    String expectedHomePageText = "Tab Navigation";  // Update this with the actual expected text for Home Page verification
    String actualHomePageText = getTextFromElement(homePageText, "Home Page Text");
    Assert.assertEquals(actualHomePageText, expectedHomePageText, "Home page is not displayed");
}

@Test
public void loginToSalesforce4() throws InterruptedException {
	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
	String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
	WebElement usernameEle = driver.findElement(By.id("username"));
	waitForVisibility1(usernameEle, 30, "username");
	enterText(usernameEle, usernameData, "username");
	WebElement passwordEle=driver.findElement(By.id("password"));
	enterText(passwordEle, passwordData ," password");
	 WebElement rememberCheckbox = driver.findElement(By.id("rememberUn"));
	  selectCheckBox(rememberCheckbox, "Remember Username");
	WebElement butonEle=driver.findElement(By.id("Login"));
	clickElement(butonEle,"loginbutton");
	Thread.sleep(4000);
	  waitForVisibility(driver.findElement(By.id("userNavButton")), 10, 1, "User Menu");
      clickElement(driver.findElement(By.id("userNavButton")), "User Menu");
      waitForVisibility(driver.findElement(By.linkText("Logout")), 10, 1, "Logout Link");
      clickElement(driver.findElement(By.linkText("Logout")), "Logout Link");
      waitForVisibility(driver.findElement(By.name("username")), 20, 1, "Prepopulated Username Field");
      WebElement prepopulatedUsernameField = driver.findElement(By.name("username"));
      String actualUsername = prepopulatedUsernameField.getAttribute("value");
      System.out.println(actualUsername);
      Assert.assertEquals(actualUsername, "gayathriak@gmail.com", "Username should be pre-populated");
      WebElement rememberCheckboxAfterLogout = driver.findElement(By.id("rememberUn"));
      Assert.assertTrue(rememberCheckboxAfterLogout.isSelected(), "Remember Username' checkbox should remain checked");
  }
	
@Test
public void usermenu() throws InterruptedException {
	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	WebElement usernameEle=driver.findElement(By.id("username"));
	waitForVisibility1(usernameEle,30,"username");
	enterText(usernameEle,usernameData,"username");
	WebElement passwordEle=driver.findElement(By.id("password"));
	enterText(passwordEle, passwordData ," password");
	WebElement butonEle=driver.findElement(By.id("Login"));
	clickElement(butonEle,"loginbutton");
	Thread.sleep(4000);
	 WebElement userMenu = driver.findElement(By.id("userNavButton"));
     waitForVisibility(userMenu, 10, 1, "User Menu");
     Assert.assertNotNull(userMenu, "User menu dropdown should be available after login");
     clickElement(userMenu, "User Menu Button");
     waitForVisibility(driver.findElement(By.linkText("My Profile")), 10, 1, "My Profile Link");
     waitForVisibility(driver.findElement(By.linkText("My Settings")), 10, 1, "My Settings Link");
     waitForVisibility(driver.findElement(By.linkText("Developer Console")), 10, 1, "Developer Console Link");
     waitForVisibility(driver.findElement(By.linkText("Logout")), 10, 1, "Logout Link");
     waitForVisibility(driver.findElement(By.linkText("Switch to Lightning Experience")), 10, 1, "Switch to Lightning Experience Link");
     Assert.assertTrue(driver.findElement(By.linkText("My Profile")).isDisplayed(), "'My Profile' should be available in the dropdown");
     Assert.assertTrue(driver.findElement(By.linkText("My Settings")).isDisplayed(), "'My Settings' should be available in the dropdown");
     Assert.assertTrue(driver.findElement(By.linkText("Developer Console")).isDisplayed(), "'Developer Console' should be available in the dropdown");
     Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed(), "'Logout' should be available in the dropdown");
     Assert.assertTrue(driver.findElement(By.linkText("Switch to Lightning Experience")).isDisplayed(), "'Switch to Lightning Experience' should be available in the dropdown");
     System.out.println("All user menu dropdown options are displayed correctly.");
 }

@Test
public void openAndCloseDeveloperConsole() {
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle=driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle,30,"username");
		enterText(usernameEle,usernameData,"username");
		WebElement passwordEle=driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData ," password");
		WebElement butonEle=driver.findElement(By.id("Login"));
		clickElement(butonEle,"loginbutton");
    WebElement userMenu = driver.findElement(By.id("userNavButton"));
    waitForVisibility(userMenu, 20, 1, "User Menu");
    clickElement(userMenu, "User Menu");
    WebElement developerConsoleLink = driver.findElement(By.linkText("Developer Console"));
    waitForVisibility(developerConsoleLink, 10, 1, "Developer Console Link");
    clickElement(developerConsoleLink, "Developer Console Link");
    String mainWindowHandle = driver.getWindowHandle();
    Set<String> allWindowHandles = driver.getWindowHandles();
    for (String windowHandle : allWindowHandles) {
        if (!windowHandle.equals(mainWindowHandle)) {
            driver.switchTo().window(windowHandle);
            System.out.println("Switched to Developer Console window");
            break;
        }
    }
    driver.close(); // Close the Developer Console window
    System.out.println("Developer Console window is closed");
    driver.switchTo().window(mainWindowHandle);
    System.out.println("Switched back to the main window");
    WebElement userMenuAfterSwitch = driver.findElement(By.id("userNavButton"));
    Assert.assertTrue(userMenuAfterSwitch.isDisplayed(), "User menu is displayed after closing Developer Console");
}

@Test
public void logoutFromSalesforce() {
	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	WebElement usernameEle=driver.findElement(By.id("username"));
	waitForVisibility1(usernameEle,30,"username");
	enterText(usernameEle,usernameData,"username");
	WebElement passwordEle=driver.findElement(By.id("password"));
	enterText(passwordEle, passwordData ," password");
	WebElement butonEle=driver.findElement(By.id("Login"));
	clickElement(butonEle,"loginbutton");
    WebElement userMenu = driver.findElement(By.id("userNavButton"));
    waitForVisibility(userMenu, 20, 1, "User Menu");
    clickElement(userMenu, "User Menu");
    WebElement logoutOption = driver.findElement(By.linkText("Logout"));
    waitForVisibility(logoutOption, 10, 1, "Logout Option");
    clickElement(logoutOption, "Logout Option");
    String expectedUrl = "https://login.salesforce.com/";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl, expectedUrl, "User should be redirected to the login page after logout");
    WebElement usernameFieldAfterLogout = driver.findElement(By.id("username"));
    Assert.assertTrue(usernameFieldAfterLogout.isDisplayed(), "Username field should be displayed on login page after logout");   
    System.out.println("Logout successful, redirected to the login page");
}
}






