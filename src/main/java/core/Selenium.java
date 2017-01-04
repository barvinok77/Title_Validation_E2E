package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	
	public String[][] array2d() throws IOException {
		
		String csvFile = "src/main/resources/Title_Validation.csv";
		BufferedReader br = null;
		String line = null;
		String[] column = null;
		int lines = 0;
		int columns = 0;
		String splitBy = ",";
		String test_case_id = null;
		String url = null;
		String title_expected = null;
		
		//Counting lines and columns
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			lines++;
			column = line.split(splitBy);
			columns = column.length;
		}
		br.close();
		
		String string2d[][] = new String[lines][columns];
		br = new BufferedReader(new FileReader(csvFile));
		WebDriver driver = new FirefoxDriver();
		int i = 0;
		while((line = br.readLine()) != null) {
			
			String[] csv = line.split(splitBy);
			
			test_case_id = csv[0];
			url = csv[1];
			title_expected = csv[2];
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String title_actual = driver.getTitle();
			
			string2d[i][0] = test_case_id;
			string2d[i][1] = title_expected;
			string2d[i][2] = title_actual;
			i++;
		}
		driver.quit();
		br.close();
		return string2d;
	}
	
	public static void main(String[] args) throws IOException {
		core.Selenium selenium = new core.Selenium();
		selenium.array2d();
	}
}
