package Constants;

import org.openqa.selenium.By;

public class PageConstants {

    public static By SIGN_IN_BUTTON = By.cssSelector("a[title='Log in to your customer account']");
    public static By CREATE_AN_ACCOUNT_E_MAIL = By.cssSelector("input#email_create");
    public static By CREATE_AN_ACCOUNT_E_MAIL_BUTTON = By.cssSelector("button#SubmitCreate > span");
    public static By GENDER_MR = By.cssSelector("div:nth-of-type(1) > .top > .radio  input[name='id_gender']");
    public static By FIRST_NAME = By.cssSelector("input#customer_firstname");
    public static By LAST_NAME = By.cssSelector("input#customer_lastname");
    public static By PASSWORD = By.cssSelector("input#passwd");
    public static By SELECT_DAY = By.cssSelector("select#days");
    public static By SELECT_MONTH= By.cssSelector("select#months");
    public static By SELECT_YEARS= By.cssSelector("select#years");
    public static By ADRESS= By.cssSelector("input[name='address1']");
    public static By CITY= By.cssSelector("input#city");
    public static By POST_CODE= By.cssSelector("input#postcode");
    public static By MOBILE_PHONE= By.cssSelector("input#phone_mobile");
    public static By STATE= By.cssSelector("select#id_state");
    public static By REGISTER_BUTTON= By.cssSelector("button#submitAccount > span");
    public static By SIGN_OUT_BUTTON= By.cssSelector("a[title='Log me out']");
    public static By LOGIN_INPUT_EMAIL= By.cssSelector("input#email");
    public static By LOGIN_INPUT_PASS= By.cssSelector("input#passwd");
    public static By LOGIN_PAGE_SIGN_IN_BUTTON= By.cssSelector("button#SubmitLogin > span");
    public static By WOMEN_CATEGORY= By.cssSelector("a[title='Women']");
    public static By SUB_CATEGORY= By.cssSelector("a[title='Tops'] > img");
    public static By SUB_CATEGORY_TSHIRT= By.cssSelector("a[title='T-shirts'] > img");
    public static By PRODUCT_DETAIL= By.cssSelector("a[title='Faded Short Sleeve T-shirts'] > img[alt='Faded Short Sleeve T-shirts']");
    public static By PRODUCT_DETAIL_MORE_BUTTON= By.cssSelector("a[title='View'] > span");
    public static By ORDER_PRICE= By.cssSelector("#our_price_display");
    public static By ADD_TO_CART= By.cssSelector("p#add_to_cart  span");
    public static By PROCEED_CHECKOUT= By.cssSelector("a[title='Proceed to checkout'] > span");
    public static By CART_TOTAL_PRICE= By.cssSelector(".cart_total > .price");
    public static By DELIVERY_ADRESS= By.cssSelector("ul#address_delivery > .address_address1.address_address2");
    public static By INVOICE_ADRESS= By.cssSelector("ul#address_invoice > .address_address1.address_address2");
    public static By PROCEED_CHECKOUT_SUMMARY_PAGE= By.cssSelector("div#center_column  a[title='Proceed to checkout'] > span");
    public static By PROCEED_CHECKOUT_ADRESS_PAGE= By.cssSelector("div#center_column > form[method='post']  button > span");
    public static By PROCEED_CHECKOUT_SHIPPING_PAGE= By.cssSelector("form#form  button > span");
    public static By SHIPPING_PAGE_HEADER= By.cssSelector("div#carrier_area > .page-heading");
    public static By SHIPPING_AGREEMENT_TERM= By.cssSelector("label");
    public static By PAY_BY_CHECK= By.cssSelector("a[title='Pay by check.'] > span");
    public static By ORDER_CONFIRMATION_HEADER= By.cssSelector("div#center_column > .page-heading");
    public static By CONFIRM_ORDER_BUTTON= By.cssSelector("p#cart_navigation  span");
}
