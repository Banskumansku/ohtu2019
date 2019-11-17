package ohtu;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        String link = "http://localhost:4567";
        //succesfulLogin(link);
        //correctUserWrongPassword(link);
        createUser(link);
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

    private static void succesfulLogin(String link) {
        WebDriver driver = new ChromeDriver();

        driver.get(link);

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.quit();
    }

    private static void correctUserWrongPassword(String link) {
        WebDriver driver = new ChromeDriver();

        driver.get(link);

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("asd");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.quit();
    }

    public static void createUser(String link) {
        WebDriver driver = new ChromeDriver();
        Random r = new Random();
        driver.get(link);
        sleep(1);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka" + r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("vahvasalis1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("vahvasalis1");

        sleep(2);

        element = driver.findElement(By.name("signup"));
        element.click();

        sleep(2);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);

        element = driver.findElement(By.linkText("logout"));

        sleep(2);
        driver.quit();
    }
}
