package com.incompetent.tester.automation.driver;

import com.incompetent.tester.automation.events.Browser;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class UIDriver {

    public WebDriver getStandaloneBrowser(Browser browser){
        switch(browser){
            case CHROME:
                return Browser.CHROME.getStandAloneBrowser();
            case FIREFOX:
                return Browser.FIREFOX.getStandAloneBrowser();
            default:
                throw new RuntimeException(browser+" is not a valid option. Please update browser type to a valid option");
        }
    }

}
