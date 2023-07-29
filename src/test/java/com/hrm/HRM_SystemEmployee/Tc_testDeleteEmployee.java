package com.hrm.HRM_SystemEmployee;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.hrm.ObjectRepository.EmployeePage;
import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtilities;
import GenericUtilities.WebdriverUtility;

public class Tc_testDeleteEmployee extends BaseClass{

	
	@Test//(groups= {"smokeTest","RegressionTest"})
public void DeleteEmployee() throws EncryptedDocumentException, IOException  {

	HomePage homePage=new HomePage(driver);
	EmployeePage employeePage=new EmployeePage(driver);
	FileUtilities fiUtils=new FileUtilities();
	LoginPage loginPage=new LoginPage(driver);
	//WebdriverUtility weutils=new WebdriverUtility();
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
	    employeePage.deleteEmployee(driver);
	  //weutils.switchToAlertPopupAndAccept(driver, "Successfully");
	    System.out.println("Delete Employee Successfully");
}
}
