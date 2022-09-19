package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SelendroidPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class TC003SayHelloTestStepDefinition {
    SelendroidPage task=new SelendroidPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);


    @And("Kullanici webview butonuna tiklar")
    public void kullaniciWebviewButonunaTiklar() {
        task.webviewButton.click();
    }

    @And("Kullanici name box'ın dolu oldugunu dogrular ve isim girer")
    public void kullaniciNameBoxInDoluOldugunuDogrularVeIsimGirer() {
        wait.until(ExpectedConditions.visibilityOf(task.goToHomeScreenButton));
       Driver.get().switchTo().window("WEBVIEW");
        Assert.assertNotNull(task.nameInputBox);
        task.nameInputBox.clear();
        task.nameInputBox.sendKeys(ConfigurationReader.get("nameHello"));
    }

    @And("Kullanici prefered car bolumunden rastgele bir arac secer")
    public void kullaniciPreferedCarBolumundenRastgeleBirAracSecer() {
        WebElement inputField = Driver.get().findElement(By.id("name_input"));
        WebElement car = Driver.get().findElement(By.name("car"));
        Select preferedCar = new Select(car);
        preferedCar.selectByValue("audi");
        inputField.submit();
    }

    @Then("Kullanici girdigi bilgileri acilan sayfadan dogrular")
    public void kullaniciGirdigiBilgileriAcilanSayfadanDogrular() {

    }

}
