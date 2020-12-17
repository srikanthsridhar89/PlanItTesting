package runnerfile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
				  glue= {"steps"},
				  tags= {"@AddPersona"},
				  plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
				  	monochrome = true)
 

public class TestRunner {
	@BeforeClass
    public static void setup() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("cucumber-reports/"+timeStamp.replace(":","_").replace(".","_")+".html");
    }
	

@AfterClass
public static void writeExtentReport() {
Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");  
Date date = new Date();  
System.out.println(formatter.format(date));


File file=new File(System.getProperty("user.dir")+"/eclipse-workspace/TestAssurePro/target/cucumber-reports/report.html");
file.renameTo(new File(System.getProperty("user.dir")+"eclipse-workspace/TestAssurePro/target/cucumber-reports/report"+formatter.format(date)+".html"));
}

}