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

public class InvalidPwd {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://www.katalon.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testInvalidPwd() throws Exception {
		selenium.open("http://localhost:8080/index.html");
		selenium.click("id=signup");
		selenium.type("name=username", "yuhe123");
		selenium.click("name=email");
		selenium.type("name=email", "realyuhe@gmail.com");
		selenium.click("name=password");
		selenium.type("name=password", "real");
		selenium.click("name=psw-repeat");
		selenium.type("name=psw-repeat", "real");
		selenium.click("name=gender");
		selenium.type("name=weight", "150");
		selenium.click("name=age");
		selenium.type("name=age", "22");
		selenium.click("xpath=(//button[@type='button'])[2]");
		assertEquals("Password must be longer than 6", selenium.getAlert());
		selenium.click("//button[@type='button']");
		selenium.click("link=Home");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
