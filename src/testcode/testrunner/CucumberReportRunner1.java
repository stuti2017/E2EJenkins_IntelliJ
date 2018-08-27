package testcode.testrunner;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
    outputFolder = "target",
    reportPrefix = "WC1-run",

    coverageReport = true,
    featureOverviewChart = true,
    systemInfoReport = true,
    usageReport = true,
    overviewReport = true,

    overviewChartsReport = true,
    detailedReport = true,

    detailedAggregatedReport = true,

    featureMapReport = true,
    featureMapConfig = "target/featureMap_config.json",

    knownErrorsReport = true,
    knownErrorsConfig = "target/knownError_config.json",

    breakdownReport = true,
    breakdownConfig = "target/breakdown_config.json",

    consolidatedReport = true,
    consolidatedReportConfig = "target/conReoport_config.json",

    customTemplatesPath = "templates"




   )

    //excludeCoverageTags = {"@automated"},
        //includeCoverageTags = {"@sanity"},

@CucumberOptions(
    features = {"src/enablementTest/resources/features/mvp_1/"},
    glue = "",
    format = {"html:target/Reports", "json:target/cucumber.json","pretty:target/cucumber-pretty-dry.txt",
        "json:target/cucumber-dry.json","usage:target/cucumber-usage-dry.json"

    },

    tags = {"@test"}
   // dryRun = true

)

public class CucumberReportRunner1 {

}