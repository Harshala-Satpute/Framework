package testcase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;   //log4j
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
		public Logger logger;
		public Properties p;

		@BeforeClass
		@Parameters({"os", "browser"})
		public void setup(String os, String br) throws IOException
	
		{
			FileReader file=new FileReader("./src//test//resources//config.properties");
			p=new Properties();
			p.load(file);
			
			
			logger= LogManager.getLogger(this.getClass());
			
			
			switch(br.toLowerCase()) {
			case "chrome": driver=new ChromeDriver(); break;
			default: System.out.println("Invlid Browser"); 
			driver=new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get(p.getProperty("appurl"));
			
		}
		
		@AfterClass
		void teardown() 
		{
			driver.close();
		}

	}


