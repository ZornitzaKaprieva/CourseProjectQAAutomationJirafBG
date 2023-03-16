package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BasePage {

    //homeBtn
    @FindBy (xpath = "//*[@id=\"my-account\"]/main[1]/div[1]/div[1]/nav[1]/ol[1]/li[1]/a[1]/span[1]") //(xpath = "/html/body/main/div/div/nav/ol/li[1]/a/span")//todo new
    private WebElement homePageBtn;


    public MyProfilePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage goToHomePage(){
        homePageBtn.click();
        return new HomePage(driver);
    }

}


