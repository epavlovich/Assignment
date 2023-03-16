package ui_automation.utilities;

import org.openqa.selenium.WebDriver;

public class Driver {
    // 1st create a private constructor
    private Driver(){

    }

    // 2nd create a private instance with return type as Class which is Driver
    private static Driver instance=new Driver();

    // 3rd static method with return type as object of class which is Driver
    public static Driver getInstance(){
        return instance;
    }

    // ThreadLocal will handle even if you have parallel execution
    ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();// thread local driver object for webdriver

    public WebDriver getDriver(){
        // get() is coming from ThreadLocal
        return driver.get();
    }

    public  void setDriver(WebDriver driverParameter){
        // set() is coming from ThreadLocal
        driver.set(driverParameter);
    }
    public void removeDriver(){
        // in order to quit you need to use get() and then quit bc we need to quit for specific thread
        driver.get().quit();
        // remove() is coming from ThreadLocal, we just make sure it will get deleted properly
        driver.remove();
    }
}