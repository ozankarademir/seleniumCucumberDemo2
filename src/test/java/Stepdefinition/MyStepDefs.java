package Stepdefinition;

import Constants.PageConstants;
import CucumerOptions.Base;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class MyStepDefs extends PageFunctions{
    public WebDriver driver;
    public  WebDriverWait webDriverWait;

    public String getStrMail() {
        return strMail;
    }
    public void setStrMail(String strMail) {
        this.strMail = strMail;
    }

    String strMail;
    private String pass = "ozan1234";

    @Given("^User is on landing page \"([^\"]*)\"$")
    public void user_is_on_landing_page_something(String page) throws Throwable {
        driver = Base.getDriver();
        webDriverWait =Base.getWait();
        driver.get(page);
        driver.manage().window().fullscreen();
        assertTrue(driver.getCurrentUrl().contains(page), "Wrong link");
    }
    @Then("^Enter a Random Email$")
    public void enter_a_random_email() throws Throwable {
        clickButton(PageConstants.SIGN_IN_BUTTON);
        setStrMail(createRandomInteger(100000000, 999999999) + "@gmail.com");
        sendKey(PageConstants.CREATE_AN_ACCOUNT_E_MAIL , getStrMail());
        clickButton(PageConstants.CREATE_AN_ACCOUNT_E_MAIL_BUTTON);
        Thread.sleep(2000);
    }

    @And("^Create an Account with$")
    public void create_an_account_with(DataTable dataTable) throws Throwable {
        List<List<String>> obj=dataTable.raw();

        WebElement radio_gender_male =driver.findElement(PageConstants.GENDER_MR);
        radio_gender_male.click();

        sendKey(PageConstants.FIRST_NAME, obj.get(0).get(0));
        sendKey(PageConstants.LAST_NAME,obj.get(0).get(1));
        sendKey(PageConstants.PASSWORD, pass);

        Select drowpdown_day = new Select(driver.findElement(PageConstants.SELECT_DAY));
        drowpdown_day.selectByIndex(26);

        Select drowpdown_month= new Select(driver.findElement(PageConstants.SELECT_MONTH));
        drowpdown_month.selectByIndex(7);

        Select drowpdown_year= new Select(driver.findElement(PageConstants.SELECT_YEARS));
        drowpdown_year.selectByValue("1992");

        sendKey(PageConstants.ADRESS, obj.get(0).get(2));
        sendKey(PageConstants.CITY, obj.get(0).get(3));

        Select drowpdown_state= new Select(driver.findElement(PageConstants.STATE));
        drowpdown_state.selectByIndex(10);

        sendKey(PageConstants.POST_CODE, obj.get(0).get(4));
        sendKey(PageConstants.MOBILE_PHONE, obj.get(0).get(5));

        WebElement element = driver.findElement(PageConstants.REGISTER_BUTTON);
        assertTrue(element.isDisplayed(), "Register button could not be displayed");
        clickButton(PageConstants.REGISTER_BUTTON);
    }
    @Then("^Sign out and Sign in current Account$")
    public void sign_out_and_sign_in_current_account() throws Throwable {
        clickButton(PageConstants.SIGN_OUT_BUTTON);
        clickButton(PageConstants.SIGN_IN_BUTTON);
        sendKey(PageConstants.LOGIN_INPUT_EMAIL,getStrMail());
        sendKey(PageConstants.LOGIN_INPUT_PASS,pass);
        WebElement element = driver.findElement(PageConstants.LOGIN_PAGE_SIGN_IN_BUTTON);
        assertTrue(element.isDisplayed(), "Sign in button could not be displayed");
        clickButton(PageConstants.LOGIN_PAGE_SIGN_IN_BUTTON);
    }

    @And("^Select Categories and Sub Categories$")
    public void select_categories_and_sub_categories() throws Throwable {
        WebElement element = driver.findElement(PageConstants.WOMEN_CATEGORY);
        assertTrue(element.isDisplayed(), "Women category button could not be displayed");
        clickButton(PageConstants.WOMEN_CATEGORY);
        clickButton(PageConstants.SUB_CATEGORY);
        clickButton(PageConstants.SUB_CATEGORY_TSHIRT);
        WebElement tshirt = driver.findElement(PageConstants.PRODUCT_DETAIL);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tshirt);
        mouseOver();
        clickButton(PageConstants.PRODUCT_DETAIL_MORE_BUTTON);
        getWait().until(ExpectedConditions.elementToBeClickable(PageConstants.ADD_TO_CART));
    }
    @Then("^Compare Prices and Add to Cart$")
    public void compare_prices_and_add_to_cart() throws Throwable {
        String price_before_order;
        String price_total;
        priceArragement();
        price_before_order=priceArragement().toString();
        clickButton(PageConstants.ADD_TO_CART);
        clickButton(PageConstants.PROCEED_CHECKOUT);
        priceArragement2();
        price_total=priceArragement2().toString();
        Assert.assertEquals("Wrong Price",price_before_order,price_total);
        clickButton(PageConstants.PROCEED_CHECKOUT_SUMMARY_PAGE);
    }
    @And("^Check Delivery and Invoice Adresses \"([^\"]*)\"$")
    public void check_delivery_and_invoice_adresses_something(String strArg1) throws Throwable {
        Assert.assertTrue("Wrong Delivery Adress",deliveryAdress().toString().contains(strArg1));
        Assert.assertTrue("Wrong Invoice Adress",invoiceAdress().toString().contains(strArg1));
        clickButton(PageConstants.PROCEED_CHECKOUT_ADRESS_PAGE);
    }

    @Then("^Set Shipping options$")
    public void set_shipping_options() throws Throwable {
        String header = driver.findElement(PageConstants.SHIPPING_PAGE_HEADER).getText();
        Assert.assertTrue("You are on Wrong Page",header.contains("SHIPPING"));
        clickButton(PageConstants.SHIPPING_AGREEMENT_TERM);
        clickButton(PageConstants.PROCEED_CHECKOUT_SHIPPING_PAGE);
    }

    @And("^Payment Options and Order the Product$")
    public void payment_options_and_order_the_product() throws Throwable {
        clickButton(PageConstants.PAY_BY_CHECK);
        clickButton(PageConstants.CONFIRM_ORDER_BUTTON);
        String header = driver.findElement(PageConstants.ORDER_CONFIRMATION_HEADER).getText();
        Assert.assertTrue("You are on Wrong Page",header.contains("ORDER CONFIRMATION"));
    }
}

