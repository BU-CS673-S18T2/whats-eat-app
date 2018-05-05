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
		selenium.click("id=login");
		selenium.click("name=loginname");
		selenium.click("name=loginname");
		selenium.type("name=loginname", "");
		selenium.type("name=loginpassword", "");
		selenium.click("name=loginname");
		selenium.type("name=loginname", "realyuhe@gmail.com");
		selenium.type("name=loginpassword", "1231234");
		selenium.click("xpath=(//button[@type='button'])[3]");
		assertEquals("error", selenium.getAlert());
		selenium.click("xpath=(//button[@type='button'])[4]");
		selenium.click("link=Home");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
