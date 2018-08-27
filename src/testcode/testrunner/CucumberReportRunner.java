package testcode.testrunner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        jsonReport = "report/cucumber.json",
        jsonUsageReport = "report/cucumber-usage.json",
        reportPrefix = "MRS-Report",
        outputFolder = "report/",
        detailedAggregatedReport = true,
        overviewReport = true,
        usageReport = true,
        coverageReport = true,
        screenShotLocation = "screenshots/",
        screenShotSize = "300px")

@CucumberOptions(features = "src/test/resources/features/mrs/",
        glue = "",
        plugin = {"html:report/cucumber-html-report",
                "json:report/cucumber.json",
                "pretty:report/cucumber-pretty.txt",
                "usage:report/cucumber-usage.json"}
        , tags = "@sanity")
public class CucumberReportRunner
{

}