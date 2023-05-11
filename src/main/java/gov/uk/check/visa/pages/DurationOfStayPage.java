package gov.uk.check.visa.pages;
/*
.DurationOfStayPage - nextStepButton, lessThanSixMonths, moreThanSixMonths locators and create methods
  'void selectLengthOfStay(String moreOrLess)' (Note: use switch statement for select moreOrLess stay) and
  'void clickNextStepButton()'
 */

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(id = "//input[@value='six_months_or_less']")
    WebElement lessThanSixMonths ;
    @CacheLookup
    @FindBy(id = "//input[@value='longer_than_six_months']")
    WebElement moreThanSixMonths;


    public void selectLengthOfStay(String moreOrLess){
        switch (moreOrLess){
            case "6 months or less":
                clickOnElement(lessThanSixMonths);
                break;
            case "longer than 6 month":
                clickOnElement(moreThanSixMonths);
                break;
        }
    }

    public void clickNextStepButton () {
        Reporter.log("click on continue" + nextStepButton.toString());
        mouseHoverToElementAndClick(nextStepButton);
        CustomListeners.test.log(Status.PASS,"click on continue");

    }


}
