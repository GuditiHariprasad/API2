package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        //features = {"C:\\Users\\Admin\\eclipse-workspace\\ACucumberBDD\\src\\test\\resources\\com\\ha\\features\\login1.feature","C:\\Users\\Admin\\eclipse-workspace\\ACucumberBDD\\src\\test\\resources\\com\\ha\\features\\login2.feature"},
        //features = {"src/test/resources/com/ha/features/login1.feature","src/test/resources/com/ha/features/login2.feature"},
        //features = {"src/test/resources/com/ha/features"},
        features = {"src/test/resources/features"},
        glue = {"stepdefinitions"},
        /*plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                        "junit:target/cucumber-reports/Cucumber.xml",
                        "html:target/cucumber-reports"},*/
        //format = {"json:target/cucumber.json","html:target/cucumber-reports"},
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failedrerun.txt"},
        monochrome = true,
        dryRun=false,
        //tags = "@SmokeTest"
        //tags = "@SmokeTest or @RegressionTest"
        //tags = "@SmokeTest or @RegressionTest or @End2EndTest"
        //tags = "@SmokeTest and @RegressionTest"
        //tags = "@End2EndTest and @RegressionTest"
        //tags = "@End2EndTest and @SmokeTest"
        //tags = "@End2EndTest and @RegressionTest and SmokeTest"
        //tags = "not @End2EndTest"
        //tags = "not @End2EndTest and not @SmokeTest"
        tags="@Tag1 or @Tag2"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel=true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
