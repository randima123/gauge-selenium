package test;

import com.thoughtworks.gauge.Step;
import util.driver.Driver;
import org.testng.Assert;
import page.HomePage;
import page.SearchResultPage;
import util.DataStoreProcessor;

import static util.DataStoreProcessor.DataStoreType.SCENARIO;

public class SearchResultPageStepImpl {

    private SearchResultPage searchResultPage = new SearchResultPage(Driver.webDriver);
    private HomePage homePage = new HomePage(Driver.webDriver);

    @Step("Enter search item name <itemName>")
    public void enterSearchItemName(String itemName) {
        homePage.enterSearchItem(itemName);
        DataStoreProcessor.save(itemName,"itemName", SCENARIO);
    }

    @Step("Click on search button")
    public void clickOnSearchButton() {
        homePage.clickOnSearchButton();
    }

    @Step("User sees search results")
    public void getSearchResultCount() {
        Assert.assertTrue(searchResultPage.getSearchResultCount() > 0 , "No search results returned");
    }

    @Step("First search result name is <name> and price is <price>")
    public void checkSearchNameAndPrice(String name, String price) {
       Assert.assertEquals(searchResultPage.getFirstSearchResultName() , name);
       Assert.assertEquals(searchResultPage.getFirstSearchResultPrice(), price);
    }

    @Step("No result found message is present")
    public void checkNoResultsFoundAlertMessage() {
        Assert.assertEquals(searchResultPage.getResultNotFoundMessage(),
                "No results were found for your search \""+DataStoreProcessor.
                        read("itemName", SCENARIO)+"\"");
    }
}
