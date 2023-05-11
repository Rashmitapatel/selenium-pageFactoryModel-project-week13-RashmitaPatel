package gov.uk.check.visa.pages;
/*
FamilyImmigrationStatusPage - nextStepButton, yes, no locators and create methods 'void selectImmigrationStatus(String status)'
  (Note: Use switch statement for select immigration status) and 'void clickNextStepButton()'
 */

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "//button[@data-accept-cookies='true'']")
    WebElement yes;
    @CacheLookup
    @FindBy(xpath = "//button[@data-reject-cookies='true']")
    WebElement no;

    public void selectImmigrationStatus(String status) {
        switch (status) {
            case "yes":
                clickOnElement(yes);
                break;
            case "No":
                clickOnElement(no);
                break;
            default:
                System.out.println("");
        }
    }

    public void clickNextStepButton() {
        Reporter.log("click on continue" + nextStepButton.toString());
        mouseHoverToElementAndClick(nextStepButton);
        CustomListeners.test.log(Status.PASS, "click on continue");

    }
}