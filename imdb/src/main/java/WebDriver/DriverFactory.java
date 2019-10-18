package WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Driver factory design pattern.
 * @author Idan Ben Moshe
 *
 */
public class DriverFactory {
	private static final Map<DriverType, Supplier<WebDriver>> driverMap = new HashMap<>();
	private final static String path = System.getProperty("user.dir");

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver.exe");
        return new ChromeDriver();
    };

    //firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", path + "/drivers/geckodriver.exe");
        return new FirefoxDriver();
    };
    
    //microsoft Edge driver supplier
    private static final Supplier<WebDriver> edgeDriverSupplier = () -> {
        System.setProperty("webdriver.edge.driver", path + "/drivers/msedgedriver.exe");
        return new EdgeDriver();
    };

    //add all the drivers into a map
    static{
        driverMap.put(DriverType.CHROME, chromeDriverSupplier);
        driverMap.put(DriverType.FIREFOX, firefoxDriverSupplier);
        driverMap.put(DriverType.EDGE, edgeDriverSupplier);
    }

    //return a new driver from the map
    public static final WebDriver getDriver(DriverType type){
        return driverMap.get(type).get();
    }
}
