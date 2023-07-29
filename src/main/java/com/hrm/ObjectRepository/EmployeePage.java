package com.hrm.ObjectRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.ExcelUtility;
import GenericUtilities.IPathConstants;
import GenericUtilities.WebdriverUtility;

public class EmployeePage {

	@FindBy(xpath="//button[contains(.,'Add Employee')]")private WebElement addEmployeeBtn;
	@FindBy(xpath="//input[contains(@type,'search')]")private WebElement searchTxtBox;
	@FindBy(xpath="//td[.='1123']/../descendant::i[@title='Edit Employee']") private WebElement editEmployeeIcon;
    @FindBy(xpath="//td[.='1123']/../descendant::i[@title='Delete Employee']")private WebElement deleteEmployeeIcon;
    @FindBy(xpath="//td[.='1123']/..//a[contains(@title,'Download File')]")private WebElement downloadEmployeeFileIcon;
    
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_companyid']")private WebElement employee_companyid;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_firstname']")private WebElement employee_firstname;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_lastname']")private WebElement employee_lastname;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_middlename']")private WebElement employee_middlename;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='branches_datefrom']")private WebElement branches_datefrom;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='branches_recentdate']")private WebElement branches_recentdate;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//select[@name='employee_department']")private WebElement employee_department;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//select[@name='employee_branches']")private WebElement employee_branches;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_position']")private WebElement employee_position;
    @FindBy(xpath="//h4[.='Add Employee']/ancestor::div[@class='modal-content']/descendant::input[@name='employee_contact']")private WebElement employee_contact;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_sss']")private WebElement employee_sss;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_tin']")private WebElement employee_tin;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_hdmf_pagibig']")private WebElement employee_hdmf;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_gsis']")private WebElement employee_gsis;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_file201']")private WebElement employee_file;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//input[@name='employee_image']")private WebElement employee_image;
    @FindBy(xpath="//form[@action='process/addemployee_process.php']//button[.='Save']")private WebElement Save_button;
    @FindBy(xpath="//tr/td[.='Asset Management Department']")private WebElement verifyEmployeeName;
    


    public EmployeePage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}

	public WebElement getAddEmployeeBtn() {
		return addEmployeeBtn;
	}

	public WebElement getEditEmployeeIcon() {
		return editEmployeeIcon;
	}

	public WebElement getDeleteEmployeeIcon() {
		return deleteEmployeeIcon;
	}

	public WebElement getDownloadEmployeeFileIcon() {
		return downloadEmployeeFileIcon;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getEmployee_companyid() {
		return employee_companyid;
	}

	public WebElement getEmployee_firstname() {
		return employee_firstname;
	}

	public WebElement getEmployee_lastname() {
		return employee_lastname;
	}

	public WebElement getEmployee_middlename() {
		return employee_middlename;
	}

	public WebElement getBranches_datefrom() {
		return branches_datefrom;
	}

	public WebElement getBranches_recentdate() {
		return branches_recentdate;
	}

	public WebElement getEmployee_department() {
		return employee_department;
	}

	public WebElement getEmployee_branches() {
		return employee_branches;
	}

	public WebElement getEmployee_position() {
		return employee_position;
	}

	public WebElement getEmployee_contact() {
		return employee_contact;
	}

	public WebElement getEmployee_sss() {
		return employee_sss;
	}

	public WebElement getEmployee_tin() {
		return employee_tin;
	}

	public WebElement getEmployee_hdmf() {
		return employee_hdmf;
	}

	public WebElement getEmployee_gsis() {
		return employee_gsis;
	}

	public WebElement getEmployee_file() {
		return employee_file;
	}

	public WebElement getEmployee_image() {
		return employee_image;
	}

	public WebElement getSave_button() {
		return Save_button;
	}

	public WebElement getVerifyEmployeeName() {
		return verifyEmployeeName;
	}
	
   public void LogOut(WebDriver driver) {
	   driver.findElement(By.xpath("//b[.='Welcome!,']")).click();
       driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
   }
   
   
   public void deleteEmployee(WebDriver driver) throws EncryptedDocumentException, IOException {
	   WebdriverUtility weutils=new WebdriverUtility();
	   ExcelUtility exUtils= new ExcelUtility();
	      String EmpID =exUtils.getExcelData("employeeData", 1, 0);
       List<WebElement> deleteIcon = driver.findElements(By.xpath("//td[.='"+EmpID+"']/../descendant::i[@title='Delete Employee']"));
       int count = deleteIcon.size();
       for(int i=0;i<count;i++) {
    	    deleteIcon.get(i).click();
            String FirstName =exUtils.getExcelData("employeeData", 1, 1);
 	       String LastName =exUtils.getExcelData("employeeData", 1, 2);
     	  List<WebElement> deletebtn = driver.findElements(By.xpath("//input[@value='"+FirstName+" "+LastName+"']/../..//button[.='Delete']"));
     	 deletebtn.get(i).click(); 
     	weutils.switchToAlertPopupAndAccept(driver, "Successfully");
  	   getSearchTxtBox().sendKeys(EmpID);
  	 deleteIcon = driver.findElements(By.xpath("//td[.='"+EmpID+"']/../descendant::i[@title='Delete Employee']"));
  	count = deleteIcon.size();
  	i--;
       } 
   }
   
   public WebElement deleteEmployeeButton(WebDriver driver,String FirstName,String LastName) {
	 WebElement deleteBtn = driver.findElement(By.xpath("//input[@value='"+FirstName+" "+LastName+"']/../..//button[.='Delete']"));
	  return deleteBtn; 
   }
   
   public boolean verifyEmployee(WebDriver driver) {
	   String text = driver.findElement(By.xpath("//td[.='No matching records found']")).getText();
       if(text.contains("No matching records found")) {
    	 return true;
       }
       else {
    	   return false;
       }
   }
   
  public WebElement downloadEmployeeFileIcon(WebDriver driver,String EmpID) {
	WebElement download = driver.findElement(By.xpath("//td[.='"+EmpID+"']/..//a[contains(@title,'Download File')]"));
	return download;
  }
    
  public void AddEmployee(WebDriver driver) throws EncryptedDocumentException, IOException {
	  WebdriverUtility weutils=new WebdriverUtility();
	  ExcelUtility exUtils=new ExcelUtility();
	  //Fill the required Details
      String EmpID =exUtils.getExcelData("employeeData", 1, 0);
      getEmployee_companyid().sendKeys(EmpID);
       
      String FirstName =exUtils.getExcelData("employeeData", 1, 1);
      getEmployee_firstname().sendKeys(FirstName); 
      
       String LastName =exUtils.getExcelData("employeeData", 1, 2);
       getEmployee_lastname().sendKeys(LastName);
                  
       String MiddleName = exUtils.getExcelData("employeeData", 1, 3);
       getEmployee_middlename().sendKeys(MiddleName);
       
       String branchDateFrom = exUtils.getExcelData("employeeData", 1, 4);
       getBranches_datefrom().sendKeys(branchDateFrom);
       
        String branchrecentDate = exUtils.getExcelData("employeeData", 1, 5);
        getBranches_recentdate().sendKeys(branchrecentDate);
        
        WebElement department = getEmployee_department();
        String corporateName = exUtils.getExcelData("CorporateModule", 1, 0);
        weutils.selectElementInDropdown(department,corporateName);
        
        WebElement branches =getEmployee_branches();
        String branchName = exUtils.getExcelData("BranchModule", 1, 0);
        weutils.selectElementInDropdown(branches,branchName);

        
        String position = exUtils.getExcelData("employeeData", 1, 6);
        getEmployee_position().sendKeys(position);
        
        String contact1 =exUtils.getExcelData("employeeData", 1, 7);          
        getEmployee_contact().sendKeys(contact1);
        
        String sss = exUtils.getExcelData("employeeData", 1, 8);
        getEmployee_sss().sendKeys(sss);
        
        String tin = exUtils.getExcelData("employeeData", 1, 9);
        getEmployee_tin().sendKeys(tin);
        
        String hdmf =exUtils.getExcelData("employeeData", 1, 10);
        getEmployee_hdmf().sendKeys(hdmf);
        
        String gsis = exUtils.getExcelData("employeeData", 1, 11);
        getEmployee_gsis().sendKeys(gsis);
        
        File fis11 =new File(IPathConstants.employeeDocument);
       String path = fis11.getAbsolutePath();
       getEmployee_file().sendKeys(path);     
       
       File img =new File(IPathConstants.employeeImage);
       String path1 = img.getAbsolutePath();          
       getEmployee_image().sendKeys(path1);
       
       //Save the details of the employee
       getSave_button().click();
       weutils.waitForAlertPopup(driver);
       weutils.switchToAlertPopupAndAccept(driver, "Successfully");
       System.out.println("Employee Added Successfully");
  }
  public void searchEmployee() throws EncryptedDocumentException, IOException {
	  ExcelUtility exUtils= new ExcelUtility();
      String EmpID =exUtils.getExcelData("employeeData", 1, 0);
	   getSearchTxtBox().sendKeys(EmpID);
	   }
  public void downloadEmployee(WebDriver driver ) throws EncryptedDocumentException, IOException {
	  
	  ExcelUtility exUtils= new ExcelUtility();
      String EmpID =exUtils.getExcelData("employeeData", 1, 0);
      downloadEmployeeFileIcon(driver, EmpID).click(); 
  }
 
   public void deleteEmployeeBtn(WebDriver driver ) throws EncryptedDocumentException, IOException {
		  ExcelUtility exUtils= new ExcelUtility();
           String FirstName =exUtils.getExcelData("employeeData", 1, 1);
	       String LastName =exUtils.getExcelData("employeeData", 1, 2);
     	   deleteEmployeeButton(driver, FirstName, LastName).click();
   }
}
