package com.ShoppersStack.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ShoppersStack.GenericUtility.BaseTest;
import com.ShoppersStack.POM.MyAddresses_Page;
import com.ShoppersStack.POM.MyProfile_Page;

public class Tc_002_Verify_User_Is_Able_To_Delete_Address_Or_Not_Test extends BaseTest{

	@Test
	public void deleteAddress() throws InterruptedException, IOException {
		
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfilePage=new MyProfile_Page(driver);
		myProfilePage.getMyAddressesBtn().click();
		
		MyAddresses_Page myAddressesPage=new MyAddresses_Page(driver);
		Thread.sleep(2000);
		myAddressesPage.getDeleteBtn().click();
		Thread.sleep(2000);
		myAddressesPage.getYesBtn().click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		webDriverUtility.getScreenShotOfWebPage(driver);
		
	}
	

}
