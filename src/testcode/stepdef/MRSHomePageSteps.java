package testcode.stepdef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import openmrs.Utilities.BrowserHelper;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import testcode.MasterFile.Base;
import testcode.enums.ServiceType;
import testcode.pageobject.OpenMRSLoginPage;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MRSHomePageSteps extends Base {

    OpenMRSLoginPage openMRSLoginPage;
    BrowserHelper browserHelper;
    Logger logger;
   // public static WebDriver driver = null;
    String title;

    private SoftAssertions assertions = new SoftAssertions();
    @Before
    public void runDriver() throws Exception {
        run();
        openMRSLoginPage = PageFactory.initElements(driver, OpenMRSLoginPage.class);

    }


    @Given("^I launch the MRH application welcome page$")
    public void iLaunchTheMRHApplicationWelcomePage() throws Throwable {

            openMRSLoginPage.loginToMRSAccount();
        }


    @When("^I find the MRH application web title$")
    public void iFindTheMRHApplicationWebTitle() {

         title = browserHelper.getBrowserTitle(driver);
        System.out.println(title);

    }


    @Then("^I match the web title successfully$")
    public void iMatchTheWebTitleSuccessfully() {
        Assert.assertEquals(title,"Home1");
    }

    @When("^I navigated to Manage Service Types page$")
    public void iNavigatedToManageServiceTypesPage() throws Throwable {

        openMRSLoginPage.navigateManageServiceTypeWindow();
    }

    @Then("^I get the all service list$")
    public void iGetTheAllServiceList(List<ServiceType> serviceTypes) throws Throwable {

        Assert.assertEquals("Desired column is not matching",
                openMRSLoginPage.getListOfServiceTypes().stream().collect(Collectors.toList()).size() == 10,
                serviceTypes.stream().map(columnName -> columnName.getStringValue()).collect(Collectors.toList()).size()
                        == 10);
        System.out.println("List " + openMRSLoginPage.getListOfServiceTypes().stream().collect(Collectors.toList()));
    }


    @After
    public void tearDown(Scenario scenario) {
        try{
            if (scenario.isFailed()) {
                // Take a screenshot...
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
            }
        }
        finally {
            driver.quit();
        }
    }




}
