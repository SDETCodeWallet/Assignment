package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UiDriverUtils;

public class HomePage extends UiDriverUtils {
	WebDriver driver;

	@FindBy(xpath = "//select[@name=\"Country\"]")
	private WebElement countryDropDown;

	@FindBy(xpath = "//form[@id=\"vatcalculator\"]//label[contains(@for,\"VAT\")]")
	private List<WebElement> vatRate;

	@FindBy(xpath = "//input[@name='find']//parent::div//label")
	private List<WebElement> taxRateLabel;

	@FindBy(xpath = "//input[@value=\"Reset\"]")
	private WebElement resetLink;
	
	@FindBy(xpath = "//p[text()=\"Consent\"]")
	private List<WebElement> consentButton;
	
	@FindBy(css  = "svg[aria-label='A chart.'] g")
	private List<WebElement> pieChart;
	
	@FindBy(css  = "svg[aria-label='A chart.'] g text[text-anchor='start']")
	private List<WebElement> pieVATRate;

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void selectCountry(String countryName) {
		selectByVisibleText(countryDropDown, countryName);
	}
	
	public void userClickOnConsentButton() {
		if(consentButton.size()>0) {
			clickOnElement(consentButton.get(0));
		}
	}
	
	public void selectVatRate(String rateToSelect) {
		for(WebElement rate: vatRate) {
			String text= rate.getText();
			if(text.contains(rateToSelect)) {
				waitFor(1500);
				actionClick(rate);
				break;
			}
		}
	}
	
	public void enterAmount(String inputName, String value) {
		for(WebElement rate: taxRateLabel) {
			String text= rate.getText();
			if(text.contains(inputName)) {
				waitFor(1000);
				actionClick(rate);
				rate.findElement(By.xpath(".//following::input")).clear();
				rate.findElement(By.xpath(".//following::input")).sendKeys(value);
				break;
			}
		}
	}
	
	public boolean isPieChartDisplayed() {
		waitFor(1500);
		if (pieChart.size() > 2) {
			return true;
		}else {
			return false;
		}
	}
	
	public String getPieChartVATRateValue() {
		return pieVATRate.get(0).getText();
	}
	
	public String getPieChartPriceValue() {
		return pieVATRate.get(1).getText();
	}
}
