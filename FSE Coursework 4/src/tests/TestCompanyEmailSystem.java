// https://docs.google.com/document/d/1qsWBDOe8hT66w_FfopkHZAPvqh2x0HJzZIN1ZwjD-HE/edit#

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
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
// 	Test created by: Inigo Taylor
//	Date created: 02/04/18
	
	@Test
	public void testMainMethod_C11(){
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it"));
	}

//	Test ID: C.1.2
// 	Test created by: Inigo Taylor
//	Date created: 02/05/18
	
	@Test
	public void testMainMethod_C12(){
		readInput("1 \n X");
		CompanyEmailSystem.main(null);
		assertEquals(0, CompanyEmailSystem.currentProjShowing);
	}
	
//	Test ID: C.1.3
// 	Test created by: Inigo Taylor
//	Date created: 01/05/18

	@Test
	public void testMainMethod_C13(){
		readInput("X");		
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("Goodbye!"));
	}
	
//	Test ID: C.1.4
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 01/05/18
	
	@Test(timeout=2000)
	public void testMainMethod_C14() {
		readInput("X");		
		CompanyEmailSystem.main(null);
		return;
	}
	
//	Test ID: C.1.5
// 	Test created by: Inigo Taylor
//	Date created: 01/05/18
	
	@Test
	public void testMainMethod_C15() {
		readInput("1");
		CompanyEmailSystem.main(null);
		String[] outputArray = outContent.toString().split("\r\n|\r|\n");
		assertTrue(outputArray[3].toString().contains("L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project"));
	}
	
//	Test ID: C.1.6
// 	Test created by: Inigo Taylor
//	Date created: 02/05/18
	

//	Test list projects function

//	Test ID: C.2.1
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 02/04/18
	
	@Test
	public void testListProjects_C21() {
		readInput("P");
		CompanyEmailSystem.main(null);
		String[] outputArray = outContent.toString().split("\r\n|\r|\n");
		// Looked up Regex usage using http://files.zeroturnaround.com/pdf/zt_regular-expressions-cheat-sheet.pdf
		for(int x = 0; x < 3; x++) {
			assertTrue(outputArray[2+x].matches("\\d*\\).{10,} \\[(Feasibility|Design|Implementation|Testing|Deployment|Completed)\\] - \\d* email(s|)"));
		}
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
		
		//setOutputStreamDebug();
		//System.out.println("Project: " + CompanyEmailSystem.AllProjects.get(CompanyEmailSystem.AllProjects.size() - 1).getPTitle());
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

		
//	Test ID: C.4.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
		
//	Test ID: C.4.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
		
	
//	Test list phases function

//	Test ID: C.5.1
// 	Test created by: Inigo Taylor
//	Date created: 02/05/18
	
	@Test
	public void testListPhases_C51() {
		readInput("1 \n N \n F");
		CompanyEmailSystem.main(null);
		String[] outputArray = outContent.toString().split("\r\n|\r|\n");
		// Looked up Regex usage using http://files.zeroturnaround.com/pdf/zt_regular-expressions-cheat-sheet.pdf
		assertTrue(outputArray[7].matches("\\d*\\) Feasibility - \\d* (e|E)mail(s|)"));
	}
	
	
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
		String[] outputArray = outContent.toString().split("\r\n|\r|\n");
		readInput("2 \n A \n sender@nottingham.ac.uk \n receiver@nottingham.ac.uk \n subject \n body");
		CompanyEmailSystem.main(null);
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
		int num = 3;
		String string = "";
		for(int x = 1; x <= num; x++) {
			
			string = string + x;
			for(int i = 0; i < 6; i++) {
				string += "\nN";
			}
			string += "\nX";
			if(x < num) {
				string += "\n";
			}
		}
		readInput("1 \n N");
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		CompanyEmailSystem.main(null);
		String[] outputArray = outContent.toString().split("\r\n|\r|\n");
		int y = 0, z = 0;		

		for(y = 5; z < 5; y++) {
			System.out.println(outputArray[y]);
			assertTrue(outputArray[y].contains(CompanyEmailSystem.ProjectPhases[z].toString()));
		}

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



