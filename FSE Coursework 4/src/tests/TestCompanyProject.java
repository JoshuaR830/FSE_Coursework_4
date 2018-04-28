// https://docs.google.com/document/d/18v9pEzfbKsLBOuPCX-yKiDZYMQphwJoi_AcsFr_dBUI/edit

package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
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
		CompanyProject testProject1 = new CompanyProject();
		assertEquals("New Project", testProject1.getPTitle());
	}
	
//	Test ID: B.1.4
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.1.5
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.1.6
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
//	Test main constructor 
	
//	Test ID: B.2.1
// 	Test created by: Tim
//	Date created: 27/04/18
	@Test
	public void testMainConstructor_B21() {
		CompanyProject testProject = new CompanyProject("Cool Test");
		assertEquals("Cool Test", testProject.getPTitle());
	}
	
//	Test ID: B.2.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
	
//	Test ID: B.2.3
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.2.4
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.2.5
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.2.6
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

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
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test set project title

//	Test ID: B.5.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.5.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test is contact

//	Test ID: B.6.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.6.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test add contact

//	Test ID: B.7.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
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
			CompanyProject testProject1 = new CompanyProject();
			testProject1.addEmail(new CompanyEmail());
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
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.10.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test next phase 

//	Test ID: B.11.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
//	Test ID: B.11.2
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test get phase by name

//	Test ID: B.12.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

//	Test get phase by id

//	Test ID: B.13.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	

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


