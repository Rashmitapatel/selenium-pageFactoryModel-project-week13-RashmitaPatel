package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@class='gem-c-button govuk-button gem-c-button--bottom-margin']")
    WebElement nextStepButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-form-group govuk-!-margin-bottom-6']")
    List<WebElement> selectJobtypeList;

    public void clickNextStepButton() {
        Reporter.log("click on continue" + nextStepButton);
        mouseHoverToElementAndClick(nextStepButton);
        CustomListeners.test.log(Status.PASS, "click on continue");
    }

    public void setSelectJobType(String job) {
        Reporter.log("select job Type" + job + nextStepButton.toString());
        switch (job) {
            case "Tourism or visiting family and friends":
                clickOnElement(selectJobtypeList, job);
                break;
            case "Work, academic visit or business":
                clickOnElement(selectJobtypeList, job);
                break;
            case "Study":
                clickOnElement(selectJobtypeList, job);


            case "Join partner or family for a long stay":
                clickOnElement(selectJobtypeList, job);
                break;

            case "Get married or enter into a civil partnership":
                clickOnElement(selectJobtypeList, job);
                break;

            case "Stay with your child, if they’re at school":
                clickOnElement(selectJobtypeList, job);
                break;

            case "Have medical treatment":
                clickOnElement(selectJobtypeList, job);
                break;
            case "For official diplomatic or government business (including transit through the UK)":
                clickOnElement(selectJobtypeList, job);
                break;
            default:
                System.out.println("No job type");

        }
        CustomListeners.test.log(Status.PASS,"select work type:"+job);

    }


}
