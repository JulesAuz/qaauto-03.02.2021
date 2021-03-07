import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SecondLesson {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        WebElement usernameField = driver.findElement(By.className("form_input"));
        WebElement passwordField = driver.findElement(By.xpath("//input[2]"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        List<WebElement> list = driver.findElements(By.className("btn_primary btn_inventory"));
        WebElement addToCart = list.get(1);
        addToCart.click();

        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);

        List<WebElement> listOfOptions = select.getOptions();
        for (WebElement listOfOption : listOfOptions)
            System.out.println(listOfOption.getText());

            select.selectByVisibleText("Name (Z to A)");
            addToCart = list.get(2);
            addToCart.click();

            driver.quit();

    }
}
