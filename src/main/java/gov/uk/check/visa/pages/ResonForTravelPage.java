package gov.uk.check.visa.pages;
/*
easonForTravelPage - nextStepButton, reasonForVisitList locators and create methods  'void selectReasonForVisit(String reason)'
  and  'void clickNextStepButton()'
 */

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ResonForTravelPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-form-group govuk-!-margin-bottom-6']")
    List< WebElement > reasonForVisitList;


    public void  clickNextStepButton(){
        Reporter.log("click on continue"+nextStepButton);
        clickOnElement(nextStepButton);
        CustomListeners.test.log(Status.PASS ,"click on continue");
    }
    public void selectReasonForVisit(String reason){
        Reporter.log("Reason for visit"+reason+nextStepButton.toString());
        switch (reason) {
            case "Tourism or visiting family and friends":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "Work, academic visit or business":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "Study":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "Transit (on your way to somewhere else)":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "Join partner or family for a long stay":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "Get married or enter into a civil partnership":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "Stay with your child, if they’re at school":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "Have medical treatment":
                clickOnElement(reasonForVisitList, reason);
                break;
            case "For official diplomatic or government business (including transit through the UK)":
                clickOnElement(reasonForVisitList, reason);
                break;
            default:
                System.out.println("No Reason");
        }
        CustomListeners.test.log(Status.PASS,"reason for visit" + reason);
    }


}



