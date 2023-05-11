package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage  extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[@class='gem-c-button govuk-button govuk-button--start']")
    WebElement startNowButton;

    public void clickStartNow(){
        Reporter.log("click on start Button"+ startNowButton.toString());
        mouseHoverToElementAndClick(startNowButton);
        CustomListeners.test.log(Status.PASS,"click on start button");
    }
}
