package com.yoshiking.sample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;

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

		// Capture
		TakesScreenshot ts = (TakesScreenshot) new Augmenter().augment(driver);
		try {
			FileUtils.moveFile(ts.getScreenshotAs(OutputType.FILE), new File("./junit/img-" + System.currentTimeMillis() + ".png"));
		} catch (WebDriverException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		// exit
		driver.quit();
	}

}
