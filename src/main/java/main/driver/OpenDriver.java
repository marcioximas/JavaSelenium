package main.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.functions.Functions;
import main.selectors.Login;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class OpenDriver {
    public static String get_text;
    public static WebDriver driver;

   @Autowired
  public Functions action;

    @Autowired
   public Login login_selectors;


    public static String  propos(String path) throws IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream("src/main/resources/config.properties");
        prop.load(in);
        return prop.getProperty(path);
    }
    public static WebDriver page(String path) {
        if (driver != null) driver.quit();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get(path);
        return driver;
        }

        @AfterAll
        public static void close() {

        driver.quit();
        }

}
