package com.hrm.HRM_SystemEmployee;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hrm.ObjectRepository.AdminPage;
import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtilities;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebdriverUtility;

public class TC_AddAdmin {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Create the Objects of generic Utilities 
		ExcelUtility exUtils=new ExcelUtility();
		FileUtilities fiUtils=new FileUtilities();
		JavaUtility jaUtility=new JavaUtility();
		WebdriverUtility weutils=new WebdriverUtility();
		
		//fetch data from Properties file
		String BROWSER = fiUtils.getPropertyKeyValue("browser");
		String url = fiUtils.getPropertyKeyValue("url");
		String headUsername = fiUtils.getPropertyKeyValue("hrheadUsername");
		String headPassword = fiUtils.getPropertyKeyValue("hrheadPassword");
		String headUsername1 = fiUtils.getPropertyKeyValue("hrheadUserName1");
		String headPassword1 = fiUtils.getPropertyKeyValue("hrheadPassword1");
	 
		
		//Open the Browser
		WebDriver driver=weutils.checkDriver(BROWSER);
		
		weutils.maximizeWindow(driver);
	 
		//Enter the Url
		driver.get(url);
		 weutils.waitTillPageGetsLoad(driver);
		//verify the Login with Hr head credentials
		 LoginPage loginPage=new LoginPage(driver);
		loginPage.getUserNameTxtBox().sendKeys(headUsername);
		loginPage.getPassWordTxtBox().sendKeys(headPassword);
        WebElement hrtype =loginPage.getHrtypeDrodown();
          
         weutils.selectElementInDropdown(hrtype,"HR Head");
         loginPage.getSignInBtn().click();
          
          weutils.waitForAlertPopup(driver);
          
          weutils.switchToAlertPopupAndAccept(driver, "Successfully");
          System.out.println("HR Head Login Successfully");
         
          HomePage homePage=new HomePage(driver);
        homePage.getAdminModule().click();
        
       homePage.getAdminModule().click();
        
        homePage.getAddAdminModule().click();
        
        
        AdminPage adminPage=new AdminPage(driver);
         adminPage.getAddAdminBtn().click();
        		
        		
         String id1 = exUtils.getExcelData("AdminModule", 1, 0);	
         adminPage.getHr_companyid().sendKeys(id1);
        
        String first1 = exUtils.getExcelData("AdminModule", 1, 1);
        adminPage.getHr_firstname().sendKeys(first1);
        
        String last1 = exUtils.getExcelData("AdminModule", 1, 2);
        adminPage.getHr_lastname().sendKeys(last1);
        
        String middle1 = exUtils.getExcelData("AdminModule", 1, 3);
        adminPage.getHr_middlename().sendKeys(middle1);
        
        String contact1 = exUtils.getExcelData("AdminModule", 1, 4);
        adminPage.getHr_contactno().sendKeys(contact1);
        
        WebElement hrType = adminPage.getHr_typeDropdown();
        weutils.selectElementInDropdown(hrType, "HR Head");
      
        adminPage.getHr_email().sendKeys(headUsername1);
        adminPage.getHr_password().sendKeys(headPassword1);
        adminPage.getSaveBtn().click();
        weutils.switchToAlertPopupAndAccept(driver, "Successfully");
        
        //Logout as HR Head
        adminPage.LogOut(driver);
        weutils.waitForAlertPopup(driver);
        weutils.switchToAlertPopupAndAccept(driver, "Successfully");
        System.out.println("HR Head logout successfully");
        
		weutils.waitForAUrl(driver, url);

    	loginPage.getUserNameTxtBox().sendKeys(headUsername1);
    	loginPage.getPassWordTxtBox().sendKeys(headPassword1);
        WebElement hrtype1 = loginPage.getHrtypeDrodown();
        weutils.selectElementInDropdown(hrtype1,"HR Head");
        
        loginPage.getSignInBtn().click();
          
        weutils.waitForAlertPopup(driver);
        weutils.switchToAlertPopupAndAccept(driver, "Successfully");
        System.out.println("HR Head 2 Login Successfully");
          
        driver.quit();
        
        
	}

}
