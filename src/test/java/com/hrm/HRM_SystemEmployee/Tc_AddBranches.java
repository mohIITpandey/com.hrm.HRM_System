package com.hrm.HRM_SystemEmployee;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.hrm.ObjectRepository.BranchesPage;
import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtilities;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebdriverUtility;

public class Tc_AddBranches {

	public static void main(String[] args) throws IOException {
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
		String officerUsername = fiUtils.getPropertyKeyValue("hrOfficerUserName");
		String officerPassword = fiUtils.getPropertyKeyValue("hrOfficerPassword");
	
		//Open the Browser
		WebDriver driver=weutils.checkDriver(BROWSER);
		weutils.maximizeWindow(driver);
	    weutils.waitTillPageGetsLoad(driver);
		
		//Enter the Url
		driver.get(url);
		
		//verify the Login with Hr head credentials
		  LoginPage loginPage= new LoginPage(driver);
		  loginPage.getUserNameTxtBox().sendKeys(headUsername);
          loginPage.getPassWordTxtBox().sendKeys(headPassword);
          loginPage.selectHRType(weutils,"HR Head");
          loginPage.getSignInBtn().click();
          weutils.waitForAlertPopup(driver);
          weutils.switchToAlertPopupAndAccept(driver, "Successfully");
          System.out.println("HR Head Login Successfully");
      
          //Go to the Corporate module
          HomePage homepage=new HomePage(driver);
          homepage.getBranchesModule().click();
          homepage.getAddBranchesModule().click();
          
          BranchesPage branchPage=new BranchesPage(driver);
          branchPage.getAddBranchBtn().click();
          String branchName = exUtils.getExcelData("BranchModule",1, 0);
          branchPage.getAddBranchTxtBox().sendKeys(branchName);
          branchPage.getAddBranchesSaveBtn().click();
          weutils.switchToAlertPopupAndAccept(driver,"Successfully");
          branchPage.getSearchTxtBox().sendKeys(branchName);
          if(branchPage.getVerifyBranchName(driver, branchName)){
        	 System.out.println("Branch added successfully"); 
          }
          else {
        	  System.out.println("Branch not added successfully");
          }
          driver.quit();

	}

}
