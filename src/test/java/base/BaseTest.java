package base;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{

	public static Properties prop = new Properties();
	public static WebDriver driver;
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader lr;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		//This method is focused on centralizing web drivers & test url.
		//This method makes use of property file to understand selected browser & URLs based on which drivers are selected. 
		if(driver==null)
		{
			FileReader fr= new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr1= new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			this.driver= new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
			
		}	
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			this.driver= new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
		
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			this.driver= new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
			driver.manage().window().maximize();
			
		}
		
		
		}


}
