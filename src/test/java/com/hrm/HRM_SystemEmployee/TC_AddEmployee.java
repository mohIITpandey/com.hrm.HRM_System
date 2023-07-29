package com.hrm.HRM_SystemEmployee;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hrm.ObjectRepository.EmployeePage;
import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtilities;
import GenericUtilities.IPathConstants;
import GenericUtilities.JavaUtility;
import GenericUtilities.WebdriverUtility;

public class TC_AddEmployee {

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
		      
		          //Go to the Employee module
		          HomePage homepage=new HomePage(driver);
		          homepage.getEmployeeModule() .click();
		          
		          //Go to the Add Employee module which displayed employee list page
		          homepage.getAddEmployeeModule().click();
		          
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
		            
		            WebElement branches =employeePage.getEmployee_branches();
		            String branchName = exUtils.getExcelData("BranchModule", 1, 0);
		            weutils.selectElementInDropdown(branches,branchName);

		            
		            String position = exUtils.getExcelData("employeeData", 1, 6);
		            employeePage.getEmployee_position().sendKeys(position);
		            
		            String contact1 =exUtils.getExcelData("employeeData", 1, 7);          
		            employeePage.getEmployee_contact().sendKeys(contact1);
		            
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
		      

	}

}
