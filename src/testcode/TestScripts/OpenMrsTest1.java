package testcode.TestScripts;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testcode.MasterFile.Base;
import testcode.pageobject.OpenMRSLoginPage;

import java.util.concurrent.TimeUnit;


public class OpenMrsTest1 extends Base {

	OpenMRSLoginPage openMRSLoginPage;
	Logger logger;
	WebDriver webDriver;

	@BeforeTest
	public void M1() {

		logger = Logger.getLogger("EuroStarTest1");
		PropertyConfigurator.configure("log4j.properties");

		openMRSLoginPage = PageFactory.initElements(driver, OpenMRSLoginPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		try {
			openMRSLoginPage.loginToOpenMRSAccount();
			logger.info("Launched OpenMRS Application!!");
		}

		catch (Exception e) {
			e.getMessage();
			logger.error(e);
		}
	}

	@Test
	public void webTitle() throws Exception {

		String expectedTitle = "OpenMRS - Home";
		logger.info("Expected Title: " + expectedTitle);

		String actualtitle = driver.getTitle();
		logger.info("Actual Title: " + actualtitle);

		Assert.assertEquals(actualtitle, expectedTitle, "Title mismatched");
		logger.info("Expected matched with Actual so test is passed!!");
	}

	@Test
	public void clickOnTest(){
		openMRSLoginPage.navigateManageServiceTypeWindow();
		openMRSLoginPage.getListValue(openMRSLoginPage.getListApp(),"Gynecology");
	}

	@Test
	public void findServiceStartsWith(){

		openMRSLoginPage.getServiceStartsWith("G");
	}

	@Test
	public void findServiceInUpperCase(){
		openMRSLoginPage.letsCode1();
	}

	@Test
	public void findServiceVerify() throws Throwable {
		openMRSLoginPage.letsCode1();
	}

















	@AfterTest
	public void afterTest() {

		driver.close();
		logger.info("Close the browser!!");

	}
}
