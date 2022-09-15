package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	By email = By.name("email");

	public WebElement Email() {
		return driver.findElement(email);

	}

	By passWord = By.name("password");

	public WebElement PassWord() {
		return driver.findElement(passWord);

	}

	
	By submit = By.cssSelector("[type='submit']");

	public WebElement Submit() {
		return driver.findElement(submit);
	}

	
	By PasswordValidation = By.cssSelector("[class~='text-body-small'][type='password']");

	public WebElement passWord_Validation() {
		return driver.findElement(PasswordValidation);

	}

}
