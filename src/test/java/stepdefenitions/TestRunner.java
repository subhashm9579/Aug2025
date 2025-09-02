package stepdefenitions;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/subhzzz/git/repository/CGI_AUG2025/src/test/resources/Features1"
,glue= {"stepdefenitions"}
,dryRun=false
,monochrome=true)
 
 
public class TestRunner {

 
}