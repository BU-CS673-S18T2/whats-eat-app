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

public class ValidAndLogout {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "https://www.katalon.com/";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testValidAndLogout() throws Exception {
		selenium.open("http://localhost:8080/index.html");
		selenium.click("id=login");
		selenium.click("name=loginname");
		selenium.type("name=loginname", "realyuhe@gmail.com");
		selenium.click("name=loginpassword");
		selenium.type("name=loginpassword", "123123");
		selenium.click("xpath=(//button[@type='button'])[3]");
		selenium.click("id=logout");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
