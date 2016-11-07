package com.example.tools;

import java.io.File;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tools.redmine.CustomFieldListPage;
import com.example.tools.redmine.LoginPage;

public class DriverMain {

    private static Logger LOGGER = LoggerFactory.getLogger(DriverMain.class);

    public static void main(String[] args) throws URISyntaxException {

        WebDriver driver = null;

        try {

            File current = new File(
                    Thread.currentThread().getContextClassLoader().getResource("lib/chromedriver.exe").toURI());
            File chromePath = new File(current, "lib/chromedriver.exe");

            System.setProperty("webdriver.chrome.driver", current.getAbsolutePath());
            driver = new ChromeDriver();

            LoginPage top = new LoginPage(driver);

            // TODO 外部ストリング
            top.doLogin("admin", "admin");

            CustomFieldListPage cf = new CustomFieldListPage(driver);
            // cf.updateCustomFieldSettings();
            cf.createIssueCustomFields(75);
            ;
        } finally {
            driver.close();
        }
    }

}
