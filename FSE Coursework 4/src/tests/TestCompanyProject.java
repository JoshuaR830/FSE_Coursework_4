// https://docs.google.com/document/d/18v9pEzfbKsLBOuPCX-yKiDZYMQphwJoi_AcsFr_dBUI/edit

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

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
	public void testDefaultConstructor1(){
		testProjectCounter = CompanyEmailSystem.GlobalProjectCounter;
		CompanyProject testProject = new CompanyProject();
		assertEquals(++testProjectCounter,  CompanyEmailSystem.GlobalProjectCounter);
	}	
	
//	Test ID: B.1.2
// 	Test created by: Inigo Taylor
//	Date created: 27/04/18	
	@Test
	public void testDefaultConstructor2() {
		testProjectCounter = CompanyEmailSystem.GlobalProjectCounter;
		CompanyProject testProject = new CompanyProject();
		assertEquals(++testProjectCounter, testProject.getPID());
	}
	
//	Test ID: B.1.3
// 	Test created by: Inigo Taylor
//	Date created: 27/04/18
	@Test
	public void testDefaultConstructor3() {
		CompanyProject testProject = new CompanyProject();
		assertEquals("New Project", testProject.getPTitle());
	}
	
//	Test ID: B.1.4
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testDefaultConstructor4() {
		CompanyProject testProject = new CompanyProject();
		assertNotNull(testProject.getProjectContacts());
		assertTrue(testProject.getProjectContacts().isEmpty());
	}
	
//	Test ID: B.1.5
// 	Test created by: Inigo Taylor, Tim Bartrum
//	Date created: 29/04/18
	
	@Test
	public void testDefaultConstructor5() {
		CompanyProject testProject = new CompanyProject();
		assertEquals(0, testProject.getPhaseByID());
	}
	
//	Test ID: B.1.6
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	@Test
	public void testDefaultConstructor6() {
		cp = new CompanyProject();
		ArrayList empty = new ArrayList();
		try {
			assertEquals(cp.getEmailsForPhase(0), empty);
		} catch (Exception e) {
			System.out.println("Out of range");
		}
	}
	
	
//	Test main constructor 
	
//	Test ID: B.2.1
// 	Test created by: Tim Bartrum
//	Date created: 27/04/18
	@Test
	public void testMainConstructor1() {
		CompanyProject testProject = new CompanyProject("0123456789");
		assertEquals("0123456789", testProject.getPTitle());
	}

//	Test get project id

//	Test ID: B.3.1
// 	Test created by: Joshua Richardson
//	Date created: 27/04/18
	
	@Test
	public void testGetProjectId1() {
		cp = new CompanyProject();
		assertEquals(CompanyEmailSystem.GlobalProjectCounter, cp.getPID());
	}
	

	
	
//	Test get project title

//	Test ID: B.4.1
// 	Test created by: Joshua Richardson
//	Date created: 30/04/18
	
	@Test
	public void testProjectTitle1() {
		CompanyProject cp = new CompanyProject();
		cp.setPTitle("0123456789");
		assertEquals("0123456789", cp.getPTitle());
	}
	
//	Test ID: B.4.2
// 	Test created by: Joshua Richardson
//	Date created: 30/04/18
	
	@Test
	public void testProjectTitle2() {
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
	public void testSetPTitle1() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle("Test Project");
		assertEquals("Test Project", testProject.getPTitle());
	}
	
//	Test ID: B.5.2
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testSetPTitle2() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle("Test Title");
		assertEquals("Test Title", testProject.getPTitle());
	}
	
//	Test ID: B.5.3
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testSetPTitle3() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle("Test");
		assertNotEquals("Test", testProject.getPTitle());
	}
	

//	Test is contact

//	Test ID: B.6.1
// 	Test created by: Tim Bartrum
//	Date created: 01/05/18
	@Test
	public void testIsContact1() {
		CompanyProject testProject = new CompanyProject();
		testProject.addContact("test@gmail.com");
		assertTrue(testProject.isContact("test@gmail.com"));
	}
	
//	Test ID: B.6.2
// 	Test created by: Tim Bartrum
//	Date created: 01/05/18
	@Test
	public void testIsContact2() {
		CompanyProject testProject = new CompanyProject();
		testProject.addContact("test2@gmail.com");
		assertFalse(testProject.isContact("test@gmail.com"));
	}
	

//	Test add contact

//	Test ID: B.7.1
// 	Test created by: Inigo Taylor
//	Date created: 29/04/18
	
	@Test
	public void testAddContact1() {
		String testInput = "psyit@nottingham.ac.uk";
		CompanyProject testProject = new CompanyProject();		
		testProject.addContact(testInput);
		int lastItem = testProject.getProjectContacts().size();
		
		assertEquals("psyit@nottingham.ac.uk",testProject.getProjectContacts().get(--lastItem));
	}
	
//	Test ID: B.7.2
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 01/05/18
	
	@Test
	public void testAddContact2() {
		CompanyProject testProject = new CompanyProject();
		CompanyEmail testEmail = new CompanyEmail();
		try {
			testProject.addEmail(testEmail);
			fail("Email was added, this is wrong as the email was invalid");
		} catch (Exception e) {
			assertEquals(new ArrayList<String>(), testProject.getProjectContacts());
		}
	}
	

//	Test add email

//	Test ID: B.8.1
// 	Test created by: Inigo Taylor
//	Date created: 27/04/18
	
	@Test
	public void testAddEmail1(){
		try {
			CompanyProject testProject = new CompanyProject();
			testProject.addEmail(new CompanyEmail());
			fail("Exception wasn't produced");
		} catch (Exception e) {
			assertEquals(e.getClass(), Exception.class);
		}
	}
	
//	Test ID: B.8.2
// 	Test created by: Tim Bartrum
//	Date created: 01/05/18
	@Test
	public void testAddEmail2() {
		try {
			CompanyProject testProject = new CompanyProject();		
			
			testProject.addEmail(new CompanyEmail("test@gmail.com", "test2@gmail.com", "Hi", "body"));
			
			ArrayList[] testList = new ArrayList[6];			
	        testList[0] = new ArrayList<CompanyEmail>();
	        
			CompanyEmail testEmail = new CompanyEmail("test@gmail.com", "test2@gmail.com", "Hi", "body");
            	        
            testList[0].add(testEmail);
            
			assertEquals(Arrays.toString(testProject.getProjectEmails()), Arrays.toString(testList));
		} catch (Exception e) {
			System.out.println(e.getClass());
			fail("Exception shouldn't happen here");
		}
	}
	
	

//	Test get email for current phase

//	Test ID: B.9.1
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	@Test
	public void testGetEmailCurrentPhase1() {
		cp = new CompanyProject();
		ArrayList array = new ArrayList();
		assertEquals(array,cp.getEmailsForPhase());
	}
	
//	Test ID: B.9.2
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	@Test
	public void testGetEmailCurrentPhase2() {
		cp = new CompanyProject();
		
		CompanyEmail email = new CompanyEmail("psyjr4@nottingham.ac.uk","psytb4@nottingham.ac.uk","Hi","Body");
		
		try {
			cp.addEmail(email);
		}catch(Exception e) {
			System.out.println("Invalid email");
		}
				
		ArrayList array = new ArrayList();
		array.add(email);
		
		assertEquals(array,cp.getEmailsForPhase());
	}
	
//	Test ID: B.9.3
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	@Test
	public void testGetEmailCurrentPhase3() {
		cp = new CompanyProject();
		
		ArrayList array = new ArrayList();
		
		for(int num = 0; num < 1000; num++) {
			CompanyEmail email = new CompanyEmail("psyjr"+num+"@nottingham.ac.uk","psytb4@nottingham.ac.uk","Hi"+num,"Body");
			
			try {
				cp.addEmail(email);
			}catch(Exception e) {
				fail("Invalid email");
			}
			
			array.add(email);
		}
		
		assertEquals(array, cp.getEmailsForPhase());
	}
	
	
	

//	Test get email for specific phase

//	Test ID: B.10.1
// 	Test created by: Joshua Richardson and Inigo Taylor
//	Date created: 01/05/18
	
	@Test
	public void testGetEmailForSpecificPhase1(){
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
	public void testGetEmailForSpecificPhase2() {
		CompanyProject cp = new CompanyProject();
		try {
			cp.getEmailsForPhase(-1);
			fail("Exception wasn't produced");
		}catch(Exception e) {
			assertEquals(e.getClass(), Exception.class); // From Inigo
		}
	}

	
	
//	Test ID: B.10.3
// 	Test created by: Joshua Richardson
//	Date created: 30/04/18
	
	@Test
	public void testGetEmailForSpecificPhase3() {
		CompanyProject cp = new CompanyProject();
		try {
			cp.getEmailsForPhase(cp.getPID()+1);
			fail("Exception wasn't produced");
		}catch(Exception e) {
			assertEquals(e.getClass(), Exception.class); // From Inigo
		}
		
	}
	

//	Test next phase 

//	Test ID: B.11.1
// 	Test created by: Inigo Taylor
//	Date created: 30/04/18
		
	@Test
	public void testNextPhase1(){
		CompanyProject testProject = new CompanyProject();
		for(int i=0; i<5; i++) {
			testProject.nextPhase();
		}
		assertEquals(false, testProject.nextPhase());
	}


//	Test ID: B.11.2
// 	Test created by: Inigo Taylor
//	Date created: 30/04/18
	
	@Test
	public void testNextPhase2(){
		CompanyProject testProject = new CompanyProject();
		for(int i=0; i<5; i++) {
			assertEquals(true, testProject.nextPhase());
		}
	}

//	Test get phase by name

//	Test ID: B.12.1
// 	Test created by: Joshua Richardson
//	Date created: 01/05/18
	
	@Test
	public void testGetPhaseByName1() {
		CompanyProject cp = new CompanyProject();
		for (int i = 0; i < 6; i++) {
			cp.setProjectPhase(i);
			assertEquals(CompanyEmailSystem.ProjectPhases[i], cp.getPhaseByName());
		}
	}

//	Test get phase by id

//	Test ID: B.13.1
// 	Test created by: Inigo Taylor, Tim Bartrum
//	Date created: 29/04/18
	
	@Test
	public void testGetPhaseByID1(){
		CompanyProject testProject = new CompanyProject();
		assertEquals(0, testProject.getPhaseByID());
	}
	

//	Test get project contacts

//	Test ID: B.14.1
// 	Test created by: Joshua Richardson
//	Date created: 28/04/18
	
	@Test
	public void testGetProjectContacts1(){
		CompanyProject cp = new CompanyProject();
		ArrayList<String> expected = new ArrayList<String>();
		assertEquals(cp.getProjectContacts(), expected);
	}
	
//	Test ID: B.14.2
// 	Test created by: Joshua Richardson
//	Date created: 28/04/18
	
	@Test
	public void testGetProjectContacts2(){
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
	public void testGetProjectContacts3(){
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
	public void testGetProjectContacts4(){
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
	public void testStringOverride1(){
		CompanyProject cp = new CompanyProject();
		cp.setPTitle("Hello Project");
		assertEquals( "Hello Project" + " [" + CompanyEmailSystem.ProjectPhases[cp.getPhaseByID()] + "]", cp.toString());
	}		
}