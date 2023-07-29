package com.hrm.ObjectRepository;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.ExcelUtility;
import GenericUtilities.FileUtilities;
import GenericUtilities.WebdriverUtility;

public class AdminPage {

	@FindBy(xpath="//button[contains(.,'Add Admin')]")private WebElement addAdminBtn;
	@FindBy(xpath="//input[contains(@type,'search')]")private WebElement searchTxtBox;
	@FindBy(xpath="//td[.='Prabath']/following-sibling::td/i[@title='Edit Employee']")private WebElement editAdminBtn;
	@FindBy(xpath="//td[.='Prabath']/following-sibling::td/i[@title='Delete Employee']")private WebElement deleteAdminBtn;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//input[@name='hr_companyid']")private WebElement hr_companyid;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//input[@name='hr_firstname']")private WebElement hr_firstname;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//input[@name='hr_lastname']")private WebElement hr_lastname;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//input[@name='hr_middlename']")private WebElement hr_middlename;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//input[@name='hr_contactno']")private WebElement hr_contactno;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//select[@id='hr_type']")private WebElement hr_typeDropdown;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//input[@name='hr_email']")private WebElement hr_email;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//input[@name='hr_password']")private WebElement hr_password;
	@FindBy(xpath="//h4[.='Add Admin']/parent::div[@class='modal-header']/following-sibling::form//button[.='Save']")private WebElement SaveBtn;


	  public AdminPage(WebDriver driver) {
			PageFactory.initElements( driver,this);
		}

	public WebElement getAddAdminBtn() {
		return addAdminBtn;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getEditAdminBtn() {
		return editAdminBtn;
	}

	public WebElement getDeleteAdminBtn() {
		return deleteAdminBtn;
	}
	
	 public WebElement getHr_companyid() {
		return hr_companyid;
	}

	public WebElement getHr_firstname() {
		return hr_firstname;
	}

	public WebElement getHr_lastname() {
		return hr_lastname;
	}

	public WebElement getHr_middlename() {
		return hr_middlename;
	}

	public WebElement getHr_contactno() {
		return hr_contactno;
	}

	public WebElement getHr_typeDropdown() {
		return hr_typeDropdown;
	}

	public WebElement getHr_email() {
		return hr_email;
	}

	public WebElement getHr_password() {
		return hr_password;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void LogOut(WebDriver driver) {
		   driver.findElement(By.xpath("//b[.='Welcome!,']")).click();
	       driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
	   }
public void addAdmin(WebDriver driver ) throws IOException {
	ExcelUtility exUtils=new ExcelUtility();
	FileUtilities fiUtils=new FileUtilities();
	WebdriverUtility weutils=new WebdriverUtility();

	
	String headUsername1 = fiUtils.getPropertyKeyValue("hrheadUserName1");
	String headPassword1 = fiUtils.getPropertyKeyValue("hrheadPassword1");
	
		
    String id1 = exUtils.getExcelData("AdminModule", 1, 0);	
    getHr_companyid().sendKeys(id1);
   
   String first1 = exUtils.getExcelData("AdminModule", 1, 1);
   getHr_firstname().sendKeys(first1);
   
   String last1 = exUtils.getExcelData("AdminModule", 1, 2);
   getHr_lastname().sendKeys(last1);
   
   String middle1 = exUtils.getExcelData("AdminModule", 1, 3);
   getHr_middlename().sendKeys(middle1);
   
   String contact1 = exUtils.getExcelData("AdminModule", 1, 4);
   getHr_contactno().sendKeys(contact1);
   
   WebElement hrType = getHr_typeDropdown();
   weutils.selectElementInDropdown(hrType, "HR Head");
 
  getHr_email().sendKeys(headUsername1);
  getHr_password().sendKeys(headPassword1);
  getSaveBtn().click();
  weutils.switchToAlertPopupAndAccept(driver, "Successfully");
 
}
}
