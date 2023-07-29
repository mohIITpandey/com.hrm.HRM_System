package com.hrm.HRM_SystemEmployee;



import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.hrm.ObjectRepository.EmployeePage;
import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtilities;


public class Tc_testDownlodEmployee extends BaseClass{
	
	
	@Test(groups="smokeTest")
   public void downloadEmployee() throws  Exception {
	
		HomePage homePage=new HomePage(driver);
		EmployeePage employeePage=new EmployeePage(driver);
		FileUtilities fiUtils=new FileUtilities();
		LoginPage loginPage=new LoginPage(driver);
		 homePage.getEmployeeModule().click();
		 homePage.getAddEmployeeModule().click();
		 employeePage.getAddEmployeeBtn().click();
		 employeePage.AddEmployee(driver);
		 homePage.LogOut(driver);
		 
		    String headUsername1 = fiUtils.getPropertyKeyValue("hrheadUserName1");
		  	String headPassword1 = fiUtils.getPropertyKeyValue("hrheadPassword1");
		  	String hrType=fiUtils.getPropertyKeyValue("hrHeadType");
		    loginPage.LoginToApp(driver, headUsername1, headPassword1, hrType);		  
		    homePage.getEmployeeModule().click();
		    homePage.getAddEmployeeModule().click();
		    employeePage.searchEmployee();
		    
		    employeePage.downloadEmployee(driver);
 
	}
}
