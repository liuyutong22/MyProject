package taobao.mytest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Driver;
import java.util.Random;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

import common.DriverController;
import common.MainController;
import model.Item;
import xpath.Taobao_Xpath;
 
public class MainMethodTest {
	static DriverController driver;
	MainController main = new MainController(null, null);
	Item item = new Item();
	testdata Testdata = new testdata();
	public String[] username;
	public String[] password;
	@SuppressWarnings("static-access")
	@Before
	public void beforeMethod() throws IOException{
		driver.startDriver();
	}
	
	@Test
	public void testTest() throws Exception {
		//login();
	}
	@RunWith(DataDrivenTestRunner.class)
	 public class testdata {
		
	@DataLoader(filePaths={"testData.csv"},loaderType=LoaderType.CSV,writeData=false)
	 public class DataLoadderFilePathsmytest{
	@Test
	 public void simplTestMethod(@Param(name="username")String username, @Param(name="password")String password){
		   }
	    }
	}
		
	
	@After
	public void afterMethod(){
		driver.quit();
	}
	
	public void login(String username,String password){
		DriverController.webDriver.findElement(By.xpath(Taobao_Xpath.LOGIN_WINDOW_XPATH.getXpath())).click();
		WebDriverWait wait = new WebDriverWait(driver.webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Taobao_Xpath.CUSTOMER_LOGIN_XPATH.getXpath())));
        driver.webDriver.findElement(By.xpath(Taobao_Xpath.CUSTOMER_LOGIN_XPATH.getXpath())).click();
        driver.webDriver.findElement(By.xpath(Taobao_Xpath.INPUT_USERNAME_XPATH.getXpath())).sendKeys(username);
        driver.webDriver.findElement(By.xpath(Taobao_Xpath.INPUT_PW_XPATH.getXpath())).sendKeys(password);
        driver.webDriver.findElement(By.xpath(Taobao_Xpath.LOGIN_BUTTON_XPATH.getXpath())).click();	
	}
	//购物车登陆
	/*public void cart() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver.webDriver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Taobao_Xpath.ENTER_CART_XPATH.getXpath())));
        driver.webDriver.findElement(By.xpath(Taobao_Xpath.ENTER_CART_XPATH.getXpath())).click();
        driver.webDriver.findElement(By.xpath(Taobao_Xpath.CUSTOMER_LOGIN_XPATH.getXpath())).click();
		String username = "15164031917";
		String password = "yutongLiu";
		driver.webDriver.findElement(By.xpath(Taobao_Xpath.INPUT_USERNAME_XPATH.getXpath())).sendKeys(username);
		driver.webDriver.findElement(By.xpath(Taobao_Xpath.INPUT_PW_XPATH.getXpath())).sendKeys(password);
		action();
        driver.webDriver.findElement(By.xpath(Taobao_Xpath.LOGIN_BUTTON_XPATH.getXpath())).click();	
        Thread.sleep(5000);
	}
	*/
	//拖动滚动条
     @SuppressWarnings("null")
	public void action() throws InterruptedException{
    	 WebDriverWait wait = new WebDriverWait(driver.webDriver,10);
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Taobao_Xpath.SLIDE_BUTTON_XPATH.getXpath())));
    	 WebElement element = driver.webDriver.findElement(By.xpath(Taobao_Xpath.SLIDE_BUTTON_XPATH.getXpath()));
    	 int xDis = 358;
    	 int moveX = new Random().nextInt(8) - 5;
         int moveY = 1;
         Actions action = new Actions(driver.webDriver);
         new Actions(driver.webDriver).clickAndHold(element).perform();
         Thread.sleep(200);
         action.moveToElement(element, moveX, moveY).perform();
         long d1 = Math.round(xDis*0.7);
         long d2 = Math.round(xDis*0.2);
         long d3 = Math.round(xDis*0.1);
         action.moveByOffset((int)d1, 1);
         Thread.sleep(400);
         action.moveByOffset((int)d2, 1);
         Thread.sleep(400);
         action.moveByOffset((int)d3, 1);
         action.moveByOffset(0, 1);
         Thread.sleep(1000);
         action.release(element);
         Action actions = action.build();
         actions.perform();
    	 Thread.sleep(2000);
    	 /*action.clickAndHold(element);
    	 action.moveByOffset(258, 0).build();
    	 action.perform();*/
		/*clickAndHold.driver.webDriver.findElement(By.xpath(Taobao_Xpath.SLIDE_BUTTON_XPATH.getXpath())).perform();
		action.clickAndHold(element.moveByOffset(location.x+99,location.y).release().perform();
		
        String name = driver.webDriver.findElement(By.xpath(Taobao_Xpath.CHECK_CART_ITEMNAME_XPATH.getXpath())).getText();
        item.setItemname(name);
        System.out.println(item.getItemname());
        
        String size = driver.webDriver.findElement(By.xpath(Taobao_Xpath.CHECK_CART_SIZE_XPATH.getXpath())).getText(); 
        item.setItemsize(size);
        System.out.println(item.getItemsize());
        
        String color = driver.webDriver.findElement(By.xpath(Taobao_Xpath.CHECK_CART_COLOR_XPATH.getXpath())).getText();
        item.setItemcolor(color);
        System.out.println(item.getItemcolor());
        
        String qty = driver.webDriver.findElement(By.xpath(Taobao_Xpath.CHECK_CART_QTY_XPATH.getXpath())).getText();
        item.setItemqty(qty);
        System.out.println(item.getItemqty());
        
        String pay = driver.webDriver.findElement(By.xpath(Taobao_Xpath.CHECK_CART_PAY_XPATH.getXpath())).getText();
        item.setItempay(pay);
        System.out.println(item.getItempay());*/
	}
}
