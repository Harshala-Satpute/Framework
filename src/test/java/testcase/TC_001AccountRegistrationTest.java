package testcase;


import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master1"})
	public void verifyAccountRegistratiob() 
	{
		try {
		logger.info("*********TC_001AccountRegistrationTest*********");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*********Clicked on click method*********");
		hp.clickRegister();
		logger.info("*********Clicked on Register method*********");
		AccountRegistrationPage account=new AccountRegistrationPage(driver);
		account.setFirstName("abc");
		account.setLastName("xyz");
		account.setEmail(randomeString()+"@gmail.com");
		account.setTelephone("9899888989");
		
		account.setPassword("Test@123");
		account.setConfirmPassword("Test@123");
		account.setPrivacyPolicy();
		account.clickContinue();
		
		logger.info("********Validating exact message********");
		String cmf=account.getConfirmationMsg();
		Assert.assertEquals(cmf,"Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();
			logger.info("********Test Finished********");
			
		}
		
	}
	
	public String randomeString() {
			String generatedstring=RandomStringUtils.randomAlphabetic(5);
			return generatedstring;
	}

}
