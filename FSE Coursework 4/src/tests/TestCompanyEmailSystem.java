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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import emailScripts.CompanyEmailSystem;


public class TestCompanyEmailSystem {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	//Email test data
	String sender = "sender@nottingham.ac.uk";
	String receiver = "receiver@nottingham.ac.uk";
	String subject = "subject"; 
	String body ="body";
	
	@Before
	public void setUpStreams() {
		setOutputStreamTest();
	}
	
//	Test main method

//	Test ID: C.1.1
// 	Test created by: Inigo Taylor
//	Date created: 02/04/18
	
	@Test
	public void testMainMethod1(){
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("P = List [P]rojects, [num] = Open Project [num], A = [A]dd Project, X = E[x]it"));
	}

//	Test ID: C.1.2
// 	Test created by: Inigo Taylor
//	Date created: 02/05/18
	
	@Test
	public void testMainMethod2(){
		readInput("1 \n X");
		CompanyEmailSystem.main(null);
		assertEquals(0, CompanyEmailSystem.currentProjShowing);
	}
	
//	Test ID: C.1.3
// 	Test created by: Inigo Taylor
//	Date created: 01/05/18

	@Test
	public void testMainMethod3(){
		readInput("X");		
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("Goodbye!"));
	}
	
//	Test ID: C.1.4
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 01/05/18
	
	@Test(timeout=2000)
	public void testMainMethod4() {
		readInput("X");		
		CompanyEmailSystem.main(null);
		return;
	}
	
//	Test ID: C.1.5
// 	Test created by: Inigo Taylor
//	Date created: 01/05/18
	
	@Test
	public void testMainMethod5() {
		readInput("1");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		assertTrue(outputArray[3].toString().contains("L = [L]ist Emails, A = [A]dd Email, F = List Phase [F]olders, N = Move to [N]ext Phase, [num] = List Emails in Phase [num], C = List [C]ontacts, X =  E[x]it Project"));
	}
	
//	Test ID: C.1.6
// 	Test created by: Inigo Taylor
//	Date created: 02/05/18
	
	@Test
	public void testMainMethod6() {
		readInput("-2\nX");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		assertTrue(outputArray[2].contains("Command not recognised"));
	}	
	
//	Test ID: C.1.7
// 	Test created by: Joshua Richardson
//	Date created: 03/05/18
	@Test
	public void testMainMethod7() {
		readInput("1\ns\nX\ns\n1\n1\nX");
		
		CompanyEmailSystem.main(null);
		String[] output = readOutput();
		
		assertTrue(output[4].contains("Command not recognised"));
		assertTrue(output[9].contains("Command not recognised"));
		assertTrue(output[14].contains("Feasibility"));
		
	}
	
//	Test list projects function

//	Test ID: C.2.1
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 02/04/18
	
	@Test
	public void testListProjects1() {
		readInput("P");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
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
	public void testAddProject1() {
		readInput("A");
		CompanyEmailSystem.main(null);
		assertTrue(outContent.toString().contains("What is the title of the project?"));
	}
	
//	Test ID: C.3.2
// 	Test created by: Tim Bartrum
//	Date created: 02/05/18
	@Test
	public void testAddProject2() {
		readInput("A\nTest Project 4");
		CompanyEmailSystem.main(null);
		assertEquals("Test Project 4", CompanyEmailSystem.AllProjects.get(CompanyEmailSystem.AllProjects.size() - 1).getPTitle());
	}
	
//	Test ID: C.3.3
// 	Test created by: Tim Bartrum
//	Date created: 03/05/18
	@Test
	public void testAddProject3() {
		readInput("A\nTest Project 4");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		assertEquals("[Project added]", outputArray[3]);
	}
	
	
//	Test ID: C.3.4
// 	Test created by: Inigo Taylor
//	Date created: 03/05/18
	
	@Test
	public void testAddProject4(){
		readInput("A \n \n P");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		assertTrue(outputArray[9].contains("[Feasibility] - 0 emails"));
		
	}
	
	
//	Test list emails function
	
//	Test ID: C.4.1
// 	Test created by: Julian Kubelec, Joshua Richardson, Inigo Taylor & Tim Bartrum
//	Date created: 02/05/18
	@Test
	public void testListEmails1() {
		readInput("1 \n L \n X");
		
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		
		int emailNum = 1;
		int emailMe = 9;
		for(int i = 8; i < 12;  i++) {
			String email = emailNum+") me"+emailMe+"@me.com - this is a test subject for email"+emailMe;
			assertEquals(email, outputArray[i]);
			emailNum++;
			emailMe -= 3;
		}
	}
	
//	Test ID: C.4.2
// 	Test created by: Julian Kubelec
//	Date created: 03/05/18
	@Test
	public void testListEmails2() {
		int lineNum = 9;
		for(int k = 0; k < 5; k++) {
			readInput("1 \n L \n N \n L \n X");
			CompanyEmailSystem.main(null);
			String[] outputArray = readOutput();
			for(int i = 9; i >= 0;  i-=3) {
				assertTrue(outputArray[lineNum].contains(""));
				lineNum++;
			}
		}
	}	
	
//	Test list phases function

//	Test ID: C.5.1
// 	Test created by: Inigo Taylor
//	Date created: 02/05/18
	
	@Test
	public void testListPhases1() {
		readInput("1 \n N \n F");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		// Looked up Regex usage using http://files.zeroturnaround.com/pdf/zt_regular-expressions-cheat-sheet.pdf
		
		// Joshua trying to work out what happened
		for(int x = 0; x < 9; x++) {
			System.out.println(outputArray[x]);
		}
		// Due to zero indexing i think this should be 7 - Joshua
		assertTrue(outputArray[7].matches("\\d*\\) Feasibility - \\d* (e|E)mail(s|)"));
	}
	
	
//	Test list contacts function
	
//	Test ID: C.6.1
// 	Test created by: Tim Bartrum
//	Date created: 03/03/18
	@Test
	public void testListContacts1() {
		readInput("P\n1\nC");
		CompanyEmailSystem.main(null);
		String[] output = readOutput();
		
		int contactNum = 0;
		int num = 1;
		for(int i = 9; i <= 12; i++) {
			assertEquals(num + ") you" + contactNum + "@you.com", output[i]);
			num++;
			contactNum += 3;
		}
	}
	
	
//	Test ID: C.6.2
// 	Test created by: Henry Hunt
//	Date created: 03/05/18
	@Test
	public void testListContacts2() {
		readInput("A \n New Project Title \n 4 \n C X");
		
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		assertTrue(outputArray[8].contains("What do you want to do?"));
	}
	
//	Test add email function
	
//	Test ID: C.7.1
// 	Test created by: Henry Hunt and Julian Kubelec
//	Date created: 02/05/18
	@Test
	public void testAddEmail1() {
		readInput("2 \n A \n"+ sender+"\n"+ receiver +"\n "+subject+"\n"+ body+"\n X");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();		
		assertTrue(outputArray[4].contains("from"));
		assertTrue(outputArray[5].contains("to"));
		assertTrue(outputArray[6].contains("Subject"));
		assertTrue(outputArray[7].contains("Message"));
	}
	
//	Test ID: C.7.2
// 	Test created by: Inigo Taylor
//	Date created: 03/05/18
	
	@Test
	public void testAddEmail2() {
		readInput("2 \n A \n "+ sender + "\n"+ receiver +"\n" + subject + " \n"+ body +"\n L \n X");
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();
		assertTrue(outputArray[16].contains(sender));
		assertTrue(outputArray[16].contains(subject));		
	}
	
//	Test ID: C.7.3
// 	Test created by: Joshua Richardson
//	Date created: 03/05/18
	@Test
	public void testAddEmail3() {
		int num = 3;
				
		for(int x = 1; x <= num; x++) {
			// Inputs written by Henry Hunt 02/05/18
			readInput(x+" \n A \n"+ sender +"\n"+ receiver+ "\n" + subject + "\n"+  body +"\n X");
	
			CompanyEmailSystem.main(null);
			String[] outputArray = readOutput();
	
			assertTrue(outputArray[9].contains("Email added to"));
		}
	}
	
	
//	Test change project phase function
	
//	Test ID: C.8.1
// 	Test created by: Joshua Richardson
//	Date created: 02/05/18
	@Test
	public void testChangeProjectPhase1() {
		int num = 3;
		String string = "";
		for(int x = 1; x <= num; x++) {
			string = string + x;
			for(int i = 0; i < 5; i++) {
				string += "\nN";
			}
			string += "\nX";
			if(x < num) {
				string += "\n";
			}
		}
		readInput(string);
		CompanyEmailSystem.main(null);
		String[] outputArray =readOutput();	
		int y = 0, z;
		
		
		for(int i = 1; i <= num; i++) {
			z = 0;
			for(y += 4; z < 5; z++, y+=3) {
				
				// Checks that it is in the correct order by looking to see if it matches the project phase
				System.out.println(outputArray[y].toString());
				assertTrue(outputArray[y].toString().contains(CompanyEmailSystem.ProjectPhases[z+1].toString()));
			}
		}	
	}

//	Test ID: C.8.2
// 	Test created by: Joshua Richardson
//	Date created: 02/05/18
	@Test
	public void testChangeProjectPhase2() {
		int num = 3;
		String string = "";
		for(int x = 1; x <= num; x++) {
			string = string + x;
			for(int i = 0; i < 5; i++) {
				string += "\nN";
			}
			string += "\nX";
			if(x < num) {
				string += "\n";
			}
		}
		readInput(string);
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();	
		int y = 0, z;
		for(int i = 1; i <= num; i++) {
			z = 0;
			for(y += 4; z < 5; z++, y+=3) {
				
				// Checks that a confirmation message is always displayed
				assertTrue(outputArray[y].toString().contains("Phase changed:"));
			}
		}	
	}
		
	
//	Test ID: C.8.3
// 	Test created by: Joshua Richardson
//	Date created: 02/05/18
	@Test
	public void testChangeProjectPhase3() {
		int num = 3;
		String string = "";
		for(int x = 1; x <= num; x++) {
			string = string + x;
			for(int i = 0; i < 10; i++) {
				string += "\nN";
			}
			string += "\nX";
			if(x < num) {
				string += "\n";
			}
		}
		readInput(string);
		CompanyEmailSystem.main(null);
		String[] outputArray = readOutput();	
		int y = 0, z;
		for(int i = 1; i <= num; i++) {
			z = 5;
			for(y += 19; z < 10; z++, y+=3) {
				// Checks that a failure is displayed if the system fails
				assertTrue(outputArray[y].toString().contains("Project already in last phase."));
			}
		}	
	}
	
	
//	Test ID: C.8.4
// 	Test created by: Joshua Richardson
//	Date created: 02/05/18
	@Test
	public void testchangeProjectPhase4() {
		String input = "1\nX\n2\nX\n3\nX";
		
		readInput("" + input);
		CompanyEmailSystem.main(null);
		
		for(int x = 0; x < 3; x++) {
			assertTrue(CompanyEmailSystem.AllProjects.get(0).toString().contains("Feasibility"));
			assertTrue(CompanyEmailSystem.AllProjects.get(1).toString().contains("Feasibility"));
			assertTrue(CompanyEmailSystem.AllProjects.get(2).toString().contains("Feasibility"));
		}
	}
	

	//Test Helper functions----------------------------------------------------------------------//
	/**
	 * Sets output stream back to the console for debugging purposes
	 * @author Tim Bartrum
	 */
	private void setOutputStreamDebug() {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
	}
	
	/**
	 * Sets output stream back to test output for use after setOutputStreamDebug
	 * @author Tim Bartrum
	 */
	private void setOutputStreamTest() {
		System.setOut(new PrintStream(outContent));
	}
	
	/**
	 * Takes a string to read as an input for tests
	 * @author Tim Bartrum
	 * @param input the input to read
	 */
	private void readInput(String input) {
		InputStream inStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inStream);
	}
	
	/**
	 * Read the contents of the outputstream
	 * @author Tim Bartrum
	 */
	private String[] readOutput() {
		return outContent.toString().split("\r\n|\r|\n");
	}
	
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}



