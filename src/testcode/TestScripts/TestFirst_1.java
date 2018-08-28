package testcode.TestScripts;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestFirst_1 {
		@Before
	    public void beforeScenario(){
	        System.out.println("This will run before the Scenario");
	    }	
		
		@After
	    public void afterScenario(){
	        System.out.println("This will run after the Scenario");
	    }
	}
