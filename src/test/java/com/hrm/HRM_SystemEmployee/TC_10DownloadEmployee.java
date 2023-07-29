package com.hrm.HRM_SystemEmployee;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hrm.ObjectRepository.AdminPage;
import com.hrm.ObjectRepository.EmployeePage;
import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtilities;
import GenericUtilities.IPathConstants;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebdriverUtility;

public class TC_10DownloadEmployee {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
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
	        
	        
	        homePage.getEmployeeModule() .click();
	          
	          //Go to the Add Employee module which displayed employee list page
	          homePage.getAddEmployeeModule().click();
	          
	          //Go to the Add Employee pop up
	          EmployeePage employeePage=new EmployeePage(driver);
	          employeePage.getAddEmployeeBtn().click(); ;
	          
	          //Fill the required Details
	          String EmpID =exUtils.getExcelData("employeeData", 1, 0);
	          employeePage.getEmployee_companyid().sendKeys(EmpID);
	           
	          String FirstName =exUtils.getExcelData("employeeData", 1, 1);
	          employeePage.getEmployee_firstname().sendKeys(FirstName); 
	          
	           String LastName =exUtils.getExcelData("employeeData", 1, 2);
	           employeePage.getEmployee_lastname().sendKeys(LastName);
	                      
	           String MiddleName = exUtils.getExcelData("employeeData", 1, 3);
	           employeePage.getEmployee_middlename().sendKeys(MiddleName);
	           
	           String branchDateFrom = exUtils.getExcelData("employeeData", 1, 4);
	           employeePage.getBranches_datefrom().sendKeys(branchDateFrom);
	           
	            String branchrecentDate = exUtils.getExcelData("employeeData", 1, 5);
	            employeePage.getBranches_recentdate().sendKeys(branchrecentDate);
	            
	            WebElement department = employeePage.getEmployee_department();
	            String corporateName = exUtils.getExcelData("CorporateModule", 1, 0);
	            weutils.selectElementInDropdown(department,corporateName);
	            
	            WebElement branches =employeePage.getEmployee_branches() ;
	            String branchName = exUtils.getExcelData("BranchModule", 1, 0);
	            weutils.selectElementInDropdown(branches,branchName);

	            
	            String position = exUtils.getExcelData("employeeData", 1, 6);
	            employeePage.getEmployee_position().sendKeys(position);
	            
	            String contact11 =exUtils.getExcelData("employeeData", 1, 7);          
	            employeePage.getEmployee_contact().sendKeys(contact11);
	            
	            String sss = exUtils.getExcelData("employeeData", 1, 8);
	            employeePage.getEmployee_sss().sendKeys(sss);
	            
	            String tin = exUtils.getExcelData("employeeData", 1, 9);
	            employeePage.getEmployee_tin().sendKeys(tin);
	            
	            String hdmf =exUtils.getExcelData("employeeData", 1, 10);
	            employeePage.getEmployee_hdmf().sendKeys(hdmf);
	            
	            String gsis = exUtils.getExcelData("employeeData", 1, 11);
	            employeePage.getEmployee_gsis().sendKeys(gsis);
	            
	            File fis11 =new File(IPathConstants.employeeDocument);
	           String path = fis11.getAbsolutePath();
	           employeePage.getEmployee_file().sendKeys(path);     
	           
	           File img =new File(IPathConstants.employeeImage);
	           String path1 = img.getAbsolutePath();          
	           employeePage.getEmployee_image().sendKeys(path1);
	           
	           //Save the details of the employee
	           employeePage.getSave_button().click();
	           weutils.waitForAlertPopup(driver);
	           weutils.switchToAlertPopupAndAccept(driver, "Successfully");
	           System.out.println("Employee Added Successfully");
	            
	           //Logout as HR Head
	           employeePage.LogOut(driver);
	           weutils.waitForAlertPopup(driver);
	           weutils.switchToAlertPopupAndAccept(driver, "Successfully");
	           System.out.println("HR Head logout successfully");
	           
	           
		          loginPage.getUserNameTxtBox().sendKeys(headUsername1);
		          loginPage.getPassWordTxtBox().sendKeys(headPassword1);
		          WebElement hrtype1 = loginPage.getHrtypeDrodown();
		          weutils.selectElementInDropdown(hrtype1,"HR Head");
		          loginPage.getSignInBtn().click();
		          weutils.waitForAlertPopup(driver);
	              weutils.switchToAlertPopupAndAccept(driver, "Successfully");
                  System.out.println("HR Head login successfully");
                  homePage.getEmployeeModule().click();
		             
		          //Go to the Add employee Module which displayed Employee List page
		          homePage.getAddEmployeeModule().click();
		            
		          //Select the employee which is added by HR Head 
		          employeePage.getSearchTxtBox().sendKeys(EmpID);
		          employeePage.downloadEmployeeFileIcon(driver, EmpID).click();
		       
		          System.out.println("-----------PASS-----------");
		             
		   driver.quit();
		                     
	        
	        
}
}