package com.hrm.HRM_SystemEmployee;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.hrm.ObjectRepository.AdminPage;
import com.hrm.ObjectRepository.CorporatePage;
import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import GenericUtilities.BaseClass;
import GenericUtilities.FileUtilities;
import GenericUtilities.WebdriverUtility;

public class Tc_testModifyCorporate extends BaseClass {
	
	
@Test(groups= "RegressionTest")
public void modifyCorporate() throws Exception {
	 HomePage homePage=new HomePage(driver);
	 LoginPage loginpage=new LoginPage(driver);
	 CorporatePage corp=new CorporatePage(driver);
	 FileUtilities fiUtils=new FileUtilities();
	 WebdriverUtility weutils=new WebdriverUtility();
	 
     homePage.getAdminModule().click();
     
     homePage.getAdminModule().click();
     
     homePage.getAddAdminModule().click();
   
      AdminPage adminPage=new AdminPage(driver);
      adminPage.getAddAdminBtn().click();
      adminPage.addAdmin(driver);  
      System.out.println("--------Admin is created-----------");
      homePage.getCorporateModule().click();
      homePage.getAddCorporateModule().click();
      corp.getAddCorporateBtn().click();
      corp.addCorporate(driver);
      homePage.LogOut(driver);
      

   
    String headUsername1 = fiUtils.getPropertyKeyValue("hrheadUserName1");
  	String headPassword1 = fiUtils.getPropertyKeyValue("hrheadPassword1");
  	String hrType=fiUtils.getPropertyKeyValue("hrHeadType");
    loginpage.LoginToApp(driver, headUsername1, headPassword1, hrType);
   // weutils.switchToAlertPopupAndAccept(driver, "Successfully");
    weutils.waitTillPageGetsLoad(driver);
    
    homePage.getCorporateModule().click();
    homePage.getAddCorporateModule().click();
    corp.searchCorporateName();
    corp.EditCorporateName(driver);
    System.out.println("corporate name updated successfully ");
}
}
