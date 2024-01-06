package flipKartTesting.implementation;

import flipKartTesting.pages.OtherPages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class B_CheckAccountUserName extends A_LoginImp {
    @Test
    public void b_checkAccountUserName() throws InterruptedException, IOException {
        OtherPages loginObj = new OtherPages(driver);
        action.moveToElement(loginObj.navigationLoginLink()).build().perform();
        Thread.sleep(3000);
        loginObj.navigationLoginLink().click();
        Thread.sleep(2000);
        loginObj.LoginSecurity().click();
        Thread.sleep(500);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File Destination = new File("AccountUser.png");
        FileUtils.copyFile(source,Destination);
    }
}
