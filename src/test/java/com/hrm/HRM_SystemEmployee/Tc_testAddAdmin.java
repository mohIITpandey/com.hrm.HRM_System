package com.hrm.HRM_SystemEmployee;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import com.hrm.ObjectRepository.AdminPage;
import com.hrm.ObjectRepository.HomePage;

import GenericUtilities.BaseClass;
@Listeners(GenericUtilities.ListenersImplementation.class)
public class Tc_testAddAdmin extends BaseClass {
	
	
	@Test(groups="smokeTest")
	public void createAdmin() throws IOException {
		  
      HomePage homePage=new HomePage(driver);
      homePage.getAdminModule().click();
      
      homePage.getAdminModule().click();
      
      homePage.getAddAdminModule().click();
      
      Assert.fail();
       AdminPage adminPage=new AdminPage(driver);
       adminPage.getAddAdminBtn().click();
       adminPage.addAdmin(driver);  
	}
	
	

}
