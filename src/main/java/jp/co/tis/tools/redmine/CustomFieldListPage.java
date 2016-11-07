package jp.co.tis.tools.redmine;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomFieldListPage {

    private WebDriver driver;

    public CustomFieldListPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void updateCustomFieldSettings() {

        this.driver.get(AppConst.REDMINE_CUSTOM_FIELD_LIST_URL);

        List<WebElement> cfLinkUrlElm = this.driver
                .findElements(By.xpath("//*[@id='tab-content-IssueCustomField']/table/tbody/tr/td[1]/a"));

        CustomFieldIssue cfu = new CustomFieldIssue(this.driver);

        WebElement cfLinkElm;

        for (int i = 1; i < cfLinkUrlElm.size(); i++) {
            cfLinkElm = this.driver
                    .findElement(By.xpath("//*[@id='tab-content-IssueCustomField']/table/tbody/tr[" + i + "]/td[1]/a"));
            cfu.updateIssueCustomField(cfLinkElm);
        }

    }

    public void createIssueCustomFields(int cnt) {

        for (int i = 0; i < cnt; i++) {
            this.driver.get(AppConst.REDMINE_CUSTOM_FIELD_NEW);

            WebElement cfLinkUrlElm = this.driver.findElement(By.xpath("//*[@id='content']/form/p/input"));
            cfLinkUrlElm.click();

            WebElement customFieldName = this.driver.findElement(By.xpath("//*[@id='custom_field_name']"));
            customFieldName.sendKeys("custom_field_" + i);

            WebElement allPj = this.driver.findElement(By.xpath("//*[@id='custom_field_is_for_all']"));
            allPj.click();

            WebElement filterd = this.driver.findElement(By.xpath("//*[@id='custom_field_is_filter']"));
            filterd.click();

            WebElement tracker = this.driver.findElement(By.xpath("//*[@id='custom_field_tracker_ids']/p/a[1]"));
            tracker.click();

            WebElement saveButton = this.driver.findElement(By.xpath("//*[@id='custom_field_form']/div[1]/p/input"));
            saveButton.click();
        }

    }
}
