package GenericUtilities;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.hrm.ObjectRepository.HomePage;
import com.hrm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	DataBaseUtility DbUtils=new DataBaseUtility();
	LoginPage loginPage=new LoginPage(driver);
	WebdriverUtility weUtils=new WebdriverUtility();
	FileUtilities fiUtils=new FileUtilities();
	
	//RestAssured
public 	RestAssuredLibrary resLib= new RestAssuredLibrary();
public 	RequestSpecification reqB;
public ResponseSpecification resB;
/**
 * connection to database
 * @throws SQLException
 */
@BeforeSuite
public void connectDataBase() throws SQLException   {
	DbUtils.EstablishDataBaseConnection();
	
	reqB=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
			.setContentType(ContentType.JSON).build();
	
	resB=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	
}

@AfterSuite
public void closeDataBase() throws SQLException {
	DbUtils.closeDataBaseConnection();
}
//@Parameters("BROWSER")	
@BeforeClass//(groups= {"smokeTest","RegressionTest"})
public void launchBrowser() throws IOException {
	 {
		 WebDriverManager.chromedriver().setup();
		 WebDriverManager.firefoxdriver().setup();
		 WebDriverManager.edgedriver().setup();
        String BROWSER=fiUtils.getPropertyKeyValue("browser");		 
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")){
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
	 }
	 sdriver=driver;
}
@AfterClass(groups= {"smokeTest","RegressionTest"})
public void closeBrowser() {
	driver.quit();
}


@BeforeMethod(groups= {"smokeTest","RegressionTest"})
public void login() throws IOException {
	//fetch data from Properties file
	String url = fiUtils.getPropertyKeyValue("url");
	String headUsername = fiUtils.getPropertyKeyValue("hrheadUsername");
	String headPassword = fiUtils.getPropertyKeyValue("hrheadPassword");
	String hrType=fiUtils.getPropertyKeyValue("hrHeadType");
 
	driver.get(url);
	weUtils.maximizeWindow(driver);
	 weUtils.waitTillPageGetsLoad(driver);
	 LoginPage loginPage=new LoginPage(driver);
	 loginPage.LoginToApp(driver,headUsername, headPassword, hrType);
}


@AfterMethod(groups= {"smokeTest","RegressionTest"})
public void logout() {
HomePage homePage =new HomePage(driver);
homePage.LogOut(driver);
}
	
}
