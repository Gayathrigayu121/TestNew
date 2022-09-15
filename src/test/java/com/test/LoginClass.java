package com.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.base.BaseClass;
import com.utilities.LoginPage;

public class LoginClass extends BaseClass {

	@Test
	public void baseLogin() {

		ExtentTest test = extent.createTest("LoginPage").assignCategory("Functional Test").assignDevice("Edge Browser");
		test.info("Login Page Verification");
		LoginPage login = new LoginPage(driver);

		Map<String, String> kv = new LinkedHashMap<String, String>();
		kv.put("gs", "w");
		kv.put("gayathrg@jmangroup.com", "asf");
		kv.put("gayathri@jmangroup.com", "asfghjkl");
		kv.put("gayathry@jmangroup.com", "asfghjkl@");
		kv.put("gayathrigs@jmangroup.com", "asfghjkl@H");

		
		for (Map.Entry entry : kv.entrySet()) {
			login.Email().sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE),(String) entry.getKey());
			login.PassWord().sendKeys((String) entry.getValue());
			login.Submit().click();
			
			if ("gs".equals(entry.getKey())) {
				String attribute = login.Email().getAttribute("validationMessage");
				System.out.println(attribute);
			} else {
				String attribute2 = login.passWord_Validation().getText();
				System.out.println(attribute2);
			}

		}
		ForgotClass fc=new ForgotClass(driver);
		fc.baseForgot();
	}
}
