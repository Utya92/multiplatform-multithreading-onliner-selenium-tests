package project.common;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;
import static project.common.Config.BROWSER;
import static project.common.Config.FULLSCREEN;
import static project.constants.ConfigConstants.CHROME_KEY;
import static project.constants.ConfigConstants.CHROME_LINUX_DRIVER;
import static project.constants.ConfigConstants.CHROME_MAC_DRIVER;
import static project.constants.ConfigConstants.CHROME_WIN_DRIVER;
import static project.constants.ConfigConstants.FIREFOX_KEY;
import static project.constants.ConfigConstants.FIREFOX_LINUX_DRIVER;
import static project.constants.ConfigConstants.FIREFOX_MAC_DRIVER;
import static project.constants.ConfigConstants.FIREFOX_WIN_DRIVER;
import static project.constants.WebConstants.WebDriverWaitConstants.IMPLICIT_WAIT;


public class CommonActions {


    public static WebDriver createWebdriver() {

        Map<String, Map<String, String>> browserToDrivers = getBrowserToDriversMap();

        String OS = getOS();
        String currentBrowser = getBrowser();
        Map<String, String> currentBrowserDrivers = browserToDrivers.get(currentBrowser);
        String currentDriver = currentBrowserDrivers.get(OS);
        System.setProperty(currentBrowser, currentDriver);
        WebDriver webDriver = currentBrowser.equals(CHROME_KEY) ? new ChromeDriver() : new FirefoxDriver();

        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        if (FULLSCREEN){
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    private static Map<String, Map<String, String>> getBrowserToDriversMap() {

        Map<String, Map<String, String>> browserToDrivers = new HashMap<>();
        Map<String, String> chrome = new HashMap<>() {{
            put("win", CHROME_WIN_DRIVER);
            put("mac", CHROME_MAC_DRIVER);
            put("unix", CHROME_LINUX_DRIVER);
        }};
        Map<String, String> firefox = new HashMap<>() {{
            put("win", FIREFOX_WIN_DRIVER);
            put("mac", FIREFOX_MAC_DRIVER);
            put("unix", FIREFOX_LINUX_DRIVER);
        }};
        browserToDrivers.put(CHROME_KEY, chrome);
        browserToDrivers.put(FIREFOX_KEY, firefox);
        return browserToDrivers;
    }

    private static String getBrowser() {
        if (Objects.equals(BROWSER, "CHROME")) {
            return CHROME_KEY;
        }
        if (Objects.equals(BROWSER, "FIREFOX")) {
            return FIREFOX_KEY;
        }
        return Assertions.fail("unknown browser " + BROWSER);
    }

    private static String getOS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) return "win";
        if (os.contains("mac")) return "mac";
        if (os.contains("lin")) return "unix";
        return Assertions.fail("unknown OS " + os);
    }
}

