package testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.XLUtilities;


public class DataDrivenTestCase extends BaseClass {

    @Test(dataProvider = "LoginData")
    public void DataDriven(String Firstname, String Lastname) throws InterruptedException {
        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);

        lp.ClickSignin();
        logger.info("Clicked sign in");
        Thread.sleep(300);

        lp.setEmail1(email); // Changed from email to user
        logger.info("Entered email");
        Thread.sleep(300);

        lp.ClickCreate();
        logger.info("Clicked on Create Account");

        Thread.sleep(3000);

        lp.setRadioButton();
        logger.info("Clicked radiobutton");

        lp.setUserName(Firstname); // Changed from username to user
        logger.info("Entered Username");
        lp.setLastName(Lastname); // Changed from lastname to pwd
        logger.info("Entered Lastname");

        Thread.sleep(3000);

        if (isAlertPresent()) {
            driver.switchTo().alert().accept(); // close alert
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("Login failed");
        } else {
            Assert.assertTrue(true);
            logger.info("Login passed");
            Thread.sleep(3000);
            driver.switchTo().alert().accept(); // close logout alert
            driver.switchTo().defaultContent();
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @DataProvider(name = "LoginData")
    
    public String[][] getData() throws IOException {
        // Debugging: Print the working directory
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        // Corrected the file path assignment
        String filePath = System.getProperty("user.dir") + "/src/test/java/testdata/LoginData.xlsx";

        // Debugging: Print the file path
        System.out.println("File path: " + filePath);

        // Verify if file exists
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File exists: " + filePath);
        } else {
            System.out.println("File does not exist: " + filePath);
            throw new IOException("File not found: " + filePath);
        }

        int rownum = XLUtilities.getRowCount(filePath, "Sheet1");
        int colcount = XLUtilities.getCellCount(filePath, "Sheet1", 1);

        String logindata[][] = new String[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = XLUtilities.getCellData(filePath, "Sheet1", i, j);
            }
        }
        return logindata;
    }
}
