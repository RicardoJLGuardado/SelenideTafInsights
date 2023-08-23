package BaseTestsCases;

import QA.Core.WebDriverBuilder;
import QA.Utils.AssertionsMethods;
import QA.Utils.ReadProperties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestCase {

    protected AssertionsMethods assertions = new AssertionsMethods();
    protected ReadProperties generalProperties;
    private WebDriverBuilder driver = new WebDriverBuilder();

    @BeforeTest
    public void SetUpGeneralConfigurations(){

        try {
            generalProperties = ReadProperties.getInstance();

            driver.builder(generalProperties.getBrowser());
            driver.navigateOption(generalProperties.getUrl());


        }catch (Exception e){

            System.out.println("Error in the initialization: " + e);


        }
    }
    @AfterTest
    public void TearDownGeneralConfigurations(){

        try {

            driver.closeWebDriver();


        }catch (Exception e){

            System.out.println("Error closing the instance: " + e);

        }


    }
}
