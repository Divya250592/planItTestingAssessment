import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserRelatedFunction.Base;
public class contact extends Base{
	
	

//***********TEST CASE 1 FOR VERIFYING ERROR MESSAGE*******
	
@Test
	public void ErrorMessageVerification() throws InterruptedException {
	
		WebElement contact_element = driver.findElement(By.linkText("Contact"));
		contact_element.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn-contact btn btn-primary' and text()='Submit']")).click();
		Thread.sleep(1000);
	
	//**********VERIFYING ERROR MESSAGE********
	
	if(driver.getPageSource().contains("We welcome your feedback")) {	
		System.out.println("The display error message is correct");	
	}
	else {
		System.out.println("The display error message is wrong");
	}
		WebElement forename_element = driver.findElement(By.id("forename"));
		forename_element.sendKeys("xyz");
		driver.findElement(By.id("surname")).sendKeys("abc");
		driver.findElement(By.id("email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("telephone")).sendKeys("1234567890");
		WebElement message_element = driver.findElement(By.id("message"));
		message_element.sendKeys("sfeferfdf");
		Thread.sleep(1000);
	}
//***********TEST CASE 2 FOR ENTERING DETAILS AND CLICKING ON SUBMIT BUTTON AND VERIFYING SUBMITION MESSAGE*******

@Test(invocationCount = 5,priority=1)
public void contact_submit() throws InterruptedException {
	
		driver.findElement(By.linkText("Contact")).click();
		String name = "divya";
		driver.findElement(By.id("forename")).sendKeys(name);
		driver.findElement(By.id("surname")).sendKeys("g");
		driver.findElement(By.id("email")).sendKeys("divyag@gmail.com");
		driver.findElement(By.id("telephone")).sendKeys("1234567890");
		driver.findElement(By.id("message")).sendKeys("hello");
		driver.findElement(By.xpath("//a[@class='btn-contact btn btn-primary' and text()='Submit']")).click();
		Thread.sleep(1000);
	//**********VERIFYING THE SUCESSFULL MESSAGE********
		String sucessfull_message = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String Actual_sucessfull_message = sucessfull_message;
		String Expected_message = "Thanks " +name+", we appreciate your feedback.";
		Assert.assertEquals(Actual_sucessfull_message, Expected_message);
		System.out.println("The display message is correct");
		Thread.sleep(1000);
}
//***********TEST CASE 3 FOR ADDING ITEMS TO CART AND VERIFYING EACH PRODUCT PRICE,SUBTOTAL AND FINAL TOTAL************

@Test(priority=2)
public void Shopping() throws InterruptedException {
		WebElement Shopping_element = driver.findElement(By.linkText("Start Shopping »")); 
		Shopping_element.click();
		Thread.sleep(1000);
		WebElement stuffedbunny_element = driver.findElement(By.xpath("//div[@class='products ng-scope']/child::ul/child::li[2]/child::div/child::p/child::a"));
		stuffedbunny_element.click();
		Thread.sleep(1000);
		stuffedbunny_element.click();
		Thread.sleep(1000);
		WebElement Fluffy_Bummy = driver.findElement(By.xpath("//div[@class='products ng-scope']/child::ul/child::li[4]/child::div/child::p/child::a"));
		Fluffy_Bummy.click();
		Thread.sleep(1000);
		Fluffy_Bummy.click();
		Thread.sleep(1000);
		Fluffy_Bummy.click();
		Thread.sleep(1000);
		Fluffy_Bummy.click();
		Thread.sleep(1000);
		Fluffy_Bummy.click();
		Thread.sleep(1000);
		WebElement Valentine_Bare = driver.findElement(By.xpath("//div[@class='products ng-scope']/child::ul/child::li[7]/child::div/child::p/child::a"));
		Valentine_Bare.click();
		Thread.sleep(1000);
		Valentine_Bare.click();
		Thread.sleep(1000);
		Valentine_Bare.click();
		Thread.sleep(1000);
		WebElement cart = driver.findElement(By.xpath("//a[@href='#/cart']")); 
		cart.click();
		Thread.sleep(1000);

	//*********Verifying the price of each product***********
		System.out.println("*****PRICE OF EACH PRODUCT*****");
		System.out.println("");
		WebElement stuffed_frog_price = driver.findElement(By.xpath("//div[2]/div/form/table/tbody/tr[1]/td[2]"));
		String Actual_PriceOf_StuffedFrog = stuffed_frog_price.getText();
		String Expected_PriceOf_StuffedFrog = "$10.99";
		Assert.assertEquals(Actual_PriceOf_StuffedFrog, Expected_PriceOf_StuffedFrog);
		System.out.println("price of a Stuffed Frog is "+ Actual_PriceOf_StuffedFrog);
	
		WebElement fluffu_bunny_price = driver.findElement(By.xpath("//div[2]/div/form/table/tbody/tr[2]/td[2]"));
		String Actual_PriceOf_FluffyBunny = fluffu_bunny_price.getText();
		String Expected_PriceOf_FluffyBunny = "$9.99";
		Assert.assertEquals(Actual_PriceOf_FluffyBunny,Expected_PriceOf_FluffyBunny);
		System.out.println("price of Fluffy Bunny is "+ Actual_PriceOf_FluffyBunny);
	
		WebElement valentine_bear_price = driver.findElement(By.xpath("//div[2]/div/form/table/tbody/tr[3]/td[2]"));
		String Actual_PriceOf_ValentineBear = valentine_bear_price.getText();
		String Expected_PriceOf_ValentineBear = "$14.99";
		Assert.assertEquals(Actual_PriceOf_ValentineBear,Expected_PriceOf_ValentineBear);
		System.out.println("price of Fluffy Bunny is "+ Actual_PriceOf_ValentineBear);
		System.out.println("");
	
/*
	//***************VERIFYING THE SUBTOTAL OF EACH PRODUCT****************
	
		String price = driver.findElement(By.xpath("//div[2]/div/form/table/tbody/tr[1]/td[2]")).getText();
		double Stuffef_frog_price = Double.parseDouble(price.substring(1));	
		WebElement quantity = driver.findElement(By.xpath("//div[@class = 'ng-scope']/child::form/child::table/child::tbody/child::tr[1]/child::td[3]"));
		String quan = quantity.getAttribute("value");
		int stuffed_frog_quantity = Integer.parseInt(quan);
		double subtotal = Stuffef_frog_price * stuffed_frog_quantity;
		System.out.println("Subtotal of stuffed frog: " + subtotal);
	*/
	
	
	//***************VERIFYING THE FINAL TOTAL****************
	
		String Product_1 = driver.findElement(By.xpath("//div[2]/div/form/table/tbody/tr[1]/td[4]")).getText();
		double Product_1_subtotal = Double.parseDouble(Product_1.substring(1));
		String Product_2 = driver.findElement(By.xpath("//div[2]/div/form/table/tbody/tr[2]/td[4]")).getText();
		double Product_2_subtotal = Double.parseDouble(Product_2.substring(1));
		String Product_3 = driver.findElement(By.xpath("//div[2]/div/form/table/tbody/tr[3]/td[4]")).getText();
		double Product_3_subtotal = Double.parseDouble(Product_3.substring(1));
		double sum = Product_1_subtotal + Product_2_subtotal + Product_3_subtotal;
		System.out.println("Total amount of all products: " + sum);
	
		String total= driver.findElement(By.xpath("//div[2]/div/form/table/tfoot/tr[1]/td/strong")).getText();
		String actual_sum = "Total: "+sum;
		Assert.assertEquals(actual_sum , total);
		System.out.println("Displaying the final total amount is correct");
		System.out.println("");
		
	
}



}


