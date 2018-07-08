package MultiFactorAuth_Email;

import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mashape.unirest.http.exceptions.UnirestException;

public class EmailTest {
	private NadaEMailService nada;
	@SuppressWarnings("unused")
	private WebDriver driver;
	private IsMyEmailWorkingPage page;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		nada = new NadaEMailService();
		page = new IsMyEmailWorkingPage(driver);
	}

	@Test
	public void emailTest() throws JsonParseException, JsonMappingException, IllegalArgumentException, JSONException,
			UnirestException, IOException {
		page.goTo();
		page.checkEmail(nada.getEmailId());

		String emailId = nada.getEmailId();
		String emailContent = nada.getMessageWithSubjectStartsWith("IsMyEmailWorking").getText();
		System.out.println("Email ID=" + emailId);
		System.out.println(emailContent);

	}
}