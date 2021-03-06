package StepDefinition;

import Usable_Function.Generic_function;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class registration extends Generic_function {
    static String str;

    @Then("launch the url")
    public void launch_the_url() throws IOException, InterruptedException {
        browsers_launch();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Then("verify logo is displayed on signup page")
    public void verify_logo_is_displayed_on_signup_page() throws IOException, InterruptedException {
        browser_wait(5000);
        Thread.sleep(2000);
        boolean logo = driver.findElement(By.xpath(OR_reader("logo"))).isDisplayed();
        Assert.assertEquals(true,logo);
    }
    @Then("verify new user registration heading")
    public void verify_new_user_registration_heading() throws IOException {
        registration_heading();
    }
    @Then("User can able to enter the data in member detail page")
    public void user_can_able_to_enter_the_data_in_member_detail_page() throws IOException, InterruptedException {
        driver.findElement(By.xpath(OR_reader( "ssn_radio"))).click();
        driver.findElement(By.xpath(OR_reader("ssn"))).sendKeys(td_reader("ssn",0));
        hover_verify();
        driver.findElement(By.xpath(OR_reader("first_name"))).sendKeys(td_reader("first_name",0));
        driver.findElement(By.xpath(OR_reader("last_name"))).sendKeys(td_reader("last_name",0));
        driver.findElement(By.xpath(OR_reader("date"))).sendKeys(td_reader("date",0));
        driver.findElement(By.xpath(OR_reader("zipcode"))).sendKeys(td_reader("zipcode",0));
        driver.findElement(By.xpath(OR_reader("proceed")));
        click("proceed");
    }

    @Then("User can able to see user verified successful msg")
    public void then_user_can_able_to_see_user_verified_successful_msg() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR_reader("reg_sucess_popup"))));
        String edittext = element.getText();
        System.out.println(edittext);
        Assert.assertEquals(edittext, td_reader("reg_sucess_popup"));
        Thread.sleep(1000);
    }
    @Then("User can able to enter the data in create account page")
    public void user_can_able_to_enter_the_data_in_create_account_page() throws InterruptedException, IOException {
        Thread.sleep(8000);
        registration_heading();
        driver.findElement(By.xpath(OR_reader("email_reg"))).sendKeys(td_reader("email_reg",0));
        driver.findElement(By.xpath(OR_reader("phone_no"))).sendKeys(td_reader("phone_no",0));
        driver.findElement(By.xpath(OR_reader("password_reg"))).sendKeys(td_reader("password_reg",0));
        driver.findElement(By.xpath(OR_reader("confirm_reg"))).sendKeys(td_reader("confirm_reg",0));
        driver.findElement(By.xpath(OR_reader("terms_condition")));
        click("terms_condition");
        scroll_down_tc();
        Thread.sleep(1000);
        driver.findElement(By.xpath(OR_reader("privacy_policy")));
        click("privacy_policy");
        scroll_down_privacy();
        driver.findElement(By.xpath(OR_reader( "accept_radio"))).click();
        driver.findElement(By.xpath(OR_reader("create_account")));
        click("create_account");
    }
    @Then("User can able to see pop account created successfully")
    public void user_can_able_to_see_pop_account_created_successfully() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR_reader("ac_created_pop"))));
        String edittext = element.getText();
        System.out.println(edittext);
        Assert.assertEquals(edittext, td_reader("ac_created_pop"));
        Thread.sleep(1000);
    }
    @When("enter otp and navigated to sucessfull page")
    public void enter_otp_and_navigated_to_sucessfull_page() throws IOException, InterruptedException {
        Thread.sleep(6000);
        driver.findElement(By.xpath(OR_reader( "otp"))).sendKeys(td_reader("otp_no",0));
        driver.findElement(By.xpath(OR_reader("verify")));
        click("verify");
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR_reader("login_href")));
        click("login_href");
        Thread.sleep(3000);
        driver.findElement(By.xpath(OR_reader( "email_reg"))).sendKeys(td_reader("email_reg",0));
        driver.findElement(By.xpath(OR_reader("password_reg"))).sendKeys(td_reader("password_reg",0));
        driver.findElement(By.xpath(OR_reader("login")));
        click("login");

    }

}
