package createPojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class mohitP  {
@Test
public void nothing() {
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	WebDriverManager.edgedriver().setup();
	WebDriver driver= new ChromeDriver();
	System.out.println("mohit");
}
}
