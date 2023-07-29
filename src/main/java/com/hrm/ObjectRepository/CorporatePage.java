package com.hrm.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.ExcelUtility;
import GenericUtilities.WebdriverUtility;

public class CorporatePage {

	@FindBy(xpath="//button[contains(.,'Add Corporate')]")private WebElement addCorporateBtn;
	@FindBy(xpath="//input[contains(@type,'search')]")private WebElement searchTxtBox;
	@FindBy(xpath="//input[@name='corporate_name' and @placeholder='Corporate Name']")private WebElement addCorporateTxtBox;
	@FindBy(xpath="//button[.='Save']")private WebElement addCorporateSaveBtn;
	
    
	public CorporatePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	public WebElement getAddCorporateBtn() {
		return addCorporateBtn;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public void setSearchTxtBox(WebElement searchTxtBox) {
		this.searchTxtBox = searchTxtBox;
	}

	public WebElement getAddCorporateTxtBox() {
		return addCorporateTxtBox;
	}

	public WebElement getAddCorporateSaveBtn() {
		return addCorporateSaveBtn;
	}

	
	public WebElement getEditCorporate(WebDriver driver,String CorporateName) {
		
	   WebElement editCorporate = driver.findElement(By.xpath("//td[.='"+CorporateName+"']/following-sibling::td//button[.='Edit']"));
		
	   return editCorporate;
		
	}
	
	public WebElement getDeleteCorporate(WebDriver driver,String CorporateName) {
		
		WebElement deleteCorporate = driver.findElement(By.xpath("//td[.='"+CorporateName+"']/following-sibling::td//button[.='Delete']"));
			
		return deleteCorporate;
			
		}
	
	public boolean getVerifyCorporateName(WebDriver driver,String CorporateName) {
		
		 String verifyCorporateName = driver.findElement(By.xpath("//tr/td[.='"+CorporateName+"']")).getText();
			
		if(CorporateName.contains(verifyCorporateName)) {
			return true;
		}
		else {
			return false;
		}
			
		}
	
	public WebElement getEditCorporateTxtBox(WebDriver driver,String CorporateName) {
		
		WebElement editCorporateTxtBox = driver.findElement(By.xpath("//form[@action='process/editcorporate_process.php']/following-sibling::div/input[@name='corporate_name' and @value='"+CorporateName+"']"));
			
		return editCorporateTxtBox;
			
		}
	
    public WebElement getUpdateCorporateBtn(WebDriver driver,String CorporateName) {
		
		WebElement updateCorporateTxtBox = driver.findElement(By.xpath("//input[@name='corporate_name' and @value='"+CorporateName+"']/parent::div/following-sibling::div/button[.='Update']"));
			
		return updateCorporateTxtBox;
			
		}

    public WebElement getDeleteCorporateBtn(WebDriver driver,String CorporateName) {
	
	    WebElement deleteCorporateBtn = driver.findElement(By.xpath("//input[@name='corporate_name' and @value='"+CorporateName+"']/parent::div/following-sibling::div/button[.='Delete']"));
		
	    return deleteCorporateBtn;
		
	}
    public void LogOut(WebDriver driver) {
 	   driver.findElement(By.xpath("//b[.='Welcome!,']")).click();
        driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
    }
    public void addCorporate(WebDriver driver) throws EncryptedDocumentException, IOException {
    	ExcelUtility exUtils=new ExcelUtility();
    	WebdriverUtility weutils=new WebdriverUtility();
    	  String corporateName = exUtils.getExcelData("CorporateModule",1, 1);
         getAddCorporateTxtBox().sendKeys(corporateName);
         getAddCorporateSaveBtn().click();
          weutils.switchToAlertPopupAndAccept(driver,"Successfully");
          getSearchTxtBox().sendKeys(corporateName);
          if(getVerifyCorporateName(driver, corporateName)) {
        	  System.out.println("Corporate is added");
          }else {
        	  System.out.println("Corporate is not added");
          }
    }
     public void searchCorporateName() throws EncryptedDocumentException, IOException {
     	ExcelUtility exUtils=new ExcelUtility();

    	  String corporateName = exUtils.getExcelData("CorporateModule",1, 1);
  	 getSearchTxtBox().sendKeys(corporateName);
     }
     public void EditCorporateName(WebDriver driver) throws EncryptedDocumentException, IOException {
      ExcelUtility exUtils=new ExcelUtility();
  	WebdriverUtility weutils=new WebdriverUtility();

   	  String corporateName = exUtils.getExcelData("CorporateModule",1, 1);
   	  getEditCorporate(driver, corporateName).click();
      String newCorporateName = exUtils.getExcelData("CorporateModule",1,2);
   	  getEditCorporateTxtBox(driver, corporateName).clear();
   	 getEditCorporateTxtBox(driver, corporateName).sendKeys(newCorporateName);
     getUpdateCorporateBtn(driver, corporateName).click();
     weutils.switchToAlertPopupAndAccept(driver, "Successfully");
 
     }
    
}

