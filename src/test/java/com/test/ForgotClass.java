package com.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.utilities.LoginPage;

public class ForgotClass {
WebDriver driver;


ForgotClass(WebDriver driver){
	this.driver=driver;
}

	@Test
	public void baseForgot() {
		LoginPage login = new LoginPage(driver);
		driver.findElement(By.linkText("Forgot password?")).click();
		List<String> list=new ArrayList<String>();
		list.add("gs");
		list.add("gs@");
		list.add("gs@.");
		list.add("gsd@gmail.com");
		
		for(String i: list) {
			login.Email().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE),i);
			login.Submit().click();
			String attribute = login.Email().getAttribute("validationMessage");
			System.out.println(attribute);
		}
		
	}
	
}
