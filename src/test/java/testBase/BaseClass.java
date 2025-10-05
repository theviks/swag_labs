package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		//Loading config.properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
	p=new Properties();
	p.load(file);
	
	logger = LogManager.getLogger(this.getClass()); // log4j2
	
	// SetUp for Remote Environment Execution
	if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//OS
		if(os.equalsIgnoreCase("windows")) {
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("linux")) {
			capabilities.setPlatform(Platform.LINUX);
		}
		else if(os.equalsIgnoreCase("mac")) {
			capabilities.setPlatform(Platform.MAC);
		}
		else {
			System.out.println("NO MATCHING OS");
			return;
		}
		
		//Browser
		switch(br.toLowerCase()) {
		case "chrome" : 
			ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--disable-save-password-bubble");
            chromeOptions.addArguments("--disable-features=PasswordManagerOnboarding,PasswordManagerUI");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-geolocation");
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            capabilities.setBrowserName("chrome");
            break;
			
		case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
		case "firefox" : capabilities.setBrowserName("firefox"); break;
		default : System.out.println(" NO MATCHING BROWSER"); return;
		}
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	}
	
	//For Local Environment Execution
	if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		switch(br.toLowerCase()) {
		case "chrome" :
			
			ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-features=PasswordManagerOnboarding,PasswordManagerUI");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-geolocation");
            options.addArguments("--disable-blink-features=AutomationControlled");
            
			driver = new ChromeDriver(options); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid Browser name"); return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl")); // Reading URL from Properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}
	
}