package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.UiDriverUtils;

public class Hooks {
	@Before
	public void setup() {
		UiDriverUtils.getDriver();
		
	}

	@After
	public void teardown() {
		UiDriverUtils.quitDriver();
	}
}
