package flipKartTesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OtherPages {
    WebDriver driver;
    public OtherPages(WebDriver driver){

        this.driver = driver;
    }
    By NavigationLoginLink = By.id("nav-link-accountList");

    By LoginSecurity = By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[2]/div[2]/a/div/div/div/div[2]/h2");

    By SearchInput = By.id("twotabsearchtextbox");
    By SearchSubmit = By.id("nav-search-submit-button");
    By productSearch = By.xpath("//*[@class = 'a-size-base-plus a-color-base a-text-normal']");
    By priceSearch = By.xpath("//*[@class='a-price']");




    public WebElement navigationLoginLink(){return driver.findElement(NavigationLoginLink);}
    public WebElement SearchInput(){return driver.findElement(SearchInput);}
    public WebElement LoginSecurity(){return driver.findElement(LoginSecurity);}
    public WebElement SearchSubmit(){return driver.findElement(SearchSubmit);}

    public List<WebElement> productSearch(){return driver.findElements(productSearch);}
    public List<WebElement> priceSearch(){return driver.findElements(priceSearch);}


}

