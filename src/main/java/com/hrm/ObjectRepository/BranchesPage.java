package com.hrm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchesPage {

	@FindBy(xpath="//button[contains(.,'Add Branches')]")private WebElement addBranchBtn;
	@FindBy(xpath="//input[contains(@type,'search')]")private WebElement searchTxtBox;
	@FindBy(xpath="//td[.='Villasis Branch']/following-sibling::td//button[.='Edit']")private WebElement EditBranch;
	@FindBy(xpath="//td[.='Villasis Branch']/following-sibling::td//button[.='Delete']")private WebElement deleteBranch;
	@FindBy(xpath="//input[@name='branches_name' and @placeholder='Branches Name']")private WebElement addBranchTxtBox;
    @FindBy(xpath="//button[.='Save']")private WebElement addBranchesSaveBtn;    
    @FindBy(xpath="//tr/td[.='Asset Management Department']")private WebElement verifyBranchName;
    @FindBy(xpath="//form[@action='process/editbranches_process.php']/following-sibling::div/input[@name='branches_name' and @value='Asset Management Department']")private WebElement editBranchTxtBox;
	@FindBy(xpath="//input[@name='branches_name' and @value='Asset Management Department']/parent::div/following-sibling::div/button[.='Update']")private WebElement Updatebutton;
	@FindBy(xpath="//input[@name='branches_name' and @value='nnlkmlkmlkmklkmkm']/parent::div/following-sibling::div/button[.='Delete']")private WebElement DeleteButton;
	
	
    
	public BranchesPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	public WebElement getAddBranchBtn() {
		return addBranchBtn;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getEditBranch() {
		return EditBranch;
	}

	public WebElement getDeleteBranch() {
		return deleteBranch;
	}

	public WebElement getAddBranchTxtBox() {
		return addBranchTxtBox;
	}

	public WebElement getAddBranchesSaveBtn() {
		return addBranchesSaveBtn;
	}

	public boolean getVerifyBranchName(WebDriver driver,String BranchName) {
		
		 String verifyBranchName = driver.findElement(By.xpath("//tr/td[.='"+BranchName+"']")).getText();
			
		if(BranchName.contains(verifyBranchName)) {
			return true;
		}
		else {
			return false;
		}
			
		}

	public WebElement getEditBranchTxtBox() {
		return editBranchTxtBox;
	}

	public WebElement getUpdatebutton() {
		return Updatebutton;
	}

	public WebElement getDeleteButton() {
		return DeleteButton;
	}
	 public void LogOut(WebDriver driver) {
		   driver.findElement(By.xpath("//b[.='Welcome!,']")).click();
	       driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
	   }	
}
