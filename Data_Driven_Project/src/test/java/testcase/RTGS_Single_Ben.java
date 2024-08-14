package testcase;
import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

import java.awt.*;
import java.io.IOException;

import static org.openqa.selenium.By.xpath;

//import static org.apache.poi.ss.formula.CollaboratingWorkbooksEnvironment.setup;

public class RTGS_Single_Ben extends BaseTest {

    @Test(dataProviderClass = ReadXLSdata.class, dataProvider = "readexceldata")

    public static void LoginTest(String username, String password) throws InterruptedException, IOException, AWTException {

        //Thread.sleep(1000);
        //Scroll Bar
        JavascriptExecutor js = (JavascriptExecutor) driver;
       /* js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,7000)");
       // js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        */


        // ---""Login by entering username and password""---

        driver.findElement(By.id(loc.getProperty("user_link"))).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id(loc.getProperty("password_link"))).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("submit_link"))).click();
        //driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
        Thread.sleep(15000);

// --- "CBL RTGS Single Payment with ADD Beneficiary" ---
        driver.findElement(By.xpath(loc.getProperty("payment_drop"))).click();
        Thread.sleep(17000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(loc.getProperty("cbl_RTGS_payment_single_pmnt_btn"))).click();
        Thread.sleep(7000);
        driver.findElement(xpath(loc.getProperty("cbl_RTGS_slct_comp_drpdwn_btn"))).click();
        Thread.sleep(4000);
        driver.findElement(xpath(loc.getProperty("cbl_RTGS_slct_comp_nm"))).click();
        Thread.sleep(4000);
        driver.findElement(xpath(loc.getProperty("cbl_RTGS_trnsfr_type_radio_btn"))).click();
        Thread.sleep(5000);
        driver.findElement(xpath(loc.getProperty("cbl_RTGS_slct_benfcr_drpdwn"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_ben_selct"))).click();
        Thread.sleep(3000);


        // --- "CBL RTGS Payment ADD amount, Reason, Remarks" ---
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_pymnt_amt"))).sendKeys(loc.getProperty("cbl_rtgs_amount_value"));
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_rsn_drp"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_rsn_drp_slct"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_pymnt_rmrks"))).sendKeys(loc.getProperty("cbl_rtgs_pymnt_rmrks_value"));
        Thread.sleep(5000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_pymnt_proceed"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_pymnt_cnfrm"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_assgn_signtry"))).click();
        Thread.sleep(17000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_slct_sgntry"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_sgntry_submit"))).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(loc.getProperty("cbl_rtgs_ok_pop"))).click();
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);


        js.executeScript("window.scrollBy(0,700)");

        // --- "Scroll Down Command" ---
        //Actions action = new Actions(driver);
        //action.sendKeys(Keys.PAGE_DOWN).perform();
        //Thread.sleep(1000);

        // Robot creation
        //Robot robot = new Robot();


        // Logout Test Cases
        Thread.sleep(7000);
        driver.findElement(By.xpath(loc.getProperty("log_out_link"))).click();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(3000);

        // Checker

        driver.findElement(By.xpath(loc.getProperty("check_user_link"))).sendKeys(loc.getProperty("check_username"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(loc.getProperty("check_password_link"))).sendKeys(loc.getProperty("check_password"));
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("check_proceed_link"))).click();
        //driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
        Thread.sleep(10000);

        driver.findElement(By.cssSelector(loc.getProperty("chck_cnfrm_rtgs"))).click();
        Thread.sleep(7000);
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(5000);
        driver.findElement(By.xpath(loc.getProperty("chck_trnsctn_cnfrm"))).click();



    }
}
