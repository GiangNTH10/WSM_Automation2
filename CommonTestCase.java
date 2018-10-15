package WSMProject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public abstract class CommonTestCase {
	public static WebDriver driver = null;

	@BeforeTest
		public void beforeTest() {
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver", "C:\\Install\\Automation\\chromedriver_win32\\chromedriver.exe");			 
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://wsm.framgia.vn/en");
			driver.manage().window().maximize();
		}

	@AfterTest
	public void end() {
		driver.quit();
	}

	@DataProvider
	public static Object[][] SetLogin() {

		return new Object[][] { { "nguyen.thi.hieu.giang@framgia.com", "ThaoMi77" } };

	}

	public void testLogin(String email, String pass) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='wsm-btn btn-login']")));
		WebElement btnLogin = driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		btnLogin.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='user_email']"));
		txtEmail.sendKeys(email);

		WebElement txtPass = driver.findElement(By.xpath("//input[@id='user_password']"));
		txtPass.sendKeys(pass);

		WebElement buttonLogin = driver.findElement(By.xpath("//*[@id='devise-login-form']/div[@class='text-center pd-top-20']/button[@type='submit']"));
		buttonLogin.submit();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}