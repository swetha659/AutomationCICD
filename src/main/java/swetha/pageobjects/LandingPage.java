package swetha.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swetha.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	private WebDriver driver;

	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		//WebElement userEmail = driver.findElement(By.id("userEmail"));
		
		//pageFactory
		
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		@FindBy(id="login")
		WebElement submit;

	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}
