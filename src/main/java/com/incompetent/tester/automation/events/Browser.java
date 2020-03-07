package com.incompetent.tester.automation.events;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;

@Service
public enum Browser {

    CHROME {
        /**
         * This function initialize webdriver and returns its reference to the user.
         * @return WebDriver
         */
        @Override
        public WebDriver getStandAloneBrowser() {
            System.setProperty("webdriver.chrome.driver", getBrowserPath());
            return new ChromeDriver();
        }


        /**
         * Function is used to get browser path from user.
         * User must specify 'chromePath' as environment variable/system variable specifying chrome driver path in a system.
         * @return
         */
        @Override
        public String getBrowserPath() {
            String propName = "chromePath";
            if(System.getenv(propName) == null && System.getProperty(propName) == null){
                throw new RuntimeException("Chrome driver path must be passed as system/environment variable");
            }else{
                return System.getenv(propName)==null?System.getProperty(propName):System.getenv(propName);
            }
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        @Override
        public String getGridUrl() {
            return null;
        }

        /**
         * This function is used to define default capabilities of remote webdriver.
         * @return DesiredCapabilities
         */
        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }
    }, CHROME_HEADLESS {
        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }

        @Override
        public WebDriver getStandAloneBrowser() {
            return null;
        }

        @Override
        public String getBrowserPath() {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        @Override
        public String getGridUrl() {
            return null;
        }
    }, FIREFOX {
        @Override
        public WebDriver getStandAloneBrowser() {
            return null;
        }

        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }

        @Override
        public String getBrowserPath() {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        @Override
        public String getGridUrl() {
            return null;
        }
    }, FIREFOX_HEADLESS {
        @Override
        public WebDriver getStandAloneBrowser() {
            return null;
        }

        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }

        @Override
        public String getBrowserPath() {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        @Override
        public String getGridUrl() {
            return null;
        }
    }, INTERNET_EXPLORER {
        @Override
        public WebDriver getStandAloneBrowser() {
            return null;
        }

        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }

        @Override
        public String getBrowserPath() {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        @Override
        public String getGridUrl() {
            return null;
        }
    }, EDGE {
        @Override
        public WebDriver getStandAloneBrowser() {
            return null;
        }

        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }


        @Override
        public String getBrowserPath() {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        @Override
        public String getGridUrl() {
            return null;
        }
    }, OPERA {
        @Override
        public WebDriver getStandAloneBrowser() {
            return null;
        }

        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }

        @Override
        public String getBrowserPath() {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        @Override
        public String getGridUrl() {
            return null;
        }
    }, SAFARI {
        /**
         * Function returns capability for specified browser.
         *
         * @return
         */
        @Override
        public DesiredCapabilities getDesiredCapabilities() {
            return null;
        }

        /**
         * This function initialize web-driver and returns its reference to the user.
         *
         * @return WebDriver
         */
        @Override
        public WebDriver getStandAloneBrowser() {
            return null;
        }

        /**
         * User must specify browser path as system/environment variable, so it can be used at runtime to start a selenium driver.
         *
         * @return String browser path
         */
        @Override
        public String getBrowserPath() {
            return null;
        }

        /**
         * This function is used to initialize browser from selenium grid based upon the capabilities.
         * user can specify its own grid url and capabilities, in case of null, these will be defaulted to framework settings.
         *
         * @param gridUrl
         * @param capabilities
         * @return
         */
        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities) {
            return null;
        }

        /**
         * This function is used to initialize browser from selenium grid based upon the browser.
         * Based upon the browser, default capabilities for a given browser is passed.
         *
         * @param gridUrl
         * @param browser
         * @return
         */
        @Override
        public WebDriver getBrowserFromGrid(String gridUrl, Browser browser) {
            return null;
        }

        /**
         * User has an option to pass 'gridUrl' as system/env variable.
         * if value is null, grid url will be defaulted to 'http://localhost:4444/wd/hub'
         *
         * @return
         */
        @Override
        public String getGridUrl() {
            return null;
        }
    };

    /**
     * Function returns capability for specified browser.
     *
     * @return
     */
    public abstract DesiredCapabilities getDesiredCapabilities();

    /**
     * This function initialize web-driver and returns its reference to the user.
     * @return WebDriver
     */
    public abstract WebDriver getStandAloneBrowser();

    /**
     * User must specify browser path as system/environment variable, so it can be used at runtime to start a selenium driver.
     * @return String browser path
     */
    public abstract String getBrowserPath();

    /**
     * This function is used to initialize browser from selenium grid based upon the capabilities.
     * user can specify its own grid url and capabilities, in case of null, these will be defaulted to framework settings.
     * @param gridUrl
     * @param capabilities
     * @return
     */
    public abstract WebDriver getBrowserFromGrid(String gridUrl, DesiredCapabilities capabilities);

    /**
     *  This function is used to initialize browser from selenium grid based upon the browser.
     *  Based upon the browser, default capabilities for a given browser is passed.
     * @param gridUrl
     * @param browser
     * @return
     */
    public abstract WebDriver getBrowserFromGrid(String gridUrl, Browser browser);

    /**
     * User has an option to pass 'gridUrl' as system/env variable.
     * if value is null, grid url will be defaulted to 'http://localhost:4444/wd/hub'
     * @return
     */
    public abstract String getGridUrl();
}
