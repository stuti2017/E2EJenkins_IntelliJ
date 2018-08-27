package testcode.pageobject;

import openmrs.Utilities.GenericHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testcode.locators.OpenMRSLoginLocators;

import java.util.List;
import java.util.stream.Collectors;


public class OpenMRSLoginPage{
    Logger logger;
    WebDriver webDriver;


    public OpenMRSLoginPage(WebDriver driver) {
        this.webDriver = driver;

        logger = Logger.getLogger("OpenMRSLoginPage");
        PropertyConfigurator.configure("log4j.properties");
    }

    @FindBy(css = OpenMRSLoginLocators.USER_NAME)
    private WebElement emailTextField;

    @FindBy(css = OpenMRSLoginLocators.PASSWORD)
    private WebElement passwordTextField;

    @FindBy(xpath = OpenMRSLoginLocators.IWard)
    private WebElement iward;

    @FindBy(css = OpenMRSLoginLocators.LOG_IN_BUTTON)
    private WebElement signInButton;

    @FindBy(css = OpenMRSLoginLocators.APPOINTMENTS)
    private WebElement app;

    @FindBy(xpath = OpenMRSLoginLocators.APPOINTMENT_SCHEDULE_LINK)
    private WebElement appointmentSchedule;

    @FindBy(xpath = OpenMRSLoginLocators.MANAGE_SERVICE_TYPE)
    private WebElement manageServiceType;

    @FindBy(xpath = OpenMRSLoginLocators.APPOINTMENT_TYPE)
    private WebElement appType;

    @FindBy(css = OpenMRSLoginLocators.EDIT)
    private WebElement edit;

    @FindBy(xpath = OpenMRSLoginLocators.APP_TYPE_LIST)
    private List<WebElement> appTypeList;

    @FindBy(xpath = OpenMRSLoginLocators.MST_TYPE)
    private List<WebElement> mstTypeList;

    @FindBy(xpath = OpenMRSLoginLocators.MST_DURATION)
    private List<WebElement> mstDurationList;

    @FindBy(xpath = OpenMRSLoginLocators.MANAGE_SERVICE_TYPE_NAME)
    private List<WebElement> manageServiceTypeName;

    public List<WebElement> getListApp() {
        return appTypeList;
    }

    public List<WebElement> getListOfServiceTypes() {
        return manageServiceTypeName;
    }

    public void loginToMRSAccount() {
        logger.info("Click on Login link!!");
        emailTextField.sendKeys("Admin");
        logger.info("Enter the user name id");
        passwordTextField.sendKeys("Admin123");
        logger.info("Enter the password");
        iward.click();
        signInButton.click();
        logger.info("Click on submit button");
    }

    public void loginToOpenMRSAccount() {
        logger.info("Click on Login link!!");
        emailTextField.sendKeys("Admin");
        logger.info("Enter the user name id");
        passwordTextField.sendKeys("Admin123");
        logger.info("Enter the password");
        iward.click();
        signInButton.click();
        logger.info("Click on submit button");

        appointmentSchedule.click();
        manageServiceType.click();

    }


    public void navigateManageServiceTypeWindow() {
        appointmentSchedule.click();
        manageServiceType.click();

    }

    public void getListValue(List<WebElement> listInput, String desiredValue) {

        for (WebElement element : listInput) {
            if (element.getText().equals(desiredValue)) {
                logger.info(element.getText().equals(desiredValue));
                logger.info(desiredValue + " present in App Type");
                System.out.println("pass");
            }

        }
    }

    public void getServiceStartsWith(String desiredFilter) {

        long count = mstTypeList.stream().filter(msType -> msType.getText().startsWith(desiredFilter)).count();
        logger.info("Service Starts with " + desiredFilter + " = " + count);
    }

    public void getServiceInUpperCase() {

        mstTypeList.stream().map(msType -> msType.getText().toUpperCase()).forEach(System.out::println);

    }

    public void getServiceAndCollect() {

        List<String> names = mstTypeList.stream().map(n -> n.getText()).collect(Collectors.toList());

        for (String ww : names) {

            if (ww.equalsIgnoreCase("Gynecology")) {
                for (WebElement duration : mstDurationList) {
                    System.out.println("Yes" + duration.getText());
                    edit.click();
                }
            }
        }
    }

    public void getDurationBasedOnServiceType(){

        String duration = GenericHelper.getValueFromListBasedOnDesiredMatch(mstTypeList, mstDurationList, "Neurology");

        System.out.println(duration);

    }

    public void letsCode1(){

        List<WebElement> list = webDriver.findElements(By.xpath("//ul[2]/li/a"));

        List<String> filtered = list.stream().map(n->n.getText().trim()).collect(Collectors.toList());

        List<WebElement> filtered1 = list.stream().filter(n->n.getText().equalsIgnoreCase("JAVA CORE")).collect(Collectors.toList());

                //.anyMatch().map(n->n.getText().trim()).collect(Collectors.toList()).forEach(String::equalsIgnoreCase)).;

                //.filter(string -> string.getText().contentEquals("Gynecology"));
        System.out.println("filtered " + filtered);

    }

}


