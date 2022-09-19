package stepdefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.SelendroidPage;
import utilities.Driver;
import utilities.ExcelUtil;

import java.io.FileInputStream;
import java.io.IOException;

public class TC001RegistirationStepdefinition {
SelendroidPage task =new SelendroidPage();



    @Given("Kullanici selendroid mobil applikasyonu uyari yazisini kabul eder")
    public void kullanici_selendroid_mobil_applikasyonu_uyari_yazisini_kabul_eder() {
      //  task.guncellemeUyarisiKabulButonu.click();
    }
    @Given("Kullanici start user registration butonunu tiklar")
    public void kullanici_start_user_registration_butonunu_tiklar() {
        task.registrationButton.click();
    }

    @Given("Kullanici username olarak {string} girer")
    public void kullanici_username_olarak_girer(String userName) throws IOException {
       String path="selendroidAppTestData.xlsx";
   userName= ExcelUtil.cellCall(path,"sa",1,0).getStringCellValue();
     task.userNameBox.sendKeys(userName);
        System.out.println("userName = " + userName);
    }
    @Given("Kullanici email olarak {string} girer")
    public void kullanici_email_olarak_girer(String email) {
        task.emailBox.sendKeys(email);
    }

    @Given("Kullanici password plarak {string} girer")
    public void kullanici_password_plarak_girer(String password) {
        task.passwordBox.sendKeys(password);
    }

    @Given("Kullanici name olarak {string} girer")
    public void kullanici_name_olarak_girer(String name) {
        task.nameBox.clear();
        task.nameBox.sendKeys(name);
    }

    @And("Kullanici programming language olarak {string} girer")
    public void kullaniciProgrammingLanguageOlarakGirer(String programingLanguage) {
        TouchAction touchAction = new TouchAction(Driver.get());
        touchAction.longPress(PointOption.point(831, 859))
                .moveTo(PointOption.point(819, 218))
                .release()
                .perform();
        task.dropClick.click();
        task.javaDropElement.click();

    }

    @And("Kullanici accept adds butonu secer ve register butonuna basar")
    public void kullaniciAcceptAddsButonuSecerVeRegisterButonunaBasar() {
        TouchAction touchAction = new TouchAction(Driver.get());
        touchAction.longPress(PointOption.point(528, 934))
                .moveTo(PointOption.point(552, 618))
                .release()
                .perform();

        task.acceptButton.click();

        touchAction.longPress(PointOption.point(528, 934))
                .moveTo(PointOption.point(552, 618))
                .release()
                .perform();
    task.registerButton.click();
    }

    @Then("Kullanici girdigi bilgilerin dogru oldugunu teyit eder")
    public void kullaniciGirdigiBilgilerinDogruOldugunuTeyitEder() {
        Assert.assertEquals("name farklı", task.nameData.getText(),"ferhat");
        Assert.assertEquals("username farklı", task.usernameData.getText(),"ferhat123");
        Assert.assertEquals("password farklı", task.passwordData.getText(),"12345");
        Assert.assertEquals("email farklı", task.emailData.getText(),"ferhat@hotmail.com");
        Assert.assertEquals("programlama dili farklı", task.programingLanguageData.getText(),"Java");
    }

    @Then("Kullanici register user butonuna basar")
    public void kullaniciRegisterUserButonunaBasar() {
        task.registerUser.click();
    }


}
