package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SignUpclass extends LoginClass {
	
	@Test
	 	public void BaseSignup() {
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.name("firstName")).sendKeys("sd");
		driver.findElement(By.cssSelector("div:nth-of-type(1) > div:nth-of-type(1) > .hTpFiz.sc-kBaCIR > .jIwQiP.sc-la-DyNK.text-body-small")).getText();
		driver.findElement(By.name("lastName")).sendKeys("sa");
		driver.findElement(By.className("div:nth-of-type(1) > div:nth-of-type(2) > .hTpFiz.sc-kBaCIR > .jIwQiP.sc-la-DyNK.text-body-small")).getText();
		driver.findElement(By.name("organization")).sendKeys("afdss");
		driver.findElement(By.name("email")).sendKeys("gs@gmail.com");
		driver.findElement(By.name("password")).sendKeys("gs");
		driver.findElement(By.cssSelector("[class~='text-body-small'][type='password']")).getText();
		driver.findElement(By.name("confirmPassword")).sendKeys("gss");
		driver.findElement(By.cssSelector("div:nth-of-type(4) > div:nth-of-type(2) > .hTpFiz.sc-kBaCIR > .jIwQiP.sc-la-DyNK.text-body-small")).getText();
		driver.findElement(By.name("acceptTerms"));
	 		
	 	}
	
}
