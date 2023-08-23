package QA.Core;


import com.codeborne.selenide.*;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverBuilder {

    private WebDriver driver;

    //Add the different browser name and configurations

    public void builder(String browserName){

        try {

            switch (browserName) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*", "start-maximized");
                    WebDriverManager.chromedriver().setup();
                    this.driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    WebDriverRunner.setWebDriver(driver);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("start-maximized", "--remote-allow-origins=*");
                    WebDriverManager.firefoxdriver().setup();
                    this.driver = new FirefoxDriver(firefoxOptions);
                    WebDriverRunner.setWebDriver(driver);
                    break;

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("start-maximized", "--remote-allow-origins=*");
                    WebDriverManager.edgedriver().setup();
                    this.driver = new EdgeDriver(edgeOptions);
                    WebDriverRunner.setWebDriver(driver);
                    break;


                default:
                    WebDriverManager.chromedriver().setup();
                    this.driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    WebDriverRunner.setWebDriver(driver);
                    break;
            }

        }catch (Exception e){

            System.out.println("Error building the web driver: " + e);

        }

    }

    public void closeWebDriver(){

        WebDriverRunner.closeWebDriver();

    }

    public void navigateOption(String url){

        Selenide.open(url);

    }



}
