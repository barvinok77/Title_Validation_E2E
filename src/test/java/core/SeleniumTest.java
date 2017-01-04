package core;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SeleniumTest {
	
	//Test data generator
	@Parameters(name = "Iteration # {index} : expected: {1}; actual: {2}")
	public static Collection<String[]> data() throws IOException {
		core.Selenium selenium = new core.Selenium();
		return Arrays.asList(selenium.array2d());
	}
	
	//Parameters for field injection
	@Parameter(value=0)
	public String test_id;
	
	@Parameter(value=1)
	public String expected_Result;
	
	@Parameter(value=2)
	public String actual_Result;
	
	@Test
	public void testTitleValidation() {
		System.out.println("Test case: " + test_id + " Expected result: " + expected_Result + " Actual result: " + actual_Result);
		assertEquals("FAILED", expected_Result, actual_Result);
	}
}
