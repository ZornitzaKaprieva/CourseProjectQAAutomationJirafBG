package tests.pom;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class LogInTestCorrectCredentials extends TestUtil { // инициализираме драйвъра


    @Test (dataProvider = "correctCredentials")//управляваме през тестовите данни (през самите параметри)

    public void successfulLogin(String email, String password) {

        HomePage homePage = new HomePage(driver); //един page, един обект
        homePage.goToLogin();

        WebElement emailField = driver.findElement(By.name("email"));
        Assert.assertTrue(emailField.isDisplayed(), "Email Link was not displayed");


        LogInPage logInPage = new LogInPage(driver);
        //MyProfilePage myProfilePage = logInPage.login(email, password); // сега не е нужно, нямаме тестове с MyProfilePage: ако нямаме това = трябват асършани

        logInPage.login(email, password);

        WebElement myProfileContent = driver.findElement(By.id("content"));
        Assert.assertTrue(myProfileContent.isDisplayed(), "Мy Profile content was not displayed");

    }


//        @DataProvider(name = "correctCredentials") //името на DataProvider, който ще използваме
//        public static Object[][] readCorrectCredentialsFromCsv(){
//            try{
//                CSVReader csvReader = new CSVReader(new FileReader("src/test/resources/correctCredentials.csv")); // има ексепшън, който трябва да хванем (IOException)
//                List<String[]> csvData = csvReader.readAll();// методът csvReader.readAll(); също има ексепшън, който трябва да хванем
//                Object[][] csvDataObject = new Object[csvData.size()][2]; //все едно това ни е броя на редовете в scv. В случая имаме само 2 стойности в scv, затова можем да ги хардкорнем, но не можем да хардкорнем редовете, защото те се променят
//
//                for (int i = 0; i < csvData.size(); i++) {
//                    csvDataObject[i] = csvData.get(i);
//                }
//                return csvDataObject;
//
//            }catch (IOException e){
//                System.out.println("Not possible to find CSV!");
//                return null;
//            } catch (CsvException e){
//                System.out.println("Something went wrong!");
//                return null;
//            }
//        }
}
