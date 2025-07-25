package sample_project;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); // Automatically downloads and sets path
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationcentral.com/demo/radiobuttons.html");

		try {
		// Try switching to the alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert found: " + alert.getText());
		alert.accept(); // or alert.dismiss();
		System.out.println("Alert closed.");
		} catch (NoAlertPresentException e) {
		// No alert found, continue with the rest of the code
		System.out.println("No alert present. Continuing...");}
		
		String header = driver.findElement(By.xpath("//h2[contains(text(),'Radio Buttons')]")).getText();
		String actualHeader="Radio Buttons";
		if(header.equals(actualHeader)) {
			System.out.println("assertion passed");
		}
		else {
			 throw new RuntimeException("assertion failed"); 
		}
		List<WebElement> ele = driver.findElements(By.xpath("//label[@class='simple-radio-container']//input[@type='radio']"));
		System.out.println("number of simple radio box : "+ele.size());
		driver.findElement(By.xpath("(//label[@class='simple-radio-container']//input[@type='radio'])[2]")).click();
		
		driver.close();
	}

}
