package StepDefinition;

import Usable_Function.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.io.IOException;

public class login extends Generic_function {

    @Given("Launch the chrome browser and naviaged to login page")
    public void launch_the_chrome_browser_and_naviaged_to_login_page() throws IOException, InterruptedException {
        browser_launch();
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }
    @When("user enter valid credentials")
    public void user_enter_valid_credentials() throws IOException {
        try {
            driver.findElement(By.xpath(OR_reader( "email"))).sendKeys(td_reader("email",0));
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            driver.findElement(By.xpath(OR_reader("password"))).sendKeys(td_reader("password",0));
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(By.xpath(OR_reader("login")));
        click("login");

    }



}
