package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SelendroidPage extends BasePage{

    @AndroidFindBy(id = "android:id/button1")
    public WebElement guncellemeUyarisiKabulButonu;

    @AndroidFindBy(accessibility = "startUserRegistrationCD")
    public WebElement registrationButton;

    @AndroidFindBy(id = "io.selendroid.testapp:id/inputUsername")
    public WebElement userNameBox;

    @AndroidFindBy(accessibility = "email of the customer")
    public WebElement emailBox;

    @AndroidFindBy(id = "io.selendroid.testapp:id/inputPassword")
    public WebElement passwordBox;

    @AndroidFindBy(id = "io.selendroid.testapp:id/inputName")
    public WebElement nameBox;

    @AndroidFindBy(id = "io.selendroid.testapp:id/input_preferedProgrammingLanguage")
    public WebElement programmingLanguageBox;
    
    @AndroidFindBy(className = "android.widget.Spinner")
    public WebElement dropClick;

    @AndroidFindBy(xpath = "//*[@index='5']")
    public WebElement javaDropElement;

    @AndroidFindBy(id = "io.selendroid.testapp:id/input_adds")
    public WebElement acceptButton;

    @AndroidFindBy(id = "io.selendroid.testapp:id/btnRegisterUser")
    public WebElement registerButton;

    @AndroidFindBy(id = "io.selendroid.testapp:id/label_name_data")
    public WebElement nameData;

    @AndroidFindBy(id = "io.selendroid.testapp:id/label_username_data")
    public WebElement usernameData;

    @AndroidFindBy(id = "io.selendroid.testapp:id/label_password_data")
    public WebElement passwordData;

    @AndroidFindBy(id = "io.selendroid.testapp:id/label_email_data")
    public WebElement emailData;

    @AndroidFindBy(id = "io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")
    public WebElement programingLanguageData;

    @AndroidFindBy(id = "io.selendroid.testapp:id/buttonRegisterUser")
    public WebElement registerUser;

    @AndroidFindBy(accessibility = "showPopupWindowButtonCD")
    public WebElement showPopupButton;

    @AndroidFindBy(id = "buttonStartWebview")
    public WebElement webviewButton;

    @AndroidFindBy(id = "io.selendroid.testapp:id/goBack")
    public WebElement goToHomeScreenButton;

    @AndroidFindBy(id = "name_input")
    public WebElement nameInputBox;
}
