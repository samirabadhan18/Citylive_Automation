package testcase;
import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ReadXLSdata;

import java.awt.*;
import java.io.IOException;

import static org.openqa.selenium.By.xpath;

public class Wallet_Single_Non_Ben extends BaseTest {

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
        Thread.sleep(10000);

        // --- "CBL Wallet Single Payment with NO Beneficiary" ---
        driver.findElement(By.xpath(loc.getProperty("payment_drop"))).click();
        Thread.sleep(6000);
        // System.out.println("Hello ");
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_2"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_sngl"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_company"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(loc.getProperty("cbl_gp_com"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_rdo_btn_no_ben"))).click();
        Thread.sleep(1000);

// --- "CBL Wallet Payment Non Ben ACC Name ACC Num Email Mobile " ---
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_acc_name_no_ben"))).sendKeys(loc.getProperty("cbl_wallet_acc_name_no_ben_value"));
        Thread.sleep(1000);

        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_acc_num_no_ben"))).sendKeys(loc.getProperty("cbl_wallet_acc_num_no_ben_value"));
        Thread.sleep(1000);

        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_acc_email_no_ben"))).sendKeys(loc.getProperty("cbl_wallet_acc_email_no_ben_value"));
        Thread.sleep(1000);

        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_acc_mobile_no_ben"))).sendKeys(loc.getProperty("cbl_wallet_acc_mobile_no_ben_value"));
        Thread.sleep(1000);

// --- "CBL Wallet Payment ADD amount, Reason, Remarks" ---
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_pymnt_amt"))).sendKeys(loc.getProperty("cbl_wallet_amount_value"));
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_pymnt_rsn_drp"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_pymnt_rsn_slct"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_pymnt_rmrks"))).sendKeys(loc.getProperty("cbl_wallet_pymnt_rmrks_value"));
        Thread.sleep(3000);
        driver.findElement(By.xpath(loc.getProperty("cbl_wallet_pymnt_proceed"))).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);


        js.executeScript("window.scrollBy(0,700)");

        // Robot creation
        Robot robot = new Robot();

        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(xpath(loc.getProperty("trnx_ref_wlt_conf"))).click();
        Thread.sleep(700);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);


        // --- "CBL Wallet Payment Signatory Assign" ---

        driver.findElement(By.xpath(loc.getProperty("assign_signatory_btn"))).click();
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath(loc.getProperty("assign_signatry_slct"))).click();
        Thread.sleep(1000);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("sgntry_submit"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("sgntry_confrm"))).click();




        // Logout Test Cases
        Thread.sleep(7000);
        driver.findElement(By.xpath(loc.getProperty("log_out_link"))).click();
        Thread.sleep(1500);
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(1000);

        // Checker

        driver.findElement(By.xpath(loc.getProperty("check_user_link"))).sendKeys(loc.getProperty("check_username"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(loc.getProperty("check_password_link"))).sendKeys(loc.getProperty("check_password"));
        Thread.sleep(1000);
        driver.findElement(By.xpath(loc.getProperty("check_proceed_link"))).click();
        //driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
        Thread.sleep(10000);

        driver.findElement(By.cssSelector(loc.getProperty("chck_cnfrm"))).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(3000);
        driver.findElement(By.xpath(loc.getProperty("chck_trnsctn_cnfrm"))).click();

    }
}