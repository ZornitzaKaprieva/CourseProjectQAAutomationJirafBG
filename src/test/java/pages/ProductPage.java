package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(className = "menu-wrapper")//(xpath = "/html/body/main/header/div[2]/div/div[2]")
    private WebElement menuWrapper;
    @FindBy(className = "add")//(xpath = "/html/body/main/section/div/div/div/section/div[2]/div[2]/div[3]/div[2]/form/div[2]/div[2]/div/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[6]/div/div/div[2]/div/div[2]/div/div/button")  //todo now
    private WebElement continueToShoppingButton;

    @FindBy(xpath = "/html/body/div[6]/div/div/div[2]/div/div[2]/div/div/a/i") //todo
    private WebElement goToCheckOutBtn;
    @FindBy(xpath = "/html/body/main/div/div/nav/ol/li[1]/a/span") //(className = "breadcrumb")//
    private WebElement homePageBtn;

    @FindBy (xpath = "/html/body/main/header/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/a/span[1]") //xpath = "/html/body/main/header/div[2]/div/div[1]/div[2]/div[2]/div/div[1]/a/span[1]" //span[@class='cart-products-count'] //(className = "cart-products-count")//
    WebElement cartBadge;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage goToHomePageAfterAddToCart(){
        addToCartButton.click();
        continueToShoppingButton.click();
        homePageBtn.click();
        return new HomePage(driver);
    }

    public HomePage goToHomePageAfterAddToCartByClickingOnProductPage(){
        addToCartButton.click();
        menuWrapper.click();
        homePageBtn.click();
        return new HomePage(driver);
    }


    //може би е по-логично е да е HomePage
    public String getHowManyItemsInTheCart(){
        //return Integer.parseInt(cartBadge.getText());
        return cartBadge.getText();
    }

    public CartPage goToCartFromProductPage(){
        addToCartButton.click();
        goToCheckOutBtn.click();
        return new CartPage(driver);
    }
}
