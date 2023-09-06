package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = 
{"src/test/resources/Features/api.feature",

"src/test/resources/Features/user_not_found.feature",

"src/test/resources/Features/support.feature",

"src/test/resources/Features/supportList.feature"},


glue = 
{"com.apiStepDefination",

  "com.usernotfoundStepDefination",
"com.UserStepDefinations",

  "com.supportList"
}
		
				

)

public class Runner {
	
	}
