package com.automation.tests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTestTG;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class AutomationScripts extends BaseTestTG {
	private Logger mylog = LogManager.getLogger(AutomationScripts.class);
	
@Test
	public void loginToSalesforce() {
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
		public void loginerrormsg() {
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
public void loginHomePage() throws InterruptedException {
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
    String expectedHomePageText = "Tab Navigation";  
    String actualHomePageText = getTextFromElement(homePageText, "Home Page Text");
    Assert.assertEquals(actualHomePageText, expectedHomePageText, "Home page is not displayed");
}

@Test
public void CheckBox() throws InterruptedException {
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
      mylog.info(actualUsername);
      Assert.assertEquals(actualUsername, "gayathriak@gmail.com", "Username should be pre-populated");
      WebElement rememberCheckboxAfterLogout = driver.findElement(By.id("rememberUn"));
      Assert.assertTrue(rememberCheckboxAfterLogout.isSelected(), "Remember Username' checkbox should remain checked");
  }
	
@Test
public void UserMenu () throws InterruptedException {
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
     mylog.info("All user menu dropdown options are displayed correctly.");
 }

@Test
public void DeveloperConsole() {
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
            mylog.info("Switched to Developer Console window");
            break;
        }
    }
    driver.close(); // Close the Developer Console window
    mylog.info("Developer Console window is closed");
    driver.switchTo().window(mainWindowHandle);
    mylog.info("Switched back to the main window");
    WebElement userMenuAfterSwitch = driver.findElement(By.id("userNavButton"));
    Assert.assertTrue(userMenuAfterSwitch.isDisplayed(), "User menu is displayed after closing Developer Console");
}

@Test
public void UsernameField () {
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
    mylog.info("Logout successful, redirected to the login page");
}


@Test
public void LogOutMenu() throws InterruptedException {
	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	WebElement usernameEle=driver.findElement(By.id("username"));
	waitForVisibility1(usernameEle,30,"username");
	enterText(usernameEle,usernameData,"username");
	WebElement passwordEle=driver.findElement(By.id("password"));
	enterText(passwordEle, passwordData ," password");
	WebElement butonEle=driver.findElement(By.id("Login"));
	clickElement(butonEle,"loginbutton");
	 Thread.sleep(5000);
     WebElement selMenuEle = driver.findElement(By.id("userNavLabel"));
     waitForVisibility(selMenuEle, 10, 2, "User Menu");
     selMenuEle.click();
     System.out.println("User menu is clicked");
     WebElement logoutEle = driver.findElement(By.xpath("//a[text()='Logout']"));
     waitForVisibility(logoutEle, 10, 2, "Logout Link");
     logoutEle.click();
     System.out.println("Logout is clicked");
     Thread.sleep(5000); 
     String currentUrl = driver.getCurrentUrl();
     boolean isLoggedOut = currentUrl.contains("login.salesforce.com") || currentUrl.contains("my.salesforce.com");
     Assert.assertTrue(isLoggedOut, "User should be redirected to login page after logout");
     System.out.println("Logout successful and user redirected to login page");
 }

    @Test
	public void createAcc() throws InterruptedException {
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle, 30, "username");
		enterText(usernameEle, usernameData, "username");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData, " password");
		WebElement butonEle = driver.findElement(By.id("Login"));
		clickElement(butonEle, "loginbutton");
		Thread.sleep(5000);
		WebElement accountsLink = driver.findElement(By.linkText("Accounts"));
		clickElement(accountsLink, "Accounts link");
		System.out.println("Accounts link clicked");
		Thread.sleep(3000);
		WebElement newButton = driver.findElement(By.name("new"));
		clickElement(newButton, "New button");
		System.out.println("New button clicked to create an account");
		Thread.sleep(3000);
		WebElement accountNameField = driver.findElement(By.id("acc2"));
		enterText(accountNameField, "Test Account Name", "Account Name field");
		System.out.println("Account name entered");
		WebElement typeDropdown = driver.findElement(By.id("acc6"));
		Select typeSelect = new Select(typeDropdown);
		typeSelect.selectByVisibleText("Technology Partner");
		System.out.println("Technology Partner selected from Type dropdown");
		WebElement priorityDropdown = driver.findElement(By.id("00Naj000005aEfv"));
		Select prioritySelect = new Select(priorityDropdown);
		prioritySelect.selectByVisibleText("High");
		System.out.println("Customer Priority set to High");
		WebElement saveButton = driver.findElement(By.name("save"));
		clickElement(saveButton, "Save button");
		System.out.println("Save button clicked");
	}
    
    @Test
    public void CreateNewView() throws InterruptedException {
    	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle, 30, "username");
		enterText(usernameEle, usernameData, "username");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData, " password");
		WebElement butonEle = driver.findElement(By.id("Login"));
		clickElement(butonEle, "loginbutton");
		Thread.sleep(5000);
		 /*WebElement accountsLink = driver.findElement(By.linkText("Accounts"));
		    waitForVisibility1(accountsLink, 30, "Accounts Link");
		    clickElement(accountsLink, "Accounts Link");
		    System.out.println("Accounts link clicked");*/
        WebElement accountsLink = driver.findElement(By.linkText("Accounts"));
        clickElement(accountsLink, "Accounts Link");
        System.out.println("Accounts link clicked");

        // Clicking on Create New View link
        WebElement createNewViewLink = driver.findElement(By.linkText("Create New View"));
        clickElement(createNewViewLink, "Create New View Link");
        System.out.println("Create New View link clicked");

        // Waiting for visibility of view name field and entering details
        WebElement viewNameField = driver.findElement(By.id("fname"));
        waitForVisibility1(viewNameField, 30, "View Name Field");
        WebElement viewUniqueNameField = driver.findElement(By.id("devname"));

        String viewName = "Test x name";
        String uniqueViewName = "TestxViewName";

        enterText(viewNameField, viewName, "View Name");
        enterText(viewUniqueNameField, uniqueViewName, "Unique View Name");
        System.out.println("View Name and Unique View Name entered");

        // Clicking Save button
        WebElement saveButton = driver.findElement(By.name("save"));
        clickElement(saveButton, "Save Button");
        System.out.println("Save button clicked");

        // Waiting for the view dropdown to appear and validate new view
        WebElement viewDropdown = driver.findElement(By.name("fcf"));
        waitForVisibility1(viewDropdown, 30, "View Dropdown");

        Select viewSelect = new Select(viewDropdown);
        boolean viewExists = viewSelect.getOptions().stream().anyMatch(option -> option.getText().equals(viewName));

        if (viewExists) {
            System.out.println("Newly added View is displayed in the account view list");
        } else {
            System.out.println("Newly added View is NOT displayed in the account view list");
        }
    }
    @Test
    public void EditView() throws InterruptedException {
    	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle, 30, "username");
		enterText(usernameEle, usernameData, "username");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData, " password");
		WebElement butonEle = driver.findElement(By.id("Login"));
		clickElement(butonEle, "loginbutton");
		Thread.sleep(5000);
    WebElement accountsLink = driver.findElement(By.linkText("Accounts"));
    waitForVisibility1(accountsLink, 30, "Accounts Link");
    clickElement(accountsLink, "Accounts Link");
    System.out.println("Accounts link clicked");

    // Wait for the View Dropdown to be visible and select the existing view
    WebElement viewDropdown = driver.findElement(By.name("fcf"));
    waitForVisibility1(viewDropdown, 30, "View Dropdown");
    Select viewSelect = new Select(viewDropdown);
    String existingViewName = "sname";  
    viewSelect.selectByVisibleText(existingViewName);
    System.out.println("Selected view: " + existingViewName);

    // Wait for the Edit link to be visible and click it
    WebElement editLink = driver.findElement(By.linkText("Edit"));
    waitForVisibility1(editLink, 30, "Edit Link");
    clickElement(editLink, "Edit Link");
    System.out.println("Edit link clicked");

    // Wait for the View Name field to be visible, clear it, and enter a new view name
    WebElement viewNameField = driver.findElement(By.id("fname"));
    waitForVisibility1(viewNameField, 30, "View Name Field");
    String newViewName = "Test New Name";  
    viewNameField.clear();
    enterText(viewNameField, newViewName, "New View Name");
    System.out.println("View name changed to: " + newViewName);

    // Select Account Name in the Field dropdown
    WebElement fieldDropdown = driver.findElement(By.id("fcol1"));
    waitForVisibility1(fieldDropdown, 30, "Field Dropdown");
    Select fieldSelect = new Select(fieldDropdown);
    fieldSelect.selectByVisibleText("Account Name");

    // Select "contains" in the Operator dropdown
    WebElement operatorDropdown = driver.findElement(By.id("fop1"));
    waitForVisibility1(operatorDropdown, 30, "Operator Dropdown");
    Select operatorSelect = new Select(operatorDropdown);
    operatorSelect.selectByVisibleText("contains");

    // Enter "a" in the Value field
    WebElement valueField = driver.findElement(By.id("fval1"));
    waitForVisibility1(valueField, 30, "Value Field");
    valueField.clear();
    enterText(valueField, "a", "Value Field");
    System.out.println("Filter applied: Account Name contains 'a'");

    // Select "Last Activity" from Available Fields and add it to Displayed Fields
    WebElement availableFields = driver.findElement(By.id("colselector_select_0"));
    waitForVisibility1(availableFields, 30, "Available Fields");
    Select availableFieldsSelect = new Select(availableFields);
    availableFieldsSelect.selectByVisibleText("Last Activity");

    WebElement addButton = driver.findElement(By.id("colselector_select_0_right"));
    waitForElementToClickable(addButton, 30, "Add Button");
    clickElement(addButton, "Add Button");
    System.out.println("Added 'Last Activity' to displayed fields");

    // Wait for Save button to be visible and click it
    WebElement saveButton = driver.findElement(By.name("save"));
    waitForElementToClickable(saveButton, 30, "Save Button");
    clickElement(saveButton, "Save Button");
    System.out.println("Save button clicked");

    // Validate that the View was updated
    WebElement updatedViewDropdown = driver.findElement(By.name("fcf"));
    waitForVisibility1(updatedViewDropdown, 30, "Updated View Dropdown");
    Select updatedViewSelect = new Select(updatedViewDropdown);
    boolean viewExists = updatedViewSelect.getOptions().stream().anyMatch(option -> option.getText().equals(newViewName));

    if (viewExists) {
        System.out.println("View is updated to: " + newViewName);
    } else {
        System.out.println("View is NOT updated.");
    }

    // Validate that the data is filtered correctly (i.e., Account names containing "a")
    WebElement firstAccountName = driver.findElement(By.xpath("//table[@class='list']//tr[2]/th/a"));
    waitForVisibility1(firstAccountName, 30, "First Account Name");
    String accountNameText = firstAccountName.getText();

    if (accountNameText.contains("a")) {
        System.out.println("Data is filtered correctly, account name contains 'a': " + accountNameText);
    } else {
        System.out.println("Data is NOT filtered correctly, account name does not contain 'a'.");
    }

    
}
    @Test
	public void Opportunitydd() throws InterruptedException {
    	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle, 30, "username");
		enterText(usernameEle, usernameData, "username");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData, " password");
		WebElement butonEle = driver.findElement(By.id("Login"));
		clickElement(butonEle, "loginbutton");
		Thread.sleep(5000);
		  WebElement opportunitiesLink = driver.findElement(By.linkText("Opportunities"));
		    waitForVisibility1(opportunitiesLink, 30, "Opportunities Link");
		    clickElement(opportunitiesLink, "Opportunities Link");

		    // Wait for the Opportunities dropdown to be visible
		    WebElement dropdownElement = driver.findElement(By.id("fcf"));
		    waitForVisibility1(dropdownElement, 30, "Opportunities Dropdown");
		    Select opportunitiesDropdown = new Select(dropdownElement);

		    // Get the list of options from the dropdown
		    List<WebElement> dropdownOptions = opportunitiesDropdown.getOptions();

		    // Expected options in the dropdown
		    String[] expectedOptions = {
		        "All Opportunities", "Closing Next Month", "Closing This Month", 
		        "My Opportunities", "New This Week", "Recently Viewed Opportunities", "Won"
		    };

		    // Verify if all expected options are present in the dropdown
		    boolean allOptionsPresent = true;
		    for (String expectedOption : expectedOptions) {
		        boolean found = dropdownOptions.stream()
		                        .anyMatch(option -> option.getText().equals(expectedOption));
		        if (!found) {
		            allOptionsPresent = false;
		            System.out.println("Missing Option: " + expectedOption);
		        }
		    }

		    // Assert to ensure all options are present in the dropdown
		    if (allOptionsPresent) {
		        System.out.println("All expected options are present in the dropdown.");
		    } else {
		        System.out.println("Some expected options are missing.");
		    }
}
    @Test
    public void CreateNewOpp()  throws InterruptedException {
    	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle, 30, "username");
		enterText(usernameEle, usernameData, "username");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData, " password");
		WebElement butonEle = driver.findElement(By.id("Login"));
		clickElement(butonEle, "loginbutton");
		Thread.sleep(5000);
	    WebElement opportunitiesLink = driver.findElement(By.linkText("Opportunities"));
	    waitForVisibility1(opportunitiesLink, 30, "Opportunities Link");
	    clickElement(opportunitiesLink, "Opportunities Link");

	    // Wait for the 'New' button to be visible and click it
	    WebElement newButton = driver.findElement(By.name("new"));
	    waitForVisibility1(newButton, 30, "New Button");
	    clickElement(newButton, "New Button");
	    System.out.println("New Opportunity Edit page displayed.");

	    // Enter Opportunity Name
	    WebElement opportunityName = driver.findElement(By.id("opp3"));
	    waitForVisibility1(opportunityName, 30, "Opportunity Name Field");
	    enterText(opportunityName, "Test Opportunity Name", "Opportunity Name");

	    // Enter Account Name
	    WebElement accountName = driver.findElement(By.id("opp4"));
	    waitForVisibility1(accountName, 30, "Account Name Field");
	    enterText(accountName, "Test Account Name", "Account Name");

	    // Enter Close Date (assuming it accepts text input)
	    WebElement closeDate = driver.findElement(By.id("opp9"));
	    waitForVisibility1(closeDate, 30, "Close Date Field");
	    closeDate.clear(); // Clear any default value before sending new date
	    enterText(closeDate, "12/31/2024", "Close Date");

	    // Select Stage from dropdown
	    WebElement stageDropdown = driver.findElement(By.id("opp11"));
	    waitForVisibility1(stageDropdown, 30, "Stage Dropdown");
	    Select stageSelect = new Select(stageDropdown);
	    stageSelect.selectByVisibleText("Prospecting"); // Use dropdown selection instead of sendKeys()

	    // Enter Probability
	    WebElement probability = driver.findElement(By.id("opp12"));
	    waitForVisibility1(probability, 30, "Probability Field");
	    enterText(probability, "50", "Probability");

	    // Select Lead Source from dropdown (assuming it's a dropdown)
	    WebElement leadSourceDropdown = driver.findElement(By.id("opp6"));
	    waitForVisibility1(leadSourceDropdown, 30, "Lead Source Dropdown");
	    Select leadSourceSelect = new Select(leadSourceDropdown);
	    leadSourceSelect.selectByVisibleText("Web");

	    // Enter Campaign Source (assuming it's a free text field)
	    WebElement campaignSource = driver.findElement(By.id("opp17"));
	    waitForVisibility1(campaignSource, 30, "Campaign Source Field");
	    enterText(campaignSource, "Test Campaign", "Campaign Source");

	    // Wait for Save button to be visible and click it
	    WebElement saveButton = driver.findElement(By.name("save"));
	    waitForVisibility1(saveButton, 30, "Save Button");
	    clickElement(saveButton, "Save Button");

	    System.out.println("New Opportunity created successfully.");
}
    @Test
public void verifyOpportunityInTable() throws InterruptedException {
    	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility1(usernameEle, 30, "username");
		enterText(usernameEle, usernameData, "username");
		WebElement passwordEle = driver.findElement(By.id("password"));
		enterText(passwordEle, passwordData, " password");
		WebElement butonEle = driver.findElement(By.id("Login"));
		clickElement(butonEle, "loginbutton");
		Thread.sleep(5000);
		 WebElement opportunitiesLink = driver.findElement(By.linkText("Opportunities"));
		    waitForVisibility1(opportunitiesLink, 30, "Opportunities Link");
		    clickElement(opportunitiesLink, "Opportunities Link");
		    WebElement opportunitiesTable = driver.findElement(By.xpath("//table[@class='list']/tbody"));
		    waitForVisibility1(opportunitiesTable, 30, "Opportunities Table");
		    boolean opportunityDisplayed = opportunitiesTable.getText().contains("Test Opportunity Name");

		    if (opportunityDisplayed) {
		        System.out.println("Report page with the Opportunities that are pipelined is displayed correctly.");
		    } else {
		        System.out.println("The newly created Opportunity is not displayed in the report.");
		    }
}
    @Test
    public void testStuckOpportunitiesReport() {
        try {
        	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
    		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
    		WebElement usernameEle = driver.findElement(By.id("username"));
    		waitForVisibility1(usernameEle, 30, "username");
    		enterText(usernameEle, usernameData, "username");
    		WebElement passwordEle = driver.findElement(By.id("password"));
    		enterText(passwordEle, passwordData, " password");
    		WebElement butonEle = driver.findElement(By.id("Login"));
    		clickElement(butonEle, "loginbutton");
    		Thread.sleep(5000);

            // Wait for Opportunities link to be visible and click it
            WebElement opportunitiesLink = driver.findElement(By.linkText("Opportunities"));
            waitForVisibility1(opportunitiesLink, 30, "Opportunities Link");
            clickElement(opportunitiesLink, "Opportunities Link");

            // Wait for Stuck Opportunities link and click it
            WebElement stuckOpportunitiesLink = driver.findElement(By.linkText("Stuck Opportunities"));
            waitForVisibility1(stuckOpportunitiesLink, 30, "Stuck Opportunities Link");
            clickElement(stuckOpportunitiesLink, "Stuck Opportunities Link");
            System.out.println("Clicked on Stuck Opportunities link.");

            // Wait for report title to be visible and verify it
            WebElement reportTitle = driver.findElement(By.xpath("//h1[contains(text(), 'Stuck Opportunities')]"));
            waitForVisibility1(reportTitle, 30, "Report Title");
            Assert.assertTrue(reportTitle.isDisplayed(), "Report page with Stuck Opportunities is not displayed.");
            System.out.println("Report Page with the Opportunities that are Stuck is displayed.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            Assert.fail("Test failed due to an exception.");
        } finally {
            driver.quit();
        }
    }
    @Test
    public void testLeadsTab() {
        try {
        	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
    		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
    		WebElement usernameEle = driver.findElement(By.id("username"));
    		waitForVisibility1(usernameEle, 30, "username");
    		enterText(usernameEle, usernameData, "username");
    		WebElement passwordEle = driver.findElement(By.id("password"));
    		enterText(passwordEle, passwordData, " password");
    		WebElement butonEle = driver.findElement(By.id("Login"));
    		clickElement(butonEle, "loginbutton");
    		Thread.sleep(5000);
    		  WebElement leadsTab = driver.findElement(By.linkText("Leads"));
              waitForVisibility1(leadsTab, 30, "Leads Tab");
              clickElement(leadsTab, "Leads Tab");
              System.out.println("Clicked on Leads tab.");

              // Wait for the Leads page title to be visible and verify it
              WebElement leadsPageTitle = driver.findElement(By.xpath("//h1[contains(text(), 'Leads')]"));
              waitForVisibility1(leadsPageTitle, 30, "Leads Page Title");
              Assert.assertTrue(leadsPageTitle.isDisplayed(), "Leads page is not displayed.");
              System.out.println("Leads page is displayed.");

              // Log out by clicking the user menu and logout button
              WebElement userMenu = driver.findElement(By.className("userNavLabel"));
              waitForVisibility1(userMenu, 30, "User Menu");
              clickElement(userMenu, "User Menu");

              WebElement logoutButton = driver.findElement(By.linkText("Logout"));
              waitForVisibility1(logoutButton, 30, "Logout Button");
              clickElement(logoutButton, "Logout Button");
              System.out.println("User logged out successfully.");

          } catch (Exception e) {
              System.out.println("An error occurred: " + e.getMessage());
              Assert.fail("Test failed due to an exception: " + e.getMessage());
          } finally {
              driver.quit();
              System.out.println("Application closed.");
          }
      
    }
}






