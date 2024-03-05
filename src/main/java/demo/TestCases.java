package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().browserVersion("122.0.6261.95").setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/ ");
        String title = driver.getCurrentUrl();
        String expected = "makemytrip";

        if (title.contains(expected)) {
            System.out.println("Title contains " + expected);
            
        }
        System.out.println("End Test case: testCase01");
       
    }

    public void testCase02() throws InterruptedException {

        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/");
        
        WebElement departureLocationButton = driver.findElement(By.id("fromCity"));
        departureLocationButton.click();
        WebElement departureLocationInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        departureLocationInput.sendKeys("blr");
        Thread.sleep(2000);
        WebElement departureLocationOption = driver.findElement(By.xpath("//div[@class='calc60']"));
        departureLocationOption.click();
        Thread.sleep(2000);

        WebElement arrivalLocationInput = driver.findElement(By.id("toCity"));
        arrivalLocationInput.sendKeys("del");
        Thread.sleep(2000);
        WebElement arrivalLocationOption = driver.findElement(By.xpath("//div[@class='calc60']"));
        arrivalLocationOption.click();
        Thread.sleep(2000);

        WebElement departureDate = driver.findElement(By.xpath("(//p[text()='29'])[2]/parent::div"));
        departureDate.click();
        WebElement searchButton = driver.findElement(By.xpath("//a[contains(@class,'primaryBtn')]"));
        searchButton.click();

        WebElement flightDetails = driver.findElement(By.xpath("(//div[@class='makeFlex'])[2]"));
        String flightDetailsData = flightDetails.getText();
        System.out.print("Flight details : " + flightDetailsData + " ");

        WebElement flightPrice = driver.findElement(By.xpath("//div[contains(@class,'clusterViewPrice')]"));
        String flightPriceAdult = flightPrice.getText();
        System.out.println("Flight Price:" + flightPriceAdult);

        System.out.println("End Test case: testCase02");
    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/ ");
        Thread.sleep(3000);
        driver.findElement(By.className("menu_Trains")).click();

        WebElement departureLocationButton = driver.findElement(By.id("fromCity"));
        departureLocationButton.click();
        WebElement departureLocationInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        departureLocationInput.sendKeys("ypr");
        Thread.sleep(3000);
        WebElement departureLocationOption = driver.findElement(By.xpath("//div[@class='makeFlex']"));
        departureLocationOption.click();
        Thread.sleep(2000);

        WebElement arrivalLocationInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        arrivalLocationInput.sendKeys("ndls");
        Thread.sleep(2000);
        WebElement arrivalLocationOption = driver.findElement(By.xpath("//div[@class='makeFlex']"));
        arrivalLocationOption.click();
        Thread.sleep(2000);

        WebElement departureDate = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
        departureDate.click();

        WebElement classOption = driver.findElement(By.xpath("//li[@data-cy='3A']"));
        classOption.click();

        WebElement searchButton = driver.findElement(By.xpath("//a[contains(@class,'primaryBtn')]"));
        searchButton.click();

        WebElement trainDetails = driver.findElement(By.xpath("//div[@class='flex train-info']"));
        String trainDetailsData = trainDetails.getText();
        System.out.println("Train details : " + trainDetailsData + " ");

        WebElement trainPrice = driver.findElement(By.xpath("//div[contains(@class,'ticket-price')]"));
        String price = trainPrice.getText();
        System.out.println("3AC train Price:" + price);

        System.out.println("End Test case: testCase03");
    }

    public void testCase04() throws InterruptedException {
        try {
            System.out.println("Start Test case: testCase04");
            driver.get("https://www.makemytrip.com/ ");
            Thread.sleep(3000);
            driver.findElement(By.className("menu_Buses")).click();

            WebElement departureLocationButton = driver.findElement(By.id("fromCity"));
            departureLocationButton.click();
            WebElement departureLocationInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
            departureLocationInput.sendKeys("bangl");
            Thread.sleep(3000);
            WebElement departureLocationOption = driver.findElement(By.xpath("//div[@class='makeFlex column']"));
            departureLocationOption.click();
            Thread.sleep(2000);

            WebElement arrivalLocationInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
            arrivalLocationInput.sendKeys("del");
            Thread.sleep(2000);
            WebElement arrivalLocationOption = driver.findElement(By.xpath("//div[@class='makeFlex column']"));
            arrivalLocationOption.click();
            Thread.sleep(2000);

            WebElement departureDate = driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
            departureDate.click();

            WebElement searchButton = driver.findElement(By.id("search_button"));
            searchButton.click();

            WebElement error = driver.findElement(By.xpath("//span[@class='error-title']"));
            String text = error.getText();
            String expected = "No buses found";
            if (text.equals(expected)) {
                System.out.println(text);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("End Test case: testCase04");
    }
   
}

// import java.util.concurrent.TimeUnit;

// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeDriverService;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.logging.LogType;
// import org.openqa.selenium.logging.LoggingPreferences;
// import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;


// public class TestCases {
//     ChromeDriver driver;
//     public TestCases()
//     {
//         System.out.println("Constructor: TestCases");

//         WebDriverManager.chromedriver().timeout(30).setup();
//         ChromeOptions options = new ChromeOptions();
//         LoggingPreferences logs = new LoggingPreferences();

//         // Set log level and type
//         logs.enable(LogType.BROWSER, Level.ALL);
//         logs.enable(LogType.DRIVER, Level.ALL);
//         options.setCapability("goog:loggingPrefs", logs);

//         // Set path for log file
//         System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

//         driver = new ChromeDriver(options);

//         // Set browser to maximize and wait
//         driver.manage().window().maximize();
//         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//     }

//     public void endTest()
//     {
//         System.out.println("End Test: TestCases");
//         driver.close();
//         driver.quit();

//     }

    
//     public  void testCase01(){
//         System.out.println("Start Test case: testCase01");
//         driver.get("https://www.google.com");
//         System.out.println("end Test case: testCase02");
//     }


// }
