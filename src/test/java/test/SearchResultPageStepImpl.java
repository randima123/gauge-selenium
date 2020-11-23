package test;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import util.driver.Driver;
import org.testng.Assert;
import page.HomePage;
import page.SearchResultPage;
import util.DataStoreProcessor;

import java.util.List;

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

    @Step("Search result <table>")
    public void validateSearchResult(Table table) {
        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            Assert.assertEquals(searchResultPage.getSearchResultNameByIndex(Integer.parseInt
                    (row.getCell(columnNames.get(0)))) , row.getCell(columnNames.get(1)));
            Assert.assertEquals(searchResultPage.getSearchResultPriceByIndex(Integer.parseInt
                    (row.getCell(columnNames.get(0)))) , row.getCell(columnNames.get(2)));
        }
    }

    @Step("No result found message is present")
    public void checkNoResultsFoundAlertMessage() {
        Assert.assertEquals(searchResultPage.getResultNotFoundMessage(),
                "No results were found for your search \""+DataStoreProcessor.
                        read("itemName", SCENARIO)+"\"");
    }
}
