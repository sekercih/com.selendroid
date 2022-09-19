package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SelendroidPage;
import utilities.Driver;

public class TC002PopupStepdefinition {
SelendroidPage task=new SelendroidPage();
    @And("Display popup window yazisini tiklar")
    public void displayPopupWindowYazisiniTiklar() {
    task.showPopupButton.click();
    }

    @And("Acilan popup reddeder")
    public void acilanPopupReddeder() {
        Driver.get().switchTo().alert().dismiss();
    }


}
