import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherOnGitHubTest {

    /**
     * TC_11_01
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на пункт меню Guide
     * 3.  Подтвердить, что вы перешли на страницу со ссылкой
     * https://openweathermap.org/guide и что title этой страницы
     * OpenWeatherMap API guide - OpenWeatherMap
     */
    @Test
    public void testOpenAndClickGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String buttonGuide = "Guide";
        String expectedResult = "https://openweathermap.org/guide";
        String expectedResult1 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.manage().window().maximize();

        driver.get(url);

        Thread.sleep(5000);

        // create new Element
        WebElement ButtonGuide = driver.findElement(
                By.xpath("//a[@href='/guide']")
        );
        ButtonGuide.click();

        Thread.sleep(3000);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(3000);


        String actualResult1 = driver.getTitle();

        Assert.assertEquals(actualResult1, expectedResult1);

        driver.quit();
    }

    /**
     * TC_11_02
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     * 3.  Подтвердить, что температура для города показана в Фарингейтах
     */
    @Test
    public void testOpenAndClickImperial_TempInF() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        // String buttonImperial = "Imperial: °F, mph";
        String expectedResult = "Imperial: °F, mph";

        driver.manage().window().maximize();

        driver.get(url);

        Thread.sleep(5000);

        WebElement ButtonImperial = driver.findElement(
                By.xpath("//div[@class ='option'][2]")
        );

        ButtonImperial.click();

        // Test 1
        String actualResult = ButtonImperial.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_03
     * 1. Открыть базовую ссылку
     * 2. Подтвердить, что внизу страницы есть панель с текстом
     * “We use cookies which are essential for the site to work.
     * We also use non-essential cookies to help us improve our services.
     * Any data collected is anonymised. You can allow all cookies or manage them individually.”
     * 3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”
     */
    @Test
    public void testAllowAllAndManageCookies() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "We use cookies which are essential for the site to work. " +
                "We also use non-essential cookies to help us improve our services. Any data collected is anonymised. "
                + "You can allow all cookies or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";

        driver.manage().window().maximize();

        driver.get(url);

        Thread.sleep(1000);

        WebElement stickFooterPanel = driver.findElement(
                By.xpath("//div[@ class = 'stick-footer-panel']//p[@class= 'stick-footer-panel__description']")
        );

        Thread.sleep(1000);

        WebElement buttonAllowAll = driver.findElement(
                By.xpath("//button[@class = 'stick-footer-panel__link']")
        );

        Thread.sleep(1000);

        WebElement buttonManageCookies = driver.findElement(
                By.xpath("//a[@class = 'stick-footer-panel__link']")
        );

        // Test 1
        String actualResult = stickFooterPanel.getText();

        Assert.assertEquals(actualResult, expectedResult);


        // Test 2
        String actualResult1 = buttonAllowAll.getText();

        Assert.assertEquals(actualResult1, expectedResult1);


        // Test 3
        String actualResult2 = buttonManageCookies.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    /**
     * TC_11_04
     * 1.  Открыть базовую ссылку
     * 2.  Подтвердить, что в меню Support есть 3 подменю с названиями
     * “FAQ”, “How to start” и “Ask a question”
     */

    @Test
    public void testMenuSupportHasFAQ_HowToStart_AskAQuestion() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        //  String menuSupport =
        String expectedResult = "FAQ";
        String expectedResult1 = "How to start";
        String expectedResult2 = "Ask a question";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);

        WebElement menuSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        menuSupport.click();

        Thread.sleep(3000);

        WebElement dropDownSupportFaq = driver.findElement(
                By.xpath("//a[text() = 'FAQ']")
        );
        Thread.sleep(3000);
        //  dropDownSupport.click();

        WebElement dropDownSupportHowToStart = driver.findElement(
                By.xpath("//a[text() = 'How to start']"));
        Thread.sleep(3000);

        WebElement dropDownSupportAskAQuestion = driver.findElement(
                By.xpath("//a[text() = 'Ask a question']"));
        Thread.sleep(3000);

        // Test 1
        String actualResult = dropDownSupportFaq.getText();

        Assert.assertEquals(actualResult, expectedResult);

        // Test 2
        String actualResult1 = dropDownSupportHowToStart.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        // Test 2
        String actualResult2 = dropDownSupportAskAQuestion.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    /**
     * TC_11_05
     * 1. Открыть базовую ссылку
     * 2. Нажать пункт меню Support → Ask a question
     * 3. Заполнить поля Email, Subject, Message
     * 4. Не подтвердив CAPTCHA, нажать кнопку Submit
     * 5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
     */

    @Test
    public void testMenuSupport() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = "tester@test.com";
        String message = "Hello World!";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);

        WebElement menuSupport = driver.findElement(
                By.xpath("//ul[@id ='first-level-nav']//div[@id = 'support-dropdown']")
        );
        menuSupport.click();
        Thread.sleep(5000);

        WebElement dropdownAskAQuestion = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']")
        );
        dropdownAskAQuestion.click();
        Thread.sleep(5000);


        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        WebElement emailField = driver.findElement(
                By.id("question_form_email"));
        emailField.click();
        emailField.sendKeys("tester@test.com");
        Thread.sleep(1000);

        WebElement subjectField = driver.findElement(
                By.xpath("//select[@name='question_form[subject]']//option[2]"));
        subjectField.click();
        Thread.sleep(1000);

        WebElement messageField = driver.findElement(
                By.id("question_form_message")
        );
        messageField.click();
        messageField.sendKeys("Hello World!");
        Thread.sleep(1000);


        WebElement submitButton = driver.findElement(By.name("commit")
        );
        submitButton.click();
        Thread.sleep(1000);

        WebElement helpBlockText = driver.findElement(
                By.xpath("//div[@class='has-error']")
        );

        // Test 1
        String actualResult = helpBlockText.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_06
     * 1.  Открыть базовую ссылку
     * 2.  Нажать пункт меню Support → Ask a question
     * 3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
     * 4. Оставить пустым поле Email
     * 5. Заполнить поля  Subject, Message
     * 6. Подтвердить CAPTCHA
     * 7. Нажать кнопку Submit
     * 8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
     */
    @Test
    public void testMenuSupport2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String email = " ";
        String message = "Hello World!";
        String expectedResult = "can't be blank";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);

        WebElement menuSupport = driver.findElement(
                By.xpath("//ul[@id ='first-level-nav']//div[@id = 'support-dropdown']")
        );
        menuSupport.click();
        Thread.sleep(5000);

        WebElement dropdownAskAQuestion = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']")
        );
        dropdownAskAQuestion.click();
        Thread.sleep(5000);


        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }


        WebElement emailField = driver.findElement(
                By.id("question_form_email"));
        emailField.click();
        emailField.sendKeys(" ");
        Thread.sleep(1000);

//            WebElement subjectField = driver.findElement(
//                    By.id("question_form_subject")
//            );
        WebElement subjectField = driver.findElement(
                By.xpath("//select[@name='question_form[subject]']//option[2]"));
        subjectField.click();
        Thread.sleep(1000);

        WebElement messageField = driver.findElement(
                By.id("question_form_message")
        );
        messageField.click();
        messageField.sendKeys("Hello World!");
        Thread.sleep(1000);

        WebElement captchaField = driver.findElement(
                By.xpath("//div[@class='rc-anchor-center-item rc-anchor-checkbox-holder']")
        );
        captchaField.click();
        Thread.sleep(1000);

        WebElement submitButton = driver.findElement(By.name("commit")
        );
        submitButton.click();
        Thread.sleep(1000);

        WebElement helpBlockText = driver.findElement(
                By.xpath("//div[@class='has-error']")
        );

        // Test 1
        String actualResult = helpBlockText.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
//TC_11_06  CORRECT VARIANT

//    1.  Открыть базовую ссылку
//    2.  Нажать пункт меню Support → Ask a question
//    3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//    4.  Оставить пустым поле Email
//    5.  Заполнить поля  Subject, Message
//    6.  Подтвердить CAPTCHA
//    7.  Нажать кнопку Submit
//    8.  Подтвердить, что в поле Email пользователю будет показана ошибка "can't be blank"

    @Test
    public void testErrorEmail7() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String subject = "Other";
        String message = "Hi Lilu we are waiting for you";

        String expectedResult = "can't be blank";


        driver.get(url);

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement clickOnSupport = driver.findElement(By.xpath("//div[@id='support-dropdown']"));
        clickOnSupport.click();

        String originalWindow = driver.getWindowHandle();
        Thread.sleep(4000);
        WebElement selectSubmenu_AskAQuestion = driver.findElement(By.xpath(
                "//ul[@id='support-dropdown-menu']//a[@href='https://home.openweathermap.org/questions']"));
        selectSubmenu_AskAQuestion.click();

        Thread.sleep(4500);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(3000);

        WebElement enterSubject = driver.findElement(By.xpath(
                "//select[@class='form-control select required']"));

        enterSubject.click();

        enterSubject.sendKeys(subject);

        Thread.sleep(4000);

        WebElement enterMessage = driver.findElement(By.xpath(
                "//textarea[@class='form-control text required']"));
        enterMessage.click();
        enterMessage.sendKeys(message);

        Thread.sleep(5000);

        String window2 = driver.getWindowHandle();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));

        WebElement enterCaptcha = driver.findElement(By.xpath(
                "//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked "
                        + "rc-anchor-checkbox']"));
        enterCaptcha.click();

        Thread.sleep(10000);

        driver.switchTo().window(window2);

        WebElement pressSubmit = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"));
        pressSubmit.click();

        WebElement confirmErrorEmail = driver.findElement(By.xpath("//span[@class='help-block']"));

        String actualResult = confirmErrorEmail.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
    /**
     * TC_11_07
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     * 3.  Нажать на единицы измерения Metric: °C, m/s
     * 4.  Подтвердить, что в результате этих действий, единицы измерения
     * температуры изменились с F на С
     */

    @Test
    public void testOpenAndClickMetric_TempInC() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "Metric: °C, m/s";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);

        WebElement metricButton = driver.findElement(
                By.xpath("//div[@class ='option'][1]")
        );
        metricButton.click();

        // Test 1
        String actualResult = metricButton.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_08
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на лого компании
     * 3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась
     */
    @Test
    public void testLogoOfCompanyNotChange_ReloabWeb() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "logo";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(5000);

        WebElement logoButton = driver.findElement(
                By.xpath("//li[@class='logo']")
        );
        logoButton.click();
        Thread.sleep(5000);

        WebElement checkLogoButtonAfterReload = driver.findElement(
                By.xpath("//nav[@id='nav-website']//li[@class='logo']")
        );
        Thread.sleep(5000);

        // Test 1
        String actualResult = checkLogoButtonAfterReload.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_09
     * 1.  Открыть базовую ссылку
     * 2.  В строке поиска в навигационной панели набрать “Rome”
     * 3.  Нажать клавишу Enter
     * 4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся
     * слова “find” и “Rome”
     * 5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”
     */

    @Test
    public void testNewPageHas_Rome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\AdminOK\\IdeaProjects\\Weather\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/find?q=Rome";
        String expectedResult2 = "Rome";

        driver.manage().window().maximize();
        driver.get(url);
        Thread.sleep(3000);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id='desktop-menu']//input[@placeholder='Weather in your city']")
        );
        searchButton.click();
        Thread.sleep(3000);

        searchButton.sendKeys("Rome");
        //Thread.sleep(3000);

        // searchButton.sendKeys(Keys.chord(Keys.SHIFT));
        searchButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(3000);

        String searchRomeButton = driver.findElement(
                By.xpath("//input[@class]")).getAttribute("value");

        // Test 1
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(1000);

        // Test 2
        String actualResult2 = searchRomeButton;

        Assert.assertEquals(actualResult2, expectedResult2);


        driver.quit();


    }

// WebDriverWait wait = new WebDriverWait(driver, 25);
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
//                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
//        Thread.sleep(5000);


// 11

    @Test
    public void testDeskTopMenuClickAPIFind30Buttons1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();
        int expectedResult = 30;
        Thread.sleep(5000);

        WebElement element = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//a[text()= 'API']"));
        element.click();

        int countButton = driver.findElements(
                By.xpath("//a[contains(@class, 'btn_block orange round') " +
                        "or contains(@class, 'ow-btn round btn-orange') ]")).size();

        int actualResult = countButton;

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }
}
