package flipKartTesting.implementation;

import flipKartTesting.pages.DriverSetup;
import flipKartTesting.pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class A_LoginImp extends DriverSetup {

    @Test
    public void a_basicLogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        String ActualTitle = prop.getProperty("TitlePage");
        String ExpectedTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle,ExpectedTitle);
        LoginPage loginObj = new LoginPage(driver);
        action.moveToElement(loginObj.navigationLoginLink()).build().perform();
        Thread.sleep(2000);
        loginObj.loginLink().click();
        loginObj.userName().clear();
        loginObj.userName().sendKeys(prop.getProperty("UserName"));
        loginObj.continueButton().click();
        loginObj.password().clear();
        loginObj.password().sendKeys(prop.getProperty("Password"));
        loginObj.login().click();
        String ActualTitle1 = prop.getProperty("TitlePage");
        String ExpectedTitle2 = driver.getTitle();
        Assert.assertEquals(ActualTitle1,ExpectedTitle2);
        Thread.sleep(10000);
    }

    public void negativeLogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        String ActualTitle = prop.getProperty("TitlePage");
        String ExpectedTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle,ExpectedTitle);
        LoginPage loginObj = new LoginPage(driver);
        action.moveToElement(loginObj.navigationLoginLink()).build().perform();
        Thread.sleep(2000);
        loginObj.loginLink().click();
        loginObj.userName().clear();
        loginObj.userName().sendKeys(prop.getProperty("UserName"));
        loginObj.continueButton().click();
        loginObj.password().clear();
        loginObj.password().sendKeys(prop.getProperty("NegativePassword"));
        loginObj.login().click();
        String ErrorMessage = prop.getProperty("ErrorMessage");
        if(ErrorMessage.equalsIgnoreCase(loginObj.errorMessage().getText())){
            loginObj.password().clear();
            loginObj.password().sendKeys(prop.getProperty("Password"));
            loginObj.login().click();
            String ActualTitleLoginPage = prop.getProperty("TitlePageLogin");
            WebDriverWait wait = new WebDriverWait(driver,10);
            String ExpectedTitleLoginPage = driver.getTitle();
            Assert.assertEquals(ActualTitleLoginPage,ExpectedTitleLoginPage);
        }
    }
}
