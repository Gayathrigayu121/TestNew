package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;

public class LoginClass extends BaseClass {

	@Test
	public void baseLogin() {

		ExtentTest test=extent.createTest("LoginPage").assignCategory("Functional Test").assignDevice("Edge Browser");
	    test.info("Login Page Verification");
	    Map<String,String> kv=new LinkedHashMap<String,String>();
	    kv.put("gs", "w");
	    kv.put("gayathrg@jmangroup.com", "asf");
	    kv.put("gayathri@jmangroup.com", "asfghjkl");
	    kv.put("gayathry@jmangroup.com", "asfghjkl@");
	    kv.put("gayathrigs@jmangroup.com", "asfghjkl@H");
	   
	    for(Map.Entry entry:kv.entrySet()){  
	    driver.findElement(By.name("email")).sendKeys(Keys.chord(Keys.CONTROL, "a",Keys.DELETE),(String)entry.getKey());
	    driver.findElement(By.name("password")).sendKeys((String)entry.getValue());
	    driver.findElement(By.cssSelector("[type='submit']")).click();
	    if("gs".equals(entry.getKey())) {
	    String attribute = driver.findElement(By.name("email")).getAttribute("validationMessage");
	    System.out.println(attribute);
	    }
	    else {
	    String attribute2 = driver.findElement(By.cssSelector("[class~='text-body-small'][type='password']")).getText();
	    System.out.println(attribute2);
	    }
	    
	    }
		}
	
}
