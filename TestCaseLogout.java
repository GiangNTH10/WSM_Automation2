package WSMProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCaseLogout extends CommonTestCase {
	// Check msg Signed out successfully.
	@Test(priority = 1, dataProvider = "SetLogin")
	public void testMsgLogoutsuccessfully(String email, String pass) {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement userPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a/img[@alt='User avatar default']")));

		userPhoto.click();
		
		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();
		
		WebElement msg_LogOut = driver.findElement(By.xpath("//*[@id='flash-message']"));
		
		assertEquals(msg_LogOut.getText(), "Signed out successfully.");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Check Login screen
	@Test(priority = 2, dataProvider = "SetLogin")
	public void testLoginScreen(String email, String pass) {
		super.testLogin(email, pass);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement userPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a/img[@alt='User avatar default']")));

		userPhoto.click();
		
		WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		btn_logOut.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='wsm-btn btn-login']")));
		WebElement buttonLogin = driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']"));		
		assertTrue(buttonLogin.isDisplayed());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Check auth
		@Test(priority = 3, dataProvider = "SetLogin")
		public void testAuth(String email, String pass) {
				super.testLogin(email, pass);
				WebDriverWait wait = new WebDriverWait(driver, 10);
				WebElement userPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//a/img[@alt='User avatar default']")));

				userPhoto.click();
				
				WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
				btn_logOut.click();
				driver.get("https://wsm.framgia.vn/en/dashboard/user_settings/edit");
				WebElement msg_Auth = driver.findElement(By.xpath("//*[@id='flash-message']"));
				
				assertEquals(msg_Auth.getText(), "You need to sign in or sign up before continuing.");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
		// Check navigation another screen
				@Test(priority = 4, dataProvider = "SetLogin")
				public void testAnotherScreen(String email, String pass) {
						super.testLogin(email, pass);
						WebDriverWait wait = new WebDriverWait(driver, 10);
						driver.get("https://wsm.framgia.vn/en/dashboard/import_timesheets");
						WebElement userPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//a/img[@alt='User avatar default']")));

						userPhoto.click();
						
						WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
						btn_logOut.click();
						
						WebElement msg_LogOut = driver.findElement(By.xpath("//*[@id='flash-message']"));
						assertEquals(msg_LogOut.getText(), "Signed out successfully.");
						
						;wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='wsm-btn btn-login']")));
						WebElement buttonLogin = driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']"));		
						assertTrue(buttonLogin.isDisplayed());
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				
				// Check Back button
				@Test(priority = 5, dataProvider = "SetLogin")
				public void testBackButton(String email, String pass) {
					super.testLogin(email, pass);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					WebElement userPhoto = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//a/img[@alt='User avatar default']")));

					userPhoto.click();
					
					WebElement btn_logOut = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
					btn_logOut.click();
					driver.navigate().back();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='wsm-btn btn-login']")));
					WebElement buttonLogin = driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']"));		
					assertTrue(buttonLogin.isDisplayed());
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				

}