package swetha.tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import swetha.TestComponents.BaseTest;
import swetha.pageobjects.CartPage;
import swetha.pageobjects.CheckoutPage;
import swetha.pageobjects.ConfirmationPage;
import swetha.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	
    @Test
    
    public void submitOrder() throws IOException, InterruptedException
    {
		
				String productName ="ZARA COAT 3";
				//LandingPage landingPage = launchApplication();
				ProductCatalogue productCatalogue= landingPage.loginApplication("jannu.saishveta@gmail.com", "Khanishk@11");
				List<WebElement> products = productCatalogue.getProductList();
  				productCatalogue.addProductToCart(productName);
  				CartPage cartPage = productCatalogue.goToCartPage();
  				Boolean match = cartPage.VerifyProductDisplay(productName);
				Assert.assertTrue(match);
				CheckoutPage checkoutPage= cartPage.goToCheckout();
				checkoutPage.SelectCountry("india");
				ConfirmationPage confirmationPage = checkoutPage.submitOrder();
				String confirmMessage = confirmationPage.getConfrimationMessage();
				Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
				
			}
}


