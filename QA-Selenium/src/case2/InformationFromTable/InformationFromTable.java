package case2.InformationFromTable;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformationFromTable {

	static double total = 0;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Adrian.Martin\\OneDrive - Solera Holdings, Inc\\Desktop\\Libreria Selenium\\chromedriver.exe");

		// load the website
		WebDriver driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_by_tax_revenue_to_GDP_ratio");
		driver.manage().window().minimize();

		// store the elements of the table
		List<WebElement> values = driver.findElements(By.xpath("//html/body/div[3]/div[3]/div[5]/div[1]/table[3]/tbody/tr/td[4]"));

		// iterate the List and convert the values from String into a double in order to add them all up 
		// (ignoring the 'N/A' values and deleting '$' from the values, otherwise is not going to be able to convert the values from String into double)
		for (WebElement v : values) {

			if(!v.getText().equalsIgnoreCase("n/a")) {
				
				String newV = v.getText().substring(1).replaceAll(",", "");
				double dValue = Double.parseDouble(newV);
				total += dValue;

			}
			
		}
		
		DecimalFormat dTotal = new DecimalFormat("#,000.00");
		System.out.println("The total sum is: $" + dTotal.format(total));

	}
	
}
