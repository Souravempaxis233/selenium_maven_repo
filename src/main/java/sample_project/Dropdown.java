package sample_project;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup(); // Automatically downloads and sets path
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationcentral.com/demo/dropdown.html");

		try {
		// Try switching to the alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert found: " + alert.getText());
		alert.accept(); // or alert.dismiss();
		System.out.println("Alert closed.");
		} catch (NoAlertPresentException e) {
		// No alert found, continue with the rest of the code
		System.out.println("No alert present. Continuing...");}
		String Header = driver.findElement(By.xpath("//h2[contains(text(),'Dropdowns')]")).getText();
		String actualHeader = "Dropdowns";
		if(Header.equals(actualHeader)) {
			System.out.println("assertion matched");
		}
		else {
			throw new RuntimeException("assertiom failed");
		}
		//simple dropdown
		driver.findElement(By.xpath("//button[@data-target='simple-dropdown']")).click();
		WebElement simple=driver.findElement(By.xpath("(//select[@class='form-select block w-full mt-1'])[1]"));
		Select select1 = new Select(simple);
		List<WebElement> simpleDropdown=select1.getOptions();
		for(WebElement options:simpleDropdown) {
		System.out.println("all simple dropdown options are : "+options.getText());
		}
		select1.selectByIndex(1);
		Thread.sleep(2000);
		
		//styled dropdown
		driver.findElement(By.xpath("//button[@data-target='styled-dropdown']")).click();
		WebElement styled=driver.findElement(By.xpath("//div[@id='styled-dropdown']//select[contains(@class,'form-select block w-full mt-1')]"));
		Select select2 = new Select(styled);
		List<WebElement> styledDropdown=select2.getOptions();
		for(WebElement options:styledDropdown) {
		System.out.println("all styled dropdown options are : "+options.getText());
		select2.selectByValue("option3");
		}
		Thread.sleep(2000);
		
		//grouped dropdown
		driver.findElement(By.xpath("//button[@data-target='grouped-dropdown']")).click();
		WebElement grouped=driver.findElement(By.xpath("//div[@id='grouped-dropdown']//select[contains(@class,'form-select block w-full mt-1')]"));
		Select select3 = new Select(grouped);
		List<WebElement> groupedDropdown=select3.getOptions();
		for(WebElement options:groupedDropdown) {
		System.out.println("all grouped dropdown options are : "+options.getText());
		
		}
		
		driver.close();
		
	}
	
}
