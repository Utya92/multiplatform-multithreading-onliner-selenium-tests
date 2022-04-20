package project.common;

public class Config {

    /**
     * for selecting browsers:
     *
     * @value CHROME/FIREFOX
     **/
    public static final String BROWSER = "CHROME";

    /**
     * clear cookies after each test
     */
    public static final Boolean CLEAR_COOKIES = false;

    /**
     * leave the browser window open after all test
     */
    public static final Boolean HOLD_BROWSER_OPEN = true;

    /**
     * clean the reports' directory before each test
     */
    public static final Boolean CLEAR_REPORTS = true;

    /**
     * set fullscreen browser's window
     */
    public static final Boolean FULLSCREEN = false;
}
