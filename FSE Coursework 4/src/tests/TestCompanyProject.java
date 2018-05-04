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
	
	String testEmailA = "test";
	String testEmailB = "@gmail.com";
	
	String testEmail1 = "test1@gmail.com";
	String testEmail2 = "test2@gmail.com";
	String testEmail3 = "test3@gmail.com";
	String subject = "subject";
	String body = "body"; 
	
	String testPTitle = "Test Project";
	String testPTitle2= "New Project";
	String testPTitleInvalid= "Test";
	
	String failMsg1 = "Email was added, this is wrong as the email was invalid";
	String failMsg2 = "Exception wasn't produced"; 
	String failMsg3 = "Exception shouldn't happen here";
	String failMsg4 = "Invalid email";
	String failMsg5 = "Out of range";
	
	
	//	Test: defaultConstructor()
	
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
		assertEquals(testPTitle2, testProject.getPTitle());
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
			System.out.println(failMsg5);
		}
	}
	
	
	//	Test mainConstructor() 
		
	//	Test ID: B.2.1
	// 	Test created by: Tim Bartrum
	//	Date created: 27/04/18
	@Test
	public void testMainConstructor1() {
		CompanyProject testProject = new CompanyProject(testPTitle);
		assertEquals(testPTitle, testProject.getPTitle());
	}

	
	//	Test: getPID()
	
	//	Test ID: B.3.1
	// 	Test created by: Joshua Richardson
	//	Date created: 27/04/18
	@Test
	public void testGetProjectId1() {
		cp = new CompanyProject();
		assertEquals(CompanyEmailSystem.GlobalProjectCounter, cp.getPID());
	}
	
	
	//	Test getPTitle()
	
	//	Test ID: B.4.1
	// 	Test created by: Joshua Richardson
	//	Date created: 30/04/18
	@Test
	public void testProjectTitle1() {
		CompanyProject cp = new CompanyProject();
		cp.setPTitle(testPTitle);
		assertEquals(testPTitle, cp.getPTitle());
	}
	
	//	Test ID: B.4.2
	// 	Test created by: Joshua Richardson
	//	Date created: 30/04/18
	@Test
	public void testProjectTitle2() {
		CompanyProject cp = new CompanyProject();
		cp.setPTitle(testPTitleInvalid);
		assertNotEquals(testPTitleInvalid, cp.getPTitle());
	}
	
	
	//	Test: setPTitle()
	
	//	Test ID: B.5.1
	// 	Test created by: Inigo Taylor
	//	Date created: 29/04/18
	@Test
	public void testSetPTitle1() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle(testPTitle);
		assertEquals(testPTitle, testProject.getPTitle());
	}
	
	//	Test ID: B.5.2
	// 	Test created by: Inigo Taylor
	//	Date created: 29/04/18
	@Test
	public void testSetPTitle2() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle(testPTitle2);
		assertEquals(testPTitle2, testProject.getPTitle());
	}
	
	//	Test ID: B.5.3
	// 	Test created by: Inigo Taylor
	//	Date created: 29/04/18
	@Test
	public void testSetPTitle3() {
		CompanyProject testProject = new CompanyProject();
		testProject.setPTitle(testPTitleInvalid);
		assertNotEquals(testPTitleInvalid, testProject.getPTitle());
	}
	

	//	Test: isContact()
	
	//	Test ID: B.6.1
	// 	Test created by: Tim Bartrum
	//	Date created: 01/05/18
	@Test
	public void testIsContact1() {
		CompanyProject testProject = new CompanyProject();
		testProject.addContact(testEmail1);
		assertTrue(testProject.isContact(testEmail1));
	}
	
	//	Test ID: B.6.2
	// 	Test created by: Tim Bartrum
	//	Date created: 01/05/18
	@Test
	public void testIsContact2() {
		CompanyProject testProject = new CompanyProject();
		testProject.addContact(testEmail2);
		assertFalse(testProject.isContact(testEmail1));
	}
	

	//	Test: addContact()
	
	//	Test ID: B.7.1
	// 	Test created by: Inigo Taylor
	//	Date created: 29/04/18
	@Test
	public void testAddContact1() {
		CompanyProject testProject = new CompanyProject();		
		testProject.addContact(testEmail1);
		int lastItem = testProject.getProjectContacts().size();
		
		assertEquals(testEmail1,testProject.getProjectContacts().get(--lastItem));
	}
	
	//	Test ID: B.7.2
	// 	Test created by: Inigo Taylor, Joshua Richardson
	//	Date created: 01/05/18
	@Test
	public void testAddContact2() {
		CompanyProject testProject = new CompanyProject();
		CompanyEmail tEmail = new CompanyEmail();
		try {
			testProject.addEmail(tEmail);
			fail(failMsg1);
		} catch (Exception e) {
			assertEquals(new ArrayList<String>(), testProject.getProjectContacts());
		}
	}
	

	//	Test: addEmail()
	
	//	Test ID: B.8.1
	// 	Test created by: Inigo Taylor
	//	Date created: 27/04/18
	@Test
	public void testAddEmail1(){
		try {
			CompanyProject testProject = new CompanyProject();
			testProject.addEmail(new CompanyEmail());
			fail(failMsg2);
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
			
			testProject.addEmail(new CompanyEmail(testEmail1, testEmail2, subject, body));
			
			ArrayList[] testList = new ArrayList[6];			
	        testList[0] = new ArrayList<CompanyEmail>();
	        
			CompanyEmail tEmail = new CompanyEmail(testEmail1, testEmail2, subject, body);
			
            testList[0].add(tEmail);      
			assertEquals(Arrays.toString(testProject.getProjectEmails()), Arrays.toString(testList));
		} catch (Exception e) {
			System.out.println(e.getClass());
			fail(failMsg3);
		}
	}
	

	//	Test: getEmailsForPhase()
	
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
		
		CompanyEmail email = new CompanyEmail(testEmail1,testEmail2,subject,body);
		
		try {
			cp.addEmail(email);
		}catch(Exception e) {
			System.out.println(failMsg4);
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
			CompanyEmail email = new CompanyEmail(testEmailA+num+testEmailB,testEmail1,subject+num, body);
			
			try {
				cp.addEmail(email);
			}catch(Exception e) {
				fail(failMsg4);
			}
			
			array.add(email);
		}
		
		assertEquals(array, cp.getEmailsForPhase());
	}
	

	//	Test: getEmailsForPhase(thePhase)
	
	//	Test ID: B.10.1
	// 	Test created by: Joshua Richardson and Inigo Taylor
	//	Date created: 01/05/18
	@Test
	public void testGetEmailForSpecificPhase1(){
		CompanyProject cp = new CompanyProject();
		try {

			CompanyEmail ce = new CompanyEmail(testEmail1,testEmail2, subject, body);
			cp.addEmail(ce);
			ArrayList[] projectEmails = cp.getProjectEmails();	
			assertEquals(cp.getEmailsForPhase(1), projectEmails[1]);

		}catch(Exception e) {
			fail(failMsg3);
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
			fail(failMsg2);
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
			fail(failMsg2);
		}catch(Exception e) {
			assertEquals(e.getClass(), Exception.class); // From Inigo
		}
		
	}
	

	//	Test: nextPhase() 
	
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

	
	//	Test: getPhaseByName()
	
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

	
	//	Test: getPhaseByID()
	
	//	Test ID: B.13.1
	// 	Test created by: Inigo Taylor, Tim Bartrum
	//	Date created: 29/04/18
	@Test
	public void testGetPhaseByID1(){
		CompanyProject testProject = new CompanyProject();
		assertEquals(0, testProject.getPhaseByID());
	}
	

	//	Test: getProjectContacts()
	
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
		expected.add(testEmail1);
		cp.addContact(testEmail1);
		assertEquals(cp.getProjectContacts(), expected);
	}
	
	//	Test ID: B.14.3
	// 	Test created by: Joshua Richardson
	//	Date created: 28/04/18
	@Test
	public void testGetProjectContacts3(){
		CompanyProject cp = new CompanyProject();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(testEmail1);
		cp.addContact(testEmail1);
		expected.add(testEmail2);
		cp.addContact(testEmail2);
		expected.add(testEmail3);
		cp.addContact(testEmail3);
		
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
			expected.add(testEmailA+num+testEmailB);
			cp.addContact(testEmailA+num+testEmailB);
		}
		assertEquals(cp.getProjectContacts(), expected);
	}
	
	
	//	Test: toString()
	
	//	Test ID: B.15.1
	// 	Test created by: Joshua Richardson
	//	Date created: 27/04/18
	@Test
	public void testStringOverride1(){
		CompanyProject cp = new CompanyProject();
		cp.setPTitle(testPTitle);
		assertEquals( testPTitle + " [" + CompanyEmailSystem.ProjectPhases[cp.getPhaseByID()] + "]", cp.toString());
	}		
}