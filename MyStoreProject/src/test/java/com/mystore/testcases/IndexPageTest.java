package com.mystore.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;


import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass{
	
	IndexPage indexPage ;
	
	@BeforeClass
	public void setup() {
		try {
			launchApp();
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
		
	@Test
	public void verifyLogo() throws Throwable {
		Log.startTestCase("IndexPageTest started");		
		indexPage= new IndexPage();
		boolean result= indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.startTestCase("IndexPageTest ended");		
	}
	
	@Test
	public void verifyTitle() {
		
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		
	}

	
}
