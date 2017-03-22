package wrappers;

import java.io.File;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.SysexMessage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
	int i=1;
	
	
	public void invokeApp(String browser, String url) throws Exception {
		try {
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}

			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("The Browser "+ browser +" is launched");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			System.err.println("Browser does not launched");
		}
		finally{
		takeSnap();
		}

	}

	public void enterById(String idValue, String data) throws Exception {
		
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The Text Field "+ idValue +" is entered with  "+ data );
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+idValue+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) throws Exception {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The Text Field "+nameValue+"  is entered with "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Testcase stopped");
			//System.err.println("Textfield "+nameValue+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
			takeSnap();
			}
		

	}

	public void enterByXpath(String xpathValue, String data) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The Text Field "+xpathValue+"  is entered with "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+xpathValue+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
		
	}

	public boolean verifyTitle(String title) {
		
		boolean breturn= false;
		// TODO Auto-generated method stub
		try{
			String t=driver.getTitle();
	    	if(t.equals(title)){
	    		System.out.println();
	    	}
	    	breturn = true;
		}					
			
			  catch (WebDriverException e) {
			// TODO Auto-generated catch block
		 
			  	
			System.err.println("Title is  not verified");
		}
		
		return breturn;
		
		
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		String v=driver.findElementById(id).getText();
		if(v.equals(text))
			System.out.println("Text verified");
		else
			System.out.println("Text not verified");
		

	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String s=driver.findElementByXPath(xpath).getText();
		if(s.equals(text))
			System.out.println("Text verified");
		else
			System.out.println("Text not verified");

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String l=driver.findElementByXPath(xpath).getText();
		if(l.contains(text))
			System.out.println("Text contains "+text);
		else
			System.out.println("Text does not contains "+text);
			

	}

	public void clickById(String id) throws Exception {
		// TODO Auto-generated method stub
		try{
        driver.findElementById(id).click();
        System.out.println("The button "+ id + " is clicked");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+id+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
        
	}

	public void clickByClassName(String classVal) throws Exception {
		try{
		driver.findElementByClassName(classVal).click();
		System.out.println("The button "+ classVal + " is clicked");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+classVal+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
		
		
	}

	public void clickByName(String name) throws Exception {
		// TODO Auto-generated method stub
		try{
		driver.findElementByName(name).click();
		System.out.println("The button "+ name + " is clicked");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+name+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
		

	}

	public void clickByLink(String name) throws Exception {
		// TODO Auto-generated method stub
		driver.findElementByLinkText(name).click();
		System.out.println("The button "+ name + " is clicked");
		takeSnap();
	}

	public void clickByLinkNoSnap(String name) throws Exception {
		// TODO Auto-generated method stub
		try{
		driver.findElementByLinkText(name).click();
		System.out.println("The button "+ name + " is clicked");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+name+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
		
	}

	public void clickByXpath(String xpathVal) throws Exception {
		// TODO Auto-generated method stub
		try{
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The button "+ xpathVal + " is clicked");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+xpathVal+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
		
		
		

	}

	public void clickByXpathNoSnap(String xpathVal) throws Exception {
		// TODO Auto-generated method stub
		try{
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The button "+ xpathVal + " is clicked");
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+xpathVal+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
				
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String s="No text available";
		try
		{
		String st=driver.findElementById(idVal).getText();
		System.out.println("The textfield in Id  "+idVal+" is "+s);
		s=st;
		}
		
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+idVal+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}
		return s;
		
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String st="No text available";
		try
		{
		String str=driver.findElementByXPath(xpathVal).getText();
		System.out.println("The textfield in xpath "+xpathVal+" is "+str);
		st=str;	
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+xpathVal+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		
		finally{
		takeSnap();
		}
		return st;
	}

	public void selectVisibileTextById(String id, String value)
			throws Exception {
				// TODO Auto-generated method stub
		try{
		WebElement d1=driver.findElementById(id);
		Select drop1=new Select(d1);
		drop1.selectByVisibleText(value);
		System.out.println("The dropdown option "+value+" is chosed");
		}

		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.err.println("Textfield "+value+" could not found");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser could not be interacted");
		}
		finally{
		takeSnap();
		}

	}

	public void selectIndexById(String id, int value) throws Exception {
		// TODO Auto-generated method stub
		WebElement we=driver.findElementById(id);
		Select c=new Select(we);
		c.selectByIndex(value);
		System.out.println("The dropdown option "+value+" is chosed");
		takeSnap();
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		
		try{
			Set<String> w= driver.getWindowHandles();
		      
			for (String wnew : w)
		       {
				driver.switchTo().window(wnew);
				break;
			   }
			}
			catch(Exception e)
			{
			System.err.println("The window could not be switched to the first window");
			}
	      //String t=driver.getTitle();
	      //System.out.println("The title of the window is "+t);
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try{
		Set<String> w= driver.getWindowHandles();
	       for (String wnew : w)
	       {
			driver.switchTo().window(wnew);
		   }
		}
		catch(Exception e)
		{
		System.err.println("The window could not be switched to the first window");
		}
	       String r=driver.getTitle();
	       System.out.println("The title of the Window is "+r);
	}

	
	public void acceptAlert() {
		// TODO Auto-generated method stub
		Alert a=driver.switchTo().alert();
	    a.accept();
        System.out.println("Alert Accepted");
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		Alert a=driver.switchTo().alert();
	    a.dismiss();
	    System.out.println("Alert Dismissed");
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		Alert a=driver.switchTo().alert();
		String str=a.getText();
		System.out.println("The alerted text is "+str);
			
		return str;
	}

	public long takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dec = new File("./snaps/snap" +i+ ".jpg");
		try {
			FileUtils.copyFile(src, dec);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Copying Error");
		}
		i++;
		return 0;
	}

	public void closeBrowser() {
		try
		{
		driver.close();
		System.out.println("The Browser Closed");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browser does not closed");
		}

	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try
		{
		driver.quit();
		System.out.println("All Browsers are Closed");
		}
		catch(WebDriverException e)
		{
			System.err.println("Browsers are not closed");
		}

	}


}
