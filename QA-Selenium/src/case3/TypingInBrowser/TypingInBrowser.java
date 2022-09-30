package case3.TypingInBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class TypingInBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adrian.Martin\\OneDrive - Solera Holdings, Inc\\Desktop\\Libreria Selenium\\chromedriver.exe");

		// load the website
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Adrian.Martin\\eclipse-workspace\\QA-Selenium\\resources\\keyspage.html");
		driver.manage().window().maximize();

		// find the place where the you have to type and click on it
		WebElement place = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/div/input"));
		place.click();
		
		try {
			
			// create the Robot object
			Robot r = new Robot();
			
			// type the letter 'H' and then the letter 'I' to get and 'hi'
			r.keyPress(KeyEvent.VK_H);
			r.keyRelease(KeyEvent.VK_H);
			Thread.sleep(750);
			
			r.keyPress(KeyEvent.VK_I);
			r.keyRelease(KeyEvent.VK_I);
			Thread.sleep(750);
			
			// then press 'ENTER' to introduce the values
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
			System.out.println("There's an error.");
		}
		
	}

}
