package GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	
	
	JavascriptExecutor js;
	/**
	 * 
	 * @param driver
	 */
	
	public void javaScriptUtility(WebDriver driver) {
		js=(JavascriptExecutor) driver;
	}
	/**
	 * 
	 */
	
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,-document.body.scrollHieght)");
	}
	/**
	 * 
	 * @param element
	 * @param data
	 */
	
	public void scrollTillElement(WebElement element) {
		js.executeScript("argument[0].scrollIntoView()",element);
	}
	/**
	 * 
	 */
	
	public void scrollDown() {
		js.executeScript("window.scrollBy(0,document.body.scrollHieght)");
	}
	/**
	 * 
	 * @param url
	 */
	public void lunchApplication(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}
	/**
	 * 
	 * @param element
	 * @param data
	 */
	public void sendKeys(WebElement element, String data) {
		js.executeScript("argument[0].value=argument[1]",element,data);
	}
	/**
	 * 
	 * @param element
	 */
      public void click(WebElement element) {
    	  js.executeScript("argument[0].click()", element);
      }
      /**
       * 
       */
      public void clickElementByID() {
    	  js.executeScript("document.getElementById('elementId').click()");
      }
      /**
       * 
       * @param element
       * @return
       */
      public String getTheText(WebElement element) {
    	 String textFieldValue = (String) js.executeScript("return arguments[0].value;", element);
    	 return textFieldValue;
      }
      /**
       * 
       * @return
       */
      public String getUrlOfCurrentPage()
      {
    	  
    	 String url = (String) js.executeScript("return window.location.href");
    	  return url;
      }
      /**
       * 
       * @return
       */
      
      public String getTitleOfCurrentPage()
      {
    	  String title = (String)  js.executeScript("return document.title");
    	  return title;
      }
}