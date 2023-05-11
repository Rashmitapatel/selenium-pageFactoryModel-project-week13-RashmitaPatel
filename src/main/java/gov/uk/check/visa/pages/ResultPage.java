package gov.uk.check.visa.pages;

import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ResultPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//*[@id='current-question']")
    WebElement resultPageLocator;
    public String getResultMessage(){
        return getTextFromElement(resultPageLocator);
    }
    public void confirmResultMassage(String expectedmessage){

        Assert.assertTrue(getResultMessage().contains(expectedmessage));

    }
}



