package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import utils.PropertiesReader;
import utils.UiDriverUtils;

public class HomePageSteps {
	private HomePage homePage = new HomePage(UiDriverUtils.getDriver());

	@Then("User is on the home Page")
	public void user_is_on_the_home_Page() {
		UiDriverUtils.getDriver().get(PropertiesReader.getProperty("testurl"));
	}
	
	@When("User select {string} country from the drop down")
	public void select_Product(String productName) {
		homePage.selectCountry(productName);
	}

	@Then("User can see the home page")
	public void user_can_see_the_home_page() {
		Assert.assertEquals(UiDriverUtils.getCurrentUrl(), PropertiesReader.getProperty("testurl"));
	}

	@When("User click on consent button")
	public void user_open_category() {
		homePage.userClickOnConsentButton();
	}

	@When("user select {string} vat rate")
	public void select_vat_rate(String vatRate) {
		homePage.selectVatRate(vatRate);
	}

	@Then("User verify url contains {string}")
	public void user_verify_url_contains(String urlToVerify) {
		Assert.assertTrue(UiDriverUtils.getDriver().getCurrentUrl().contains(urlToVerify));
	}
	
	
	@Then("User enter {string} in {string} input box")
	public void User_enter_to_input_box(String value, String inputBoxName) {
		homePage.enterAmount(inputBoxName, value);
	}
	
	@Then("verify Pie chart is displayed correctly")
	public void verify_Pie_chart_is_displayed_correctly() {
		Assert.assertTrue(homePage.isPieChartDisplayed(), "Pie chart is not displayed");
	}
	
	@Then("Verify Pie chart is not displayed")
	public void Verify_Pie_chart_is_not_displayed() {
		Assert.assertFalse(homePage.isPieChartDisplayed(), "Pie chart is displayed");
	}

}
