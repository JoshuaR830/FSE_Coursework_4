// https://docs.google.com/document/d/18v9pEzfbKsLBOuPCX-yKiDZYMQphwJoi_AcsFr_dBUI/edit

package tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import emailScripts.CompanyEmail;
import emailScripts.CompanyEmailSystem;
import emailScripts.CompanyProject;

public class TestCompanyProject {
	int testProjectCounter;
	
	CompanyProject cp;
	
//	Test default constructor

//	Test ID: B.1.1
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 27/04/18
	
	@Test
	public void testDefaultConstructor_B11(){
		testProjectCounter = CompanyEmailSystem.GlobalProjectCounter;
		CompanyProject testProject = new CompanyProject();
		assertEquals(++testProjectCounter,  CompanyEmailSystem.GlobalProjectCounter);
	}	
	
//	Test ID: B.1.2
// 	Test created by: Inigo Taylor
//	Date created: 27/04/18	
	@Test
	public void testDefaultConstructor_B12() {
		testProjectCounter = CompanyEmailSystem.GlobalProjectCounter;
		CompanyProject testProject = new CompanyProject();
		assertEquals(++testProjectCounter, testProject.getPID());
	}
	
//	Test ID: B.1.3
// 	Test created by: Inigo Taylor
//	Date created: 27/04/18
	@Test
	public void testDefaultConstructor_B13() {
		CompanyProject testProject = new CompanyProject();
		assertEquals("New Project", testProject.getPTitle());
	}
	
//	Test ID: B.1.4
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testDefaultConstructor_B14() {
		CompanyProject testProject = new CompanyProject();
		assertNotNull(testProject.getProjectContacts());
		assertTrue(testProject.getProjectContacts().isEmpty());
	}
	
//	Test ID: B.1.5
// 	Test created by: Inigo Taylor, Tim Bartrum
//	Date created: 29/04/18
	
	@Test
	public void testDefaultConstructor_B15() {
		CompanyProject testProject = new CompanyProject();
		assertEquals(0, testProject.getPhaseByID());
	}
	
//	Test ID: B.1.6
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
//	Test main constructor 
	
//	Test ID: B.2.1
// 	Test created by: Tim Bartrum
//	Date created: 27/04/18
	@Test
	public void testMainConstructor_B21() {
		CompanyProject testProject = new CompanyProject("0123456789");
		assertEquals("0123456789", testProject.getPTitle());
	}

//	Test get project id

//	Test ID: B.3.1
// 	Test created by: Joshua Richardson
//	Date created: 27/04/18
	
	@Test
	public void testGetProjectId_b31() {
		cp = new CompanyProject();
		assertEquals(CompanyEmailSystem.GlobalProjectCounter, cp.getPID());
	}
	

	
	
//	Test get project title

//	Test ID: B.4.1
// 	Test created by: Joshua Richardson
//	Date created: 30/04/18
	
	@Test
	public void testProjectTitle_b41() {
		CompanyProject cp = new CompanyProject();
		cp.setPTitle("0123456789");
		assertEquals("0123456789", cp.getPTitle());
	}
	
//	Test ID: B.4.2
// 	Test created by: Joshua Richardson
//	Date created: 30/04/18
	
	@Test
	public void testProjectTitle_b42() {
		CompanyProject cp = new CompanyProject();
		cp.setPTitle("0123456789");
		cp.setPTitle("012345678");
		assertNotEquals("012345678", cp.getPTitle());
	}
	
	

//	Test set project title

//	Test ID: B.5.1
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testSetPTitle_B51() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle("Test Project");
		assertEquals("Test Project", testProject.getPTitle());
	}
	
//	Test ID: B.5.2
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testSetPTitle_B52() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle("Test Title");
		assertEquals("Test Title", testProject.getPTitle());
	}
	
//	Test ID: B.5.3
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testSetPTitle_B53() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle("Test");
		assertNotEquals("Test", testProject.getPTitle());
	}
	

//	Test is contact

//	Test ID: B.6.1
// 	Test created by: Tim Bartrum
//	Date created: 01/05/18
	@Test
	public void testIsContact_B61() {
		CompanyProject testProject = new CompanyProject();
		testProject.addContact("test@gmail.com");
		assertTrue(testProject.isContact("test@gmail.com"));
	}
	
//	Test ID: B.6.2
// 	Test created by: Tim Bartrum
//	Date created: 01/05/18
	@Test
	public void testIsContact_B62() {
		CompanyProject testProject = new CompanyProject();
		testProject.addContact("test2@gmail.com");
		assertFalse(testProject.isContact("test@gmail.com"));
	}
	

//	Test add contact

//	Test ID: B.7.1
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testAddContact_B71() {
		String testInput = "psyit@nottingham.ac.uk";
		CompanyProject testProject = new CompanyProject();		
		testProject.addContact(testInput);
		int lastItem = testProject.getProjectContacts().size();
		
		assertEquals("psyit@nottingham.ac.uk",testProject.getProjectContacts().get(--lastItem));
	}
	
//	Test ID: B.7.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test add email

//	Test ID: B.8.1
// 	Test created by: Inigo Taylor
//	Date created: 27/04/18
	
	@Test
	public void testAddEmail_B81(){
		try {
			CompanyProject testProject = new CompanyProject();
			testProject.addEmail(new CompanyEmail());
			fail("Exception wasn't produced");
		} catch (Exception e) {
			assertEquals(e.getClass(), Exception.class);
		}
	}
	
//	Test ID: B.8.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test get email for current phase

//	Test ID: B.9.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
	

//	Test get email for specific phase

//	Test ID: B.10.1
// 	Test created by: Joshua Richardson and Inigo Taylor
//	Date created: 01/05/18
	
	@Test
	public void testGetEmailForSpecificPhase_B101(){
		CompanyProject cp = new CompanyProject();
		try {

			CompanyEmail ce = new CompanyEmail("psyjr4@nottingham.ac.uk","psytb4@nottingham.ac.uk","Hi","Body");
			cp.addEmail(ce);
			ArrayList[] projectEmails = cp.getProjectEmails();	
			assertEquals(cp.getEmailsForPhase(1), projectEmails[1]);

		}catch(Exception e) {
			fail("No exception should be raised for this test");
		}
	}
	
	
//	Test ID: B.10.2
// 	Test created by: Joshua Richardson
//	Date created: 30/04/18
	
	@Test
	public void testGetEmailForSpecificPhase_B102() {
		CompanyProject cp = new CompanyProject();
		try {
			cp.getEmailsForPhase(-1);
		}catch(Exception e) {
			assertEquals(e.getClass(), Exception.class); // From Inigo
		}
	}

	
	
//	Test ID: B.10.3
// 	Test created by: Joshua Richardson
//	Date created: 30/04/18
	
	@Test
	public void testGetEmailForSpecificPhase_B103() {
		CompanyProject cp = new CompanyProject();
		try {
			cp.getEmailsForPhase(cp.getPID()+1);
		}catch(Exception e) {
			assertEquals(e.getClass(), Exception.class); // From Inigo
		}
		
	}
	

//	Test next phase 

//	Test ID: B.11.1
// 	Test created by: Inigo Taylor
//	Date created: 30/04/18
	
	@Test
	public void testNextPhase_B111(){
		CompanyProject testProject = new CompanyProject();
		for(int i=0; i<6; i++) {
			assertEquals(true, testProject.nextPhase());
		}
	}
	
//	Test ID: B.11.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	@Test
	public void testNextPhase_B112(){
		CompanyProject testProject = new CompanyProject();
		for(int i=0; i<6; i++) {
			testProject.nextPhase();
		}
		assertEquals(false, testProject.nextPhase());
	}

//	Test get phase by name

//	Test ID: B.12.1
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	
	@Test
	public void testGetPhaseByName_B121() {
		
	}
	
//	Test ID: B.12.2
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	
	@Test
	public void testGetPhaseByName_B122() {
		
	}
	
//	Test ID: B.12.3
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	
	@Test
	public void testGetPhaseByName_B123() {
		
	}
	
	

//	Test get phase by id

//	Test ID: B.13.1
// 	Test created by: Inigo Taylor, Tim Bartrum
//	Date created: 29/04/18
	
	@Test
	public void testGetPhaseByID_B131(){
		CompanyProject testProject = new CompanyProject();
		assertEquals(0, testProject.getPhaseByID());
	}
	

//	Test get project contacts

//	Test ID: B.14.1
// 	Test created by: Joshua Richardson
//	Date created: 28/04/18
	
	@Test
	public void testGetProjectContacts_B141(){
		CompanyProject cp = new CompanyProject();
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(cp.getProjectContacts(), expected);
	}
	
//	Test ID: B.14.2
// 	Test created by: Joshua Richardson
//	Date created: 28/04/18
	
	@Test
	public void testGetProjectContacts_B142(){
		CompanyProject cp = new CompanyProject();
		ArrayList<String> expected = new ArrayList<String>();
		String input = "psyjk@nottingham.ac.uk";
		expected.add(input);
		cp.addContact(input);
		assertEquals(cp.getProjectContacts(), expected);
	}
	
//	Test ID: B.14.3
// 	Test created by: Joshua Richardson
//	Date created: 28/04/18
	
	@Test
	public void testGetProjectContacts_B143(){
		CompanyProject cp = new CompanyProject();
		ArrayList<String> expected = new ArrayList<String>();
		String email1 = "psyjk4@nottingham.ac.uk";
		String email2 = "psytb5@nottingham.ac.uk";
		String email3 = "psyit@nottingham.ac.uk";
		
		expected.add(email1);
		cp.addContact(email1);
		expected.add(email2);
		cp.addContact(email2);
		expected.add(email3);
		cp.addContact(email3);
		
		assertEquals(cp.getProjectContacts(), expected);
	}
	
//	Test ID: B.14.4
// 	Test created by: Joshua Richardson
//	Date created: 28/04/18
	
	@Test
	public void testGetProjectContacts_B144(){
		CompanyProject cp = new CompanyProject();
		ArrayList<String> expected = new ArrayList<String>();
		for(int num = 0; num < 100000; num++) {
			expected.add("psyjk"+num+"@nottingham.ac.uk");
			cp.addContact("psyjk"+num+"@nottingham.ac.uk");
		}
		assertEquals(cp.getProjectContacts(), expected);
	}
	
	
	
	

//	Test to string override

//	Test ID: B.15.1
// 	Test created by: Joshua Richardson
//	Date created: 27/04/18
	
	@Test
	public void testStringOverrideB151(){
		CompanyProject cp = new CompanyProject();
		cp.setPTitle("Hello Project");
		assertEquals( "Hello Project" + " [" + CompanyEmailSystem.ProjectPhases[cp.getPhaseByID()] + "]", cp.toString());
	}
		
}


