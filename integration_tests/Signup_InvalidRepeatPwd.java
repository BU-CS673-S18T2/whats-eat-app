package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class InvalidRepeatPwd {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://www.katalon.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testInvalidRepeatPwd() throws Exception {
		selenium.open("http://localhost:8080/index.html");
		selenium.click("id=signup");
		selenium.click("name=username");
		selenium.type("name=username", "jiujiu");
		selenium.click("name=email");
		selenium.type("name=email", "jiujiu@gmail.com");
		selenium.click("name=password");
		selenium.type("name=password", "123123");
		selenium.click("name=psw-repeat");
		selenium.type("name=psw-repeat", "1231234");
		selenium.click("name=gender");
		selenium.click("name=height");
		selenium.type("name=height", "7");
		selenium.click("name=weight");
		selenium.type("name=weight", "150");
		selenium.click("name=age");
		selenium.type("name=age", "24");
		selenium.click("xpath=(//button[@type='button'])[2]");
		assertEquals("Password does not match!", selenium.getAlert());
		selenium.click("//button[@type='button']");
		selenium.click("link=Home");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
