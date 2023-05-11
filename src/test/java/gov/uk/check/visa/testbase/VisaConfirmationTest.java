package gov.uk.check.visa.testbase;

import gov.uk.check.visa.pages.*;
import org.testng.ITestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ITestNGListener.class)
@Test(groups = {"smoke", "sanity", "regression"})
public class VisaConfirmationTest extends BaseTest {
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ResonForTravelPage resonForTravelPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    StartPage startPage;
    WorkTypePage workTypePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        resonForTravelPage = new ResonForTravelPage();
        resultPage = new ResultPage();
        selectNationalityPage = new SelectNationalityPage();
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
    }

    @Test(groups = {"regression"})
    public void anAustralianCominToUKForTourism() {
        //Accept cookies
        startPage.acceptCookies();
        // Click on start button
        startPage.clickStartNow();
        // Select a Nationality 'Australia'
        selectNationalityPage.selectNationality("Australiya");
        // Click on Continue button
        selectNationalityPage.clickNextStepButton();
        // Select reason 'Tourism'
        resonForTravelPage.selectReasonForVisit("Tourisam or visiting family and friends");
        // Click on Continue button
        resonForTravelPage.clickNextStepButton();
        // verify result 'You will not need a visa to come to the UK'
        resultPage.confirmResultMassage("you will not need a visa to come to the UK");
    }

    @Test(groups = {"sanity", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths() throws InterruptedException {
        //Accept cookies
        startPage.acceptCookies();
        // Click on start button
        startPage.clickStartNow();
        // Select a Nationality 'Chile'
        selectNationalityPage.selectNationality("Chile");
        //  Click on Continue button
        selectNationalityPage.clickNextStepButton();
        Thread.sleep(2000);
        // Select reason 'Work, academic visit or business'
        resonForTravelPage.selectReasonForVisit("Work, academic visit or business");
        //  Click on Continue button
        resonForTravelPage.clickNextStepButton();
        //   Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("longer than 6 month");
        //   Click on Continue button
        durationOfStayPage.clickNextStepButton();
        //    Select have planning to work for 'Health and care professional'
        workTypePage.setSelectJobType("Health and care professional");
        //    Click on Continue button
        workTypePage.clickNextStepButton();
        //  verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMassage("Health and care professional");
    }

    @Test(groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {

        //Accept cookies
        startPage.acceptCookies();
        //Click on start button
        startPage.clickStartNow();
        //Select a Nationality 'Columbia'
        selectNationalityPage.selectNationality("Colombia");
        //Click on Continue button
        selectNationalityPage.clickNextStepButton();
        //Select reason Join partner or family for a long stay'
        resonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");
        // Click on Continue button
        durationOfStayPage.clickNextStepButton();
        // Select state My partner of family member have uk immigration status 'yes'
        familyImmigrationStatusPage.selectImmigrationStatus("yes");
        // Click on Continue button
        workTypePage.clickNextStepButton();
        //verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.confirmResultMassage("You may need a visa");

    }

}
