package sample_project;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

WebDriverManager.chromedriver().setup(); // Automatically downloads and sets path
WebDriver driver = new ChromeDriver();
driver.get("https://testautomationcentral.com/demo/checkboxes.html");

try {
// Try switching to the alert
Alert alert = driver.switchTo().alert();
System.out.println("Alert found: " + alert.getText());
alert.accept(); // or alert.dismiss();
System.out.println("Alert closed.");
} catch (NoAlertPresentException e) {
// No alert found, continue with the rest of the code
System.out.println("No alert present. Continuing...");}
String header=driver.findElement(By.xpath("//h2[contains(text(),'Checkboxes')]")).getText();
String actualHeader = "Checkboxes";
if(header.equals(actualHeader)) {
	System.out.println("Assertion match");
}
else {
	throw new RuntimeException("Assertion failed: text does not contain 'Expected'"); 
}
List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
int num = checkboxes.size();
System.out.println("number of checkboxes are : "+num);
driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::span[text()='Option 1']")).click();
List<WebElement> styledCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::span[contains(text(),'Styled Option')]"));
for(WebElement a:styledCheckboxes) {
	a.click();
}
driver.close();

	}

}
