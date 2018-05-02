// https://docs.google.com/document/d/1qsWBDOe8hT66w_FfopkHZAPvqh2x0HJzZIN1ZwjD-HE/edit#

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import emailScripts.CompanyEmailSystem;
import emailScripts.CompanyProject;

public class TestCompanyEmailSystem {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		setOutputStreamTest();
	}
	
//	Test main method

//	Test ID: C.1.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy

//	Test ID: C.1.2
// 	Test created by: Inigo Taylor
//	Date created: 02/05/18
	
	@Test
	public void testMainMethod_C12(){
		String closeInput = "1\nX";
		InputStream inStream = new ByteArrayInputStream(closeInput.getBytes());
		System.setIn(inStream);
		CompanyEmailSystem.main(null);
		assertEquals(0, CompanyEmailSystem.currentProjShowing);
	}
	
//	Test ID: C.1.3
// 	Test created by: Inigo Taylor
//	Date created: 01/05/18

	@Test
	public void testMainMethod_C13(){
		String closeInput = "X";
		InputStream inStream = new ByteArrayInputStream(closeInput.getBytes());
		System.setIn(inStream);
		
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("Goodbye!"));
	}
	
//	Test ID: C.1.4
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 01/05/18
	
	@Test(timeout=2000)
	public void testMainMethod_C14() {
		String closeInput = "X";
		InputStream inStream = new ByteArrayInputStream(closeInput.getBytes());
		System.setIn(inStream);
		
		CompanyEmailSystem.main(null);
		return;
	}
	
//	Test list projects function

//	Test ID: C.2.1
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 02/04/18
	
	@Test
	public void testListProjects_C21() {
		System.setOut(new PrintStream(outContent));

		String closeInput = "P";
		InputStream inStream = new ByteArrayInputStream(closeInput.getBytes());
		System.setIn(inStream);
		CompanyEmailSystem.main(null);
		String[] outputArray = outContent.toString().split("\r\n|\r|\n");
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		// Looked up regex expressions using http://files.zeroturnaround.com/pdf/zt_regular-expressions-cheat-sheet.pdf
		assertTrue(Pattern.matches("\\d*\\).{10,} \\[(Feasibility|Design|Implementation|Testing|Deployment|Completed)\\] - \\d* email(s|)", outputArray[2].toString()));
	}
	
// 	Test add project function

//	Test ID: C.3.1
	
// 	Test created by: Tim Bartrum
//	Date created: 02/05/18
	@Test
	public void testAddProject_C31() {
		readInput("A");
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("What is the title of the project?"));
	}
	
//	Test ID: C.3.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	@Test
	public void testAddProject_C32() {
		readInput("A");
		CompanyEmailSystem.main(null);
		
		readInput("Proj4");
		
		setOutputStreamDebug();
		System.out.println("Project: " + CompanyEmailSystem.AllProjects.get(CompanyEmailSystem.AllProjects.size() - 1).getPTitle());
		//assertEquals(CompanyEmailSystem.AllProjects.get(CompanyEmailSystem.AllProjects.size() - 1).getPTitle(), "Proj4");
	}
	
//	Test ID: C.3.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.3.4
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
//	Test list emails function
	
//	Test ID: C.4.1
// 	Test created by: Julian Kubelec
//	Date created: 02/05/18
	@Test
	public void testListEmails_C041() {
		CompanyEmailSystem.main(null);
		readInput("P");
		readInput("1");
		readInput("L");
		
		String closeInput = "P";
		InputStream inStream = new ByteArrayInputStream(closeInput.getBytes());
		String selectProject = "1";
		//InputStream inStream = new ByteArrayInputStream(select.getBytes());
		
	}
		
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
	
//	Test ID: C.5.2
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
// 	Test created by: Henry Hunt
//	Date created: 02/05/18
	@Test
	public void testAddEmail_C72() {
		ByteArrayInputStream inContent;
		inContent = new ByteArrayInputStream("sender@nottingham.ac.uk".getBytes());
		System.setIn(inContent);
		inContent = new ByteArrayInputStream("receiver@nottingham.ac.uk".getBytes());
		System.setIn(inContent);
		inContent = new ByteArrayInputStream("subject".getBytes());
		System.setIn(inContent);
		inContent = new ByteArrayInputStream("body".getBytes());
		System.setIn(inContent);
	}
	
//	Test ID: C.7.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: C.7.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
//	Test change project phase function
	
//	Test ID: C.8.1
// 	Test created by: Joshua Richardson
//	Date created: 02/05/18
	@Test
	public void testChangeProjectPhase_C81() {
		
	}

//	Test ID: C.8.2
// 	Test created by: Joshua Richardson
//	Date created: 02/05/18
	@Test
	public void testChangeProjectPhase_C82() {
		
	}
	
//	Test ID: C.8.3
// 	Test created by: Joshua Richardson
//	Date created: 02/05/18
	@Test
	public void testChangeProjectPhase_C83() {
		CompanyEmailSystem ces = new CompanyEmailSystem();
//		ces.ChangeProjectPhase();
		
	}
	
	private void setOutputStreamDebug() {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}
	
	private void setOutputStreamTest() {
		System.setOut(new PrintStream(outContent));
	}
	
	private void readInput(String input) {
		InputStream inStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inStream);
	}
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}



