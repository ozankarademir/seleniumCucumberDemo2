package CucumerOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriverWait getWait(){
        webDriverWait = new WebDriverWait(driver, 40000);
        return webDriverWait;
    }
}
