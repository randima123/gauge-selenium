package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{

    private By searchResultsList = By.xpath("//div[@class='left-block']//div[@class='product-image-container']");
    private By resultNotFoundAlert = By.xpath("//p[contains(text(),'No results were found for your search')]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int getSearchResultCount() {
        return getElements(searchResultsList).size();
    }

    public String getSearchResultNameByIndex(int index) {
        return getElement(By.xpath("//ul[@class='product_list grid row']/descendant::div[@class='product-container']" +
                "["+index+"]//div[@class='right-block']//h5//a")).getText();
    }

    public String getSearchResultPriceByIndex(int index) {
        return getElement(By.xpath("//ul[@class='product_list grid row']/descendant::div[@class='product-container']" +
                "["+index+"]//div[@class='right-block']//span[@itemprop='price']")).getText();
    }

    public String getResultNotFoundMessage() {
        return getElement(resultNotFoundAlert).getText();
    }
}
