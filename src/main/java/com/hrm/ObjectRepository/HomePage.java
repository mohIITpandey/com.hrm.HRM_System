package com.hrm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtilities.WebdriverUtility;

public class HomePage {
	
	
	@FindBy(xpath="//p[contains(.,'CORPORATE')]")private WebElement corporateModule;
	
	@FindBy(xpath="//p[contains(.,'BRANCHES')]")private WebElement branchesModule;
	
	@FindBy(xpath="//p[contains(.,'EMPLOYEE')]")private WebElement employeeModule;
	
	@FindBy(xpath="//p[contains(.,'ADMIN')]")private WebElement adminModule;
	
	@FindBy(xpath="//p[.='Add Corporate']")private WebElement addCorporateModule;
  
	@FindBy(xpath="//p[.='Add Braches']")private WebElement addBranchesModule;

	@FindBy(xpath="//p[.='Add Employee']")private WebElement addEmployeeModule;

	@FindBy(xpath="//p[.='Add Admin']")private WebElement addAdminModule;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	public WebElement getCorporateModule() {
		return corporateModule;
	}

	public WebElement getBranchesModule() {
		return branchesModule;
	}

	public WebElement getEmployeeModule() {
		return employeeModule;
	}

	public WebElement getAdminModule() {
		return adminModule;
	}

	public WebElement getAddCorporateModule() {
		return addCorporateModule;
	}

	public WebElement getAddBranchesModule() {
		return addBranchesModule;
	}

	public WebElement getAddEmployeeModule() {
		return addEmployeeModule;
	}

	public WebElement getAddAdminModule() {
		return addAdminModule;
	}
	 public void LogOut(WebDriver driver) {
			WebdriverUtility weutils=new WebdriverUtility();

		   driver.findElement(By.xpath("//b[.='Welcome!,']")).click();
	       driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
	        weutils.switchToAlertPopupAndAccept(driver, "Successfully");
          System.out.println("------logout successfully------");
	     
	   }
	
	
}
