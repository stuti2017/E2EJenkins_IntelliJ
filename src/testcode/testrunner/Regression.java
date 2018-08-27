package testcode.testrunner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "target/cucumber.json",
        detailedReport = true,
        detailedAggregatedReport = true,
        toPDF = true,
        outputFolder = "target/CucumberReports/ExtendedReport")
@CucumberOptions(
        features = { "src/test/resources/features/" },
        glue = "", plugin = {
        "html:target/CucumberReports", "json:target/cucumber.json"
         })

public class Regression {

}