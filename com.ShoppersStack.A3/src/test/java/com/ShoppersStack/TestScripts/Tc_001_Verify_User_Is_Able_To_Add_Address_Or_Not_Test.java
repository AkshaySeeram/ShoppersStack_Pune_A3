package com.ShoppersStack.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ShoppersStack.GenericUtility.BaseTest;
import com.ShoppersStack.POM.AddressForm_Page;
import com.ShoppersStack.POM.MyAddresses_Page;
import com.ShoppersStack.POM.MyProfile_Page;

public class Tc_001_Verify_User_Is_Able_To_Add_Address_Or_Not_Test extends BaseTest{

	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		
		homePage.getAccountSettingsBtn().click();
		homePage.getMyProfileBtn().click();
		
		MyProfile_Page myProfilePage=new MyProfile_Page(driver);
		myProfilePage.getMyAddressesBtn().click();
		
		Thread.sleep(2000);
		MyAddresses_Page myAddressesPage=new MyAddresses_Page(driver);
		myAddressesPage.getAddAddressBtn().click();
		
		AddressForm_Page addressFormPage=new AddressForm_Page(driver);
		addressFormPage.getNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",1,0));
		addressFormPage.getHouseTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",1,1));
		addressFormPage.getStreetTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",1,2));
		addressFormPage.getLandMarkTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",1,3));
		
		webDriverUtility.selectByValue(addressFormPage.getCountryDD(),fileUtility.readDataFromPropertyFile("country"));
		Thread.sleep(2000);
		addressFormPage.getStateDD().sendKeys("Maharashtra");
//		webDriverUtility.selectByValue(addressFormPage.getStateDD(),fileUtility.readDataFromPropertyFile("state"));
		webDriverUtility.selectByValue(addressFormPage.getCityDD(),fileUtility.readDataFromPropertyFile("city"));
		
		addressFormPage.getPincodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",1,4));
		addressFormPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",1,5));
		addressFormPage.getAddAddressBtn().click();
		
		Thread.sleep(2000);
		webDriverUtility.getScreenShotOfWebPage(driver);
		Thread.sleep(10000);
		
	}
	
}
