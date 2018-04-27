// https://docs.google.com/document/d/18v9pEzfbKsLBOuPCX-yKiDZYMQphwJoi_AcsFr_dBUI/edit

package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import emailScripts.CompanyEmail;
import emailScripts.CompanyEmailSystem;
import emailScripts.CompanyProject;

public class TestCompanyProject {
	int testProjectCounter;
	
	
//	Test default constructor

//	Test ID: B.1.1
// 	Test created by: Inigo Taylor, Joshua Richardson
//	Date created: 27/04/18
	@Before
	public void beforeDefaultConstructor_B11_B12() {
		CompanyProject testProject1 = new CompanyProject();
		testProjectCounter = CompanyEmailSystem.GlobalProjectCounter;
	}	
	
	@Test
	public void testDefaultConstructor_B11(){
		CompanyProject testProject2 = new CompanyProject();
		assertEquals(++testProjectCounter,  CompanyEmailSystem.GlobalProjectCounter);
	}	
	
//	Test ID: B.1.2
// 	Test created by: Inigo Taylor
//	Date created: 27/04/18	
	@Test
	public void testDefaultConstructor_B12() {
		CompanyProject testProject2 = new CompanyProject();
		assertEquals(++testProjectCounter, testProject2.getPID());
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
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
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
		CompanyProject cp = new CompanyProject();
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
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
	

//	Test to string override

//	Test ID: B.15.1
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
	
}


