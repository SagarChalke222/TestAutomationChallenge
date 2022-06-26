package testcases;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.logging.Level;

import base.BaseTest;

//We can create any number of test cases and run all at a time using test runner.
public class TestChallengeSuit extends BaseTest
{

	
	@Test(dataProvider="testdata")
	public static void loginTest(String usrname, String passwrd) throws InterruptedException, IOException
	{
		//This test case validates login feature	
		driver.findElement(By.xpath(loc.getProperty("myaccount"))).click();
		Thread.sleep(3000);
		String title2= driver.getTitle();
		System.out.println(title2);
		Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("emailbox"))).sendKeys(usrname);
		System.out.println(usrname);
		driver.findElement(By.xpath(loc.getProperty("passbox"))).sendKeys(passwrd);
		driver.findElement(By.xpath(loc.getProperty("loginbutton"))).click();
		System.out.println("success");
		String title4="sagarchalke233@gmail.com";
		Assert.assertEquals(usrname, title4);
		
	}
	
	@Test
	public void hyperlinktest() throws InterruptedException, IOException
	{
		//This test case fetches all hyper links from a web page.
		String linkUrl="https://www.mytheresa.com/en-de/men.html";
		driver.navigate().to(linkUrl);
		Thread.sleep(3000);
		WebElement frame1= driver.findElement(By.id("privacy-iframe"));// to handle frames
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath(loc.getProperty("popup"))).click();//closing the popup box 
		Thread.sleep(3000);
		driver.switchTo().parentFrame();
		List<WebElement> alltags= driver.findElements(By.tagName("a"));// saving all hyperlinks in list
		System.out.println("Total tags are: " + alltags.size());
		for (int i=0;i<10;i++) //(i<alltags.size) can also be used by as hyperlink count is 1886. I have used a random number of 10.
		{
			String errortext="javascript:void(0);";
			if(!alltags.get(i).getAttribute("href").equalsIgnoreCase(errortext))
			{
			System.out.println("Links on the page are: "+ alltags.get(i).getAttribute("href"));
			String url2=alltags.get(i).getAttribute("href");
			verifyLinkActive(url2);
			}
		}
				
	}
	
	public static void verifyLinkActive(String linkUrl) throws IOException
	{
		//This method validates if a URL is giving correct response & captures it responses.
		URL url = new URL(linkUrl);
		HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
		httpURLConnect.setConnectTimeout(3000);
		httpURLConnect.connect();
		if(httpURLConnect.getResponseCode()==200)
		{
			System.out.println(linkUrl+ " - " + httpURLConnect.getResponseMessage());
		}
		else if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
		{
			System.out.println(linkUrl+ " - " + httpURLConnect.getResponseMessage()+ " - "+ HttpURLConnection.HTTP_NOT_FOUND);
		}
	}
	
	/*@Test
	public static void consolejavascript() throws InterruptedException
	{
		String linkUrl="https://www.mytheresa.com/en-de/men.html";
		driver.navigate().to(linkUrl);
		Thread.sleep(3000);
		WebElement frame1= driver.findElement(By.id("privacy-iframe"));// to handle frames
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath(loc.getProperty("popup"))).click();//closing the popup box 
		Thread.sleep(3000);
		driver.switchTo().parentFrame();		
		
		Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
	      for (String s : logtyp) {
	         System.out.println(logtyp);
	      }
	      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	      List<LogEntry> lg = logEntries.filter(Level.ALL);
	      for(LogEntry logEntry : lg) {
	         System.out.println(logEntry);
	      }
	      driver.quit();
	}*/
	
	
	
	
	
	@DataProvider(name="testdata")//This is data provider which can provide email & password for login.
	public Object[][] tData()
	{
		return new Object[] []
		{
			{"sagarchalke2@gmail.com","Airo222"},
			{"sagarchalke233@gmail.com","Airoli@222"}
		};
	}
}
