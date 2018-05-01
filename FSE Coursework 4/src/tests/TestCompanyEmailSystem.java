// https://docs.google.com/document/d/1qsWBDOe8hT66w_FfopkHZAPvqh2x0HJzZIN1ZwjD-HE/edit#

package tests;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import emailScripts.CompanyEmailSystem;

public class TestCompanyEmailSystem {


//	Test main method

//	Test ID: C.1.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy

//	Test ID: C.1.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.1.3
// 	Test created by: Inigo Taylor
//	Date created: 01/05/18
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	// I have added timeout as this is the easiest way I can see to test to see if the program is still running
	// Once X is entered by the user, the program should close and so main should exit its infinite waiting loop
	// If the test reaches the timeout, this means we are still on the line "CompanyEmailSystem.main(null)"
	@Test(timeout=2000)
	public void testMainMethod_C13(){
		String closeInput = "X";
		InputStream inStream = new ByteArrayInputStream(closeInput.getBytes());
		System.setIn(inStream);
		
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("Goodbye!"));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
//	Test  list projects function

//	Test ID: C.2.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.2.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
// 	Test add project function

//	Test ID: C.3.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.3.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.3.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.3.4
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
//	Test list emails function
	
//	Test ID: C.4.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
		
//	Test ID: C.4.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
		
//	Test ID: C.4.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
		
	
//	Test list phases function function

//	Test ID: C.5.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
//	Test list contacts function
	
//	Test ID: C.6.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.6.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
//	Test add email function
	
//	Test ID: C.7.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.7.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.7.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
//	Test change project phase function
	
//	Test ID: C.8.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy

//	Test ID: C.8.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.8.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
}


