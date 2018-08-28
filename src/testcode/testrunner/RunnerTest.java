package testcode.testrunner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {""},
        features = "src/test/resources/features"
        ,
        tags = "@automated",
        format = {"pretty", "html:target/cukes", "json:target/Jets12361.json"})


public class RunnerTest {
}
