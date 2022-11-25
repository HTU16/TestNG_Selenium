package com.krafttechnologie.tests.day15_POM;                        //pom=page object modal
                                                 //tekrarlardan kaçınmak daha az komut yazmak amacıyla pom kullanılır.
import com.krafttechnologie.pages.LoginPages;    //kodu okunabilir hale getirir. nesne deposu. pom komutları yeniden kullanılanilir.
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    LoginPages loginPages=new LoginPages();

    @Test
    public void wrongPassword() {

        driver.get(ConfigurationReader.get("url"));

        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));
        loginPages.passwordInput_loc.sendKeys("somepassword");
        loginPages.submitButton_loc.click();



//        WebElement usernameInput = driver.findElement(By.name("email"));
//        WebElement passwordInput = driver.findElement(By.name("password"));
//
//        usernameInput.sendKeys(ConfigurationReader.get("username"));
//        passwordInput.sendKeys("some password");
//
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        WebElement warningMessage = driver.findElement
//                (By.xpath("//*[contains(text(),'Email address or password is incorrect. Please check')]"));
//
//        Assert.assertEquals(warningMessage.getText(),
//                "Email address or password is incorrect. Please check",
//                "Verify that user is NOT login");

    }

    @Test
    public void wrongUsername() {

        driver.get(ConfigurationReader.get("url"));
        loginPages.userEmailInput_loc.sendKeys("xyzw");
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        loginPages.submitButton_loc.click();

        String actualMessage= loginPages.warningMessage_loc.getText();
        String expectedMessage="Email address or password is incorrect. Please check";
        Assert.assertEquals(actualMessage,expectedMessage);




    }
}
