package StepDefinition;

import Usable_Function.Generic_function;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;

import java.io.IOException;

public class Login_Forgot_Password_Positive_Scenario extends Generic_function {

    @When("Click on Forgot Button Link")
    public void click_on_forgot_button_link() throws IOException, InterruptedException {
      Thread.sleep(2000);
      WebElement forgot = driver.findElement(By.xpath(OR_reader("forgots")));
      forgot.click();
    }
    @Then("navigated to Forgot Password Page and enter the linked phone number")
    public void navigated_to_forgot_password_page_and_enter_the_linked_phone_number() throws IOException, InterruptedException {
     Thread.sleep(2000);
     driver.findElement(By.xpath(OR_reader("acc_link_phoneno"))).sendKeys(td_reader("phone_no"));
     driver.findElement(By.xpath(OR_reader("forgot_send_otp")));
     click("forgot_send_otp");
    }

    @Then("navigated to otp verification page and enter the otp")
    public void navigated_to_otp_verification_page_and_enter_the_otp() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR_reader("forgot_enter_otp"))).sendKeys(td_reader("forgot_enter_otp"));
        driver.findElement(By.xpath(OR_reader("sent_changes")));
        click("sent_changes");

    }

    @Then("Verify user can able to create new Password")
    public void verify_user_can_able_to_create_new_password() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(OR_reader("new_password"))).sendKeys(td_reader("new_password"));
        driver.findElement(By.xpath(OR_reader("confirm_password"))).sendKeys(td_reader("confirm_password"));
        driver.findElement(By.xpath(OR_reader("change_password")));
        click("change_password");
        Thread.sleep(1000);
        driver.findElement(By.xpath(OR_reader("login_href")));
        click("login_href");
        Thread.sleep(3000);
        driver.findElement(By.xpath(OR_reader( "email_reg"))).sendKeys(td_reader("email_reg",0));
        driver.findElement(By.xpath(OR_reader("confirm_password"))).sendKeys(td_reader("confirm_password",0));
        driver.findElement(By.xpath(OR_reader("login")));
        click("login");

    }




}
