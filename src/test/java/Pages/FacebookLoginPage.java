package Pages;


import Driver.DriverFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FacebookLoginPage {
    By email = By.name("email");
    By password = By.name("pass");

    By linktext= By.linkText("anwesha_dhal");
    By loginBtn = By.xpath("//*[@id='login_form']/div/div[1]/div/div[3]/div/div/div/div[1]/div/span/span");
    public static String text;
    public void enterUsername(String user) throws InterruptedException {

        DriverFactory.getDriver().findElement(email).sendKeys(user);
        Thread.sleep(5000);

    }

    public void enterPassword(String pass) throws InterruptedException {

        DriverFactory.getDriver().findElement(password).sendKeys(pass);
        Thread.sleep(5000);

    }

    public void clickLogin() throws InterruptedException {

        DriverFactory.getDriver().findElement(loginBtn).click();
        Thread.sleep(10000);

    }

    public void validateTitleofHome() throws InterruptedException {
        Thread.sleep(5000);
        text= DriverFactory.getDriver().findElement(linktext).getText();
        Assert.assertEquals(text,"anwesha_dhal");
        Thread.sleep(5000);
    }
}
