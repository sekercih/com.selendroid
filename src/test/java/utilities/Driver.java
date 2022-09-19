package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static String userName = "ferhattask_V36X17";
    private static String accessKey = "zh2x9LGUo2GqhqBgVrwQ";
    private Driver() {
    }
    private static AndroidDriver<AndroidElement> androidDriver;
    private static IOSDriver<IOSElement> iosDriver;


    public static AndroidDriver<AndroidElement> get(){
        if (androidDriver ==null){
            String platform = ConfigurationReader.get("platform");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (platform){
                case "browserstack-Android":
                    capabilities.setCapability("platformName", "android");
                    capabilities.setCapability("platformVersion", "9.0");
                    capabilities.setCapability("deviceName", "Google Pixel 3");
                    capabilities.setCapability("app", "bs://7a639251c9a69597c63784217d665fdd3cb32903");
                    try {
                        androidDriver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
                        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                    case "browserstack-IOS":
                    capabilities.setCapability("platformName", "ios");
                    capabilities.setCapability("platformVersion", "12");
                    capabilities.setCapability("deviceName", "iPhone XS");
                    capabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
                    try {
                         iosDriver = new IOSDriver<IOSElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);

                        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "android":

                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("platformVersion", "7.0");
                    capabilities.setCapability("deviceName", "Pixel2");
                    capabilities.setCapability("automationName", "UiAutomator2");
                    capabilities.setCapability("app", "C:\\Users\\Mehmet\\Desktop\\selendroidAppTest\\selendroid-test-app-0.17.0.apk");
                    try {
                        androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
                        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                default:

            }
        }
        return androidDriver;
    }

    public static void closeDriver() {
        if (androidDriver !=null){
            androidDriver.quit();
            androidDriver =null;
        }
    }
}