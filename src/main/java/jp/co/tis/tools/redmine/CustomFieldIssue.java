package jp.co.tis.tools.redmine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomFieldIssue {

    private WebDriver driver;
    protected static int checkedFilterd = 0;

    public CustomFieldIssue(WebDriver _driver) {
        this.driver = _driver;
    }

    public void updateIssueCustomField(WebElement link) {

        link.click();

        WebElement filterCheck = this.driver.findElement(By.id("custom_field_is_filter"));

        try {
            Thread.currentThread().sleep(AppConst.CUSTOM_FIELD_SAVE_SLEEP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (filterCheck.isSelected()) {
            filterCheck.click();
            WebElement saveButton = this.driver
                    .findElement(By.xpath("//*[@id='custom_field_form']/input[@type='submit']"));
            saveButton.click();

            checkedFilterd++;
        } else {
            this.driver.get(AppConst.REDMINE_CUSTOM_FIELD_LIST_URL);
        }
        System.out.println(checkedFilterd);
    }
}
