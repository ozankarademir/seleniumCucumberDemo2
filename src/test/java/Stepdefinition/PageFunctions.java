package Stepdefinition;

import Constants.PageConstants;
import CucumerOptions.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class PageFunctions extends Base {


    public void clickButton(By by){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void sendKey(By by, String keys){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
    }

    protected int createRandomInteger(int start, int end) {
        int randomNumber;
        if (start > end) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        } else {
            Random random = new Random();
            randomNumber = random.nextInt((end - start) + 1) + start;
        }
        return randomNumber;
    }
    public Double priceArragement() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(PageConstants.ORDER_PRICE);
        String string_price = element.getText();
        String modified_string_price = string_price.replace("$", " ");
        Double price;
        price = Double.parseDouble(modified_string_price);
        return price;
    }

    public Double priceArragement2() throws InterruptedException {
        Thread.sleep(1000);
        WebElement element = driver.findElement(PageConstants.CART_TOTAL_PRICE);
        String string_price = element.getText();
        String modified_string_price = string_price.replace("$", " ");
        Double price;
        price = Double.parseDouble(modified_string_price);
        return price;
    }

    public void mouseOver(){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(PageConstants.PRODUCT_DETAIL);
        action.moveToElement(element).perform();
    }
    public String deliveryAdress(){
        String deliveryAdress;
        WebElement element = driver.findElement(PageConstants.DELIVERY_ADRESS);
        deliveryAdress=element.getText();
        return deliveryAdress;
    }
    public String invoiceAdress(){
        String deliveryAdress;
        WebElement element = driver.findElement(PageConstants.INVOICE_ADRESS);
        deliveryAdress=element.getText();
        return deliveryAdress;
    }

    public void assertTrue(boolean condition, String message) {
        Assert.assertTrue(message, condition);
    }

    public void assertEqual(boolean condition, String message) {
        Assert.assertEquals(message,condition,condition);
    }
}

