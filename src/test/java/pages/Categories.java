package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Categories extends  BasePage {

    private final static String CATEGORY_XPATH = "/html/body/main/header/div[2]/div/div[2]/div/div/div/div[1]/div/div/ul/li";//константа (после към този линк добавяме конкретен айтем)
    private final static String PRODUCT_CATEGORY_XPATH = "/html/body/main/section/div/div/div[2]/section/section/div[3]/div/div[1]/article";//константа (после към този линк добавяме конкретен айтем)
    private final static String CHECKOUT_BTN = "/html/body/main/header/div[2]/div/div[1]/div[2]/div[2]/div/div[1]";//константа

    @FindBy(xpath = "//span[text()=\"Разбрах\"] ")
    private WebElement agreeBtn;


    public Categories(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectCategoryAndItemFromCategory(String categoryXpath, String itemXPath){

        if (agreeBtn.isDisplayed()){
            agreeBtn.click();
        }

        WebElement selectCategory = driver.findElement(By.xpath(CATEGORY_XPATH + categoryXpath)); //към константата добавяме конкретен айтем
        selectCategory.click();
        WebElement itemFromCategoryToBeSelected = driver.findElement(By.xpath(PRODUCT_CATEGORY_XPATH + itemXPath));
        itemFromCategoryToBeSelected.click();
    }

    //по className:
    public void selectItemFromCategoryByClass(String itemClass){

        if (agreeBtn.isDisplayed()){
            agreeBtn.click();
        }
        WebElement itemFromCategoryToBeSelected = driver.findElement(By.className(itemClass));
        itemFromCategoryToBeSelected.click();
    }



}
