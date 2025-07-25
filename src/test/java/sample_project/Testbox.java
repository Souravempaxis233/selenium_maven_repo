package sample_project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); // Automatically downloads and sets path
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationcentral.com/demo/textboxes.html");
		driver.manage().window().maximize();

		try {
		// Try switching to the alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert found: " + alert.getText());
		alert.accept(); // or alert.dismiss();
		System.out.println("Alert closed.");
		} catch (NoAlertPresentException e) {
		// No alert found, continue with the rest of the code
		System.out.println("No alert present. Continuing...");}
		
	driver.findElement(By.xpath("//button[@data-target=\"simple-textbox\"]")).click();
WebElement simple = driver.findElement(By.xpath("//div[@id='simple-textbox']//input[@placeholder=\"Enter text\"]"));
		simple.sendKeys("entered text");
		Thread.sleep(2000);
		driver.close();
	}

}
