package googleTestCases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import googlePages.googleSearch;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class googleStepDefs extends TestBase{
    private WebDriver driver;
     googleSearch google;

    @Before
    public void setUp() {
        driver = TestBase.getWebDriver();
    }


    @Given("open google website")
    public void openGoogleWebsite() {
        driver.navigate().to("https://www.google.com/");
    }


    @When("write a {string} in search engine")
    public void writeAInSearchEngine(String keyword) throws InterruptedException {
        google= new googleSearch(driver);
        google.searchForKeyword(keyword);


    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Then("number of results should be displayed")
    public void numberOfResultsShouldBeDisplayed() {
       Assert.assertTrue(google.getNumberOfResults().isDisplayed());
    }


    @Then("remove the {string} from search box")
    public void removeTheFromSearchBox(String keyword) {
        google.removeSearchedWord(keyword);
    }

    @Then("rewrite a {string} again and search with it")
    public void rewriteAAgainAndSearchWithIt(String keyword2) {
        google.searchForKeyword(keyword2);
    }

    @And("scroll down to the next page and click on it")
    public void scrollDownToTheNextPageAndClickOnIt() throws InterruptedException {
        google.scrollDownUntilNumberOfPages();
        WebElement resultNumber2=google.getNumberOfResults();
        System.out.println(resultNumber2);
    }


    @And("scroll down to page three")
    public void scrollDownToPageThree() {
        google.scrollDownToThirdPage();
        WebElement resultNumber3=google.getNumberOfResults();
        System.out.println(resultNumber3);
    }

    @Then("the number of search result in page two is equal to search result in page three")
    public void theNumberOfSearchResultInPageTwoIsEqualToSearchResultInPageThree() throws InterruptedException {
        google.scrollDownUntilNumberOfPages();
        String firstPageresult = google.getNumberOfResults().getText();
        String regex = "حوالي(.*?)من";
        java.util.regex.Pattern pattern1 = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher1 = pattern1.matcher(firstPageresult);
        google.scrollDownToThirdPage();
        String secondPageResult = google.getNumberOfResults().getText();
        java.util.regex.Matcher matcher2 = pattern1.matcher(secondPageResult);
        if (matcher1.find() && matcher2.find()) {
            String capturedText1 = matcher1.group(1).trim();
            String capturedText2 = matcher2.group(1).trim();
            Assert.assertEquals(capturedText1, capturedText2);
            System.out.println(capturedText1);
            System.out.println(capturedText2);

        } else {
            System.out.println("No match found in one or both strings.");
        }

    }

    @Then("scroll down to different suggestions displayed at the end of the page")
    public void scrollDownToDifferentSuggestionsDisplayedAtTheEndOfThePage() throws InterruptedException {
        google.scrollDownAndValidateSearchSuggestions();
        google.findSearchSuggestions();

    }
}
