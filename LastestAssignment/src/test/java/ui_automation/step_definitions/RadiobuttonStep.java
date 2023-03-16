package ui_automation.step_definitions;



import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.util.Iterator;
import java.util.List;


public class RadiobuttonStep {
    WebDriver driver = Driver.getInstance().getDriver();


    @Given("^user navigates to automation Web Page$")
    public void user_navigates_to_automation_web_page() {
        String url = ConfigurationReader.getProperty("ui-config.properties", "auto.url");
        Driver.getInstance().getDriver().get(url);


    }

    @When("User click Male radiobutton in gender section")
    public void user_click_male_radiobutton_in_gender_section() throws InterruptedException {

        WebElement maleRadioOption = driver.findElement(By.xpath("//*[@value='Male']"));
        maleRadioOption.click();
        Thread.sleep(5000L);
    }

    @Then("User click Cricket and Hockey in Hobbies section")
    public void user_click_cricket_and_hockey_in_hobbies_section() throws InterruptedException {
        List<WebElement> hobbies = driver.findElements(By.xpath("//*[text()='Hobbies']/..//input"));
        ((WebElement) hobbies.get(0)).click();
        Thread.sleep(2000L);
        ((WebElement) hobbies.get(2)).click();
    }

    @Then("User click Skills and chooses HTML")
    public void userClickSkillsAndChoosesHTML() throws InterruptedException {

        Thread.sleep(2000L);
        WebElement skillsDropdownElement = driver.findElement(By.id("Skills"));
        Select skillsDropdown = new Select(skillsDropdownElement);
        List<WebElement> allSkillsOptions = skillsDropdown.getOptions();
        Iterator var5 = allSkillsOptions.iterator();

        while(var5.hasNext()) {
            WebElement skill = (WebElement)var5.next();
            System.out.println(skill.getText());
        }

        skillsDropdown.selectByVisibleText("HTML");
        Thread.sleep(5000L);
    }
}
