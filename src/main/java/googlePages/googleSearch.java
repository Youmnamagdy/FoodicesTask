package googlePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class googleSearch extends landingPage {

    public googleSearch(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "APjFqb")
    WebElement searchBox;
    @FindBy(id = "result-stats")
    WebElement numberOfResults;
    @FindBy(xpath = "//*[@id=\"botstuff\"]/div/div[3]/h1")
    WebElement pageBottomHeader;
    @FindBy(xpath = "//*[@id=\"bres\"]/div/div/div/div/div[2]")
    List<WebElement> searchSuggestions;


    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public List<WebElement> getSearchSuggestions() {
        return searchSuggestions;
    }

    public void searchForKeyword(String keyword) {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("APjFqb")));
        searchBox.sendKeys(keyword);
        searchBox.submit();

    }

    public WebElement getNumberOfResults() {
        By resultsLocator = By.id("result-stats");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement resultsElement = wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));
        return resultsElement;
    }

    public void removeSearchedWord(String keyword) {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("APjFqb")));
        searchBox.clear();
    }

    public void scrollDownUntilNumberOfPages() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        WebElement footer = driver.findElement(By.xpath("//*[@id=\"botstuff\"]/div/div[3]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", footer);
        WebElement secondPageLink = driver.findElement(By.linkText("2"));
        secondPageLink.click();
        getNumberOfResults().getText();
    }

    public void scrollDownToThirdPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        WebElement footer = driver.findElement(By.xpath("//*[@id=\"botstuff\"]/div/div[3]/h1"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", footer);
        WebElement secondPageLink = driver.findElement(By.linkText("3"));
        secondPageLink.click();
    }

    public void searchResultPg2() {
        getNumberOfResults().getText();
        return;
    }

    public void searchResultInPageThree() {
        getNumberOfResults().getText();
    }

    public List<WebElement> findSearchSuggestions() {
        By searchSuggestionsLocator = By.xpath("//*[@id=\"bres\"]/div/div/div/div/div[2]/div");
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchSuggestionsLocator));
    }

    public void scrollDownAndValidateSearchSuggestions() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> searchSuggestions = findSearchSuggestions();
        if (searchSuggestions != null && !searchSuggestions.isEmpty()) {
            Set<String> suggestionTexts = new HashSet<>();
            for (WebElement suggestion : searchSuggestions) {
                suggestionTexts.add(suggestion.getText());
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


            }}}

        }








