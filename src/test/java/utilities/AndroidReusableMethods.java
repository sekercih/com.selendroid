package utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;

import java.util.HashMap;
import java.util.List;

public class AndroidReusableMethods {


    public static void clickOnPage(String pageName) throws InterruptedException {
        Thread.sleep(4000);
        List<AndroidElement> pages = Driver.get().findElementsByClassName("android.widget.TextView");
        for (MobileElement page: pages) {
            if (page.getText().equals(pageName)){
                page.click();
                break;
            }else{
                scrollWithUiScrollable(pageName);
                break;
            }
        }
    }

    //ikinci alternatif bir method
    public static void clickOnPage1(String pageName) throws InterruptedException {
        Thread.sleep(4000);
        List<AndroidElement> pages = Driver.get().findElementsByXPath("//android.widget.TextView[@text='"+pageName+"']");
        if (pages.size()>0){
            pages.get(0).click();
        }else scrollWithUiScrollable(pageName);
    }

    public static void scrollWithUiScrollable(String elementText){
        AndroidDriver driver = (AndroidDriver) Driver.get();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+elementText+"\"))");
        driver.findElementByXPath("//*[@text='"+elementText+"']").click();
    }

    public static void longPressOnElement(MobileElement mobileElement){
        TouchAction touchAction = new TouchAction(Driver.get());
        touchAction.longPress(ElementOption.element(mobileElement)).release().perform();
    }

    public static void clickOnPageIOS(String text){
        List<AndroidElement> pages = Driver.get().findElementsByXPath("//XCUIElementTypeStaticText[@name='"+text+"']");
        if (pages.get(0).isDisplayed()){
            pages.get(0).click();
        }else{
            scrollAndClickOnIOS(text);
        }
    }

    public static void scrollAndClickOnIOS(String text){
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("value",text);
        Driver.get().executeScript("mobile: scroll", scrollObject);

        Driver.get().findElementByXPath("//XCUIElementTypeStaticText[@name='"+text+"']").click();
    }
}
