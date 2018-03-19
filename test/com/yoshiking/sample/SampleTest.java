package com.yoshiking.sample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * サンプルテストクラス
 *
 * @author yoshiking
 */
public class SampleTest {

	/**
	 * Chromeブラウザのテスト
	 * @throws InterruptedException
	 */
	@Test
	public void chromeTest() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver");

		// Driver init
		WebDriver driver = new ChromeDriver();
		// transition
		driver.get("http://www.google.com/xhtml");

		// sleep
		Thread.sleep(5000);

		// Element(searchBox)
		WebElement searchBox = driver.findElement(By.name("q"));
		// send search word
		searchBox.sendKeys("ChromeDriver");
		// submit
		searchBox.submit();

		// sleep
		Thread.sleep(5000);

		// exit
		driver.quit();
	}

}
