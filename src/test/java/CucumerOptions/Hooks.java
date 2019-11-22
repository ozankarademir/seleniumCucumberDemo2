package Stepdefinition;

import CucumerOptions.Base;
import cucumber.api.java.After;

public class Hooks extends Base {

    @After("@SeleniumTests") // Selenium test tagli case koşumu bittikten sonra driver'ı kapatsın
    public void Aftervalidation () throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
