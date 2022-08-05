Feature: Login Forgot Password

  Scenario:Browser Launch
    Given Launch the chrome browser and naviaged to login page

  Scenario: Forgot Password
    When Click on Forgot Button Link
    Then navigated to Forgot Password Page and enter the linked phone number
    Then navigated to otp verification page and enter the otp
    Then Verify user can able to create new Password
