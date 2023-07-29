package com.hrm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebdriverUtility;

public class LoginPage extends WebdriverUtility{
	
	//Initialization
      @FindBy(xpath="//input[@name='hr_email']")private WebElement userNameTxtBox;
      
      @FindBy(xpath="//input[@name='hr_password']")private WebElement passWordTxtBox;
      
      @FindBy(id="hr_type")private WebElement hrtypeDrodown;
      
      @FindBy(xpath="//button[.='Sign In']")private WebElement SignInBtn;
     
      //declaration
      public LoginPage(WebDriver driver) {
    	  PageFactory.initElements(driver,this);
      }
     

	//getters method for calling
	public WebElement getUserNameTxtBox() {
		return userNameTxtBox;
	}

	public WebElement getPassWordTxtBox() {
		return passWordTxtBox;
	}

	public WebElement getHrtypeDrodown() {
		return hrtypeDrodown;
	}
	  
    public WebElement getSignInBtn() {
		return SignInBtn;
	}
    public void selectHRType(WebdriverUtility weUtils,String value) {
    	weUtils.selectElementInDropdown(hrtypeDrodown,value);
    }
    
    public void LoginToApp(WebDriver driver, String HeadUserName,String HeadPassword,String Value) {
		WebdriverUtility weutils=new WebdriverUtility();

    	getUserNameTxtBox().sendKeys(HeadUserName);
    	getPassWordTxtBox().sendKeys(HeadPassword);
    	selectElementInDropdown(hrtypeDrodown,Value);
    	SignInBtn.click();
    	  weutils.waitTillPageGetsLoad(driver);
        weutils.switchToAlertPopupAndAccept(driver, "Successfully");
        System.out.println("-------login successfully-----");
    	
    }
    
          
}
