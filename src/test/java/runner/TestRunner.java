package runner;


	
	
	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(tags = "@test",features={"src/test/java/features"},
	plugin = { "pretty","json:target/cucumber-reports/Cucumber.json",
			"junit:target/cucumber-reports/Cucumber.xml", 
			"html:target/cucumber-reports/cucumber.html"},glue= {"stepDefinitions"})
	
	
	public class TestRunner {




}
