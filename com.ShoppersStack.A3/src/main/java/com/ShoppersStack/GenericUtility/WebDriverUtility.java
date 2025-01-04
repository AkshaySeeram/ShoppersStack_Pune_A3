package com.ShoppersStack.GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	
	JavaUtility javaUtility=new JavaUtility();

	public void selectByValue(WebElement element, String Value) {

		Select sel = new Select(element);
		sel.selectByValue(Value);

	}

	public void getScreenShotOfWebPage(WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenShotPath+javaUtility.getLocalDateTime()+".png");
		FileHandler.copy(temp, dest);

	}
	
	public void getScreenShotOfWebElement(WebElement element) throws IOException {
		
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(FrameWorkConstants.screenShotPath+javaUtility.getLocalDateTime()+".png");
		FileHandler.copy(temp, dest);
		
	}

}
