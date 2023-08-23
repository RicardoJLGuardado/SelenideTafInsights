package QA.Utils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;


//Assertions Wrapper Methods

public class AssertionsMethods {

    SoftAssert softAssert = new SoftAssert();

    public void assertTrue(boolean flag, String message){

        Assert.assertTrue(flag, message);

    }

    public void assertFalse(boolean flag, String message){

        Assert.assertFalse(flag, message);

    }

    public void softAssertTrue(boolean flag, String message){

        softAssert.assertTrue(flag, message);
        softAssert.assertAll();

    }

    public void softAssertFalse(boolean flag, String message){

        softAssert.assertFalse(flag, message);
        softAssert.assertAll();

    }
    public void assertEquals(String actualMessage, String expectedMessage){
        softAssert.assertEquals(actualMessage, expectedMessage);
    }


}
