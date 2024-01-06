package flipKartTesting.implementation;

import flipKartTesting.pages.DriverSetup;
import flipKartTesting.pages.LoginPage;
import flipKartTesting.pages.OtherPages;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class C_searchProductNameAndPrice extends DriverSetup {

    @Test
    public void search() throws InterruptedException {
        OtherPages Obj = new OtherPages(driver);
        Obj.SearchInput().sendKeys(prop.getProperty("searchInput"));
        Thread.sleep(3000);
        Obj.SearchSubmit().click();
        System.out.println(Obj.productSearch().size());
        try {
            for (int i = 0; i < Obj.priceSearch().size(); i++) {
                System.out.println("Product name " + Obj.productSearch().get(i).getText() + "And prices are " +
                        Obj.priceSearch().get(i).getText());
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
    }

}
