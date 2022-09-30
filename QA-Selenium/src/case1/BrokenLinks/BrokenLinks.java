package case1.BrokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	static int pos = 0;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adrian.Martin\\OneDrive - Solera Holdings, Inc\\Desktop\\Libreria Selenium\\chromedriver.exe");
		
		// load the file from our computer
		WebDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Adrian.Martin\\eclipse-workspace\\QA-Selenium\\resources\\brokenLinks.html");
		driver.manage().window().minimize();
		
		// store the elements which contains an "a" tag
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		// iterate the List searching the attribute "href" in those elements that you've already stored in the List
		// and send them, one by one, to the 'verifyLink' method
		for (WebElement l : links) {
			
			verifyLink(l.getAttribute("href"));	
			
		}
		
	}
	
	public static void verifyLink(String url) {
		
		pos++;
		
		try {
			
			// try to connect to the URL opening the connection 
			URL u = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setConnectTimeout(2000);
			conn.connect();
			
		} catch (IOException e) {
			
			// if there's any error trying to get access to the website, 
			// then you print the position of the website in the list and the url of the website
			System.out.println("Position " + pos + ", URL: " + url);
			
		}
		
	}
	
}
