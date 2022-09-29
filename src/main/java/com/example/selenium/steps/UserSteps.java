package com.example.selenium.steps;

import com.example.selenium.pages.LoginPage;
import com.example.selenium.pages.MainPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class UserSteps {
    private WebDriver driver;
    private MainPage mainPage;

    public UserSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);

        loginPage.setUsername(username).setPassword(password).clickLogin();

        assertEquals(mainPage.getTitle(), "Secure Area", "Login Failed");

    }

    public void logout() {
        mainPage.clickLogout();
    }
}