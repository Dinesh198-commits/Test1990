package flipKartTesting.pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverSetup {
    public static RemoteWebDriver driver;
    public static Properties prop;
    public static Actions action;

    public ExtentReports report;
    public ExtentTest test ;

    @BeforeTest
    public void DataSetUp() throws IOException {
        //generating object for reporting
        report = new ExtentReports("ExtentReport.html");
    }

    @BeforeTest
    public static WebDriver Driver() throws IOException {
        //WebDriverManager.edgedriver().setup();
        //EdgeOptions options = new EdgeOptions();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-headless");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        prop = new Properties();
        FileInputStream ref = new FileInputStream("Login.properties");
        prop.load(ref);
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        FileInputStream ref1 = new FileInputStream("AssertionPart.properties");
        prop.load(ref1);
        action = new Actions(driver);
        return driver;
    }
    @AfterTest
    public void tearDown(){
            //related to report
            report.flush();
            report.close();
            driver.quit();
    }
}
