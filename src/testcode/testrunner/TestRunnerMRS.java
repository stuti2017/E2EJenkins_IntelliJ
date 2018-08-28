package testcode.testrunner;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {""},
        features = "src/test/resources/features"
                ,
        tags = "@automated",
        format = {"pretty", "html:target/cukes", "json:target/Jets12361.json"})


@Test
public class TestRunnerMRS extends AbstractTestNGCucumberTests {

}