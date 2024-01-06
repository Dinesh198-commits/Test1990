package flipKartTesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    By Username = By.id("ap_email");
    By Password = By.id("ap_password");
    By ContinueButton = By.id("continue");
    By Login = By.id("signInSubmit");
    By ErrorMessage = By.xpath("//*[@id= 'auth-error-message-box']/div/div/ul/li/span");
    By LoginLink = By.xpath("//*[starts-with(text(),'Sign in')]");
    By NavigationLoginLink = By.id("nav-link-accountList");


    public WebElement userName(){return driver.findElement(Username);}
    public WebElement password(){return driver.findElement(Password);}
    public WebElement login(){return driver.findElement(Login);}
    public WebElement navigationLoginLink(){return driver.findElement(NavigationLoginLink);}
    public WebElement continueButton(){return driver.findElement(ContinueButton);}
    public WebElement errorMessage(){return driver.findElement(ErrorMessage);}
    public WebElement loginLink(){return driver.findElement(LoginLink);}

}
