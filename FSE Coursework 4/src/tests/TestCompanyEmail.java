// https://docs.google.com/document/d/1migYYyWoCX3aydqz9rkFh2q5YYehMueO_p8LHfVqLb4/edit

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import emailScripts.CompanyEmail;

public class TestCompanyEmail {
	
	// ------- Data ----------
	String fAddress ="sender@nottingham.ac.uk";
	String tAddress ="receiver@nottingham.ac.uk";
	String subLine = "subject";
	String eMessage = "msg";
	String newAddrValid = "psyjk4@nottingham.ac.uk";
	String newAddrInvalid = "psyjk4@nott";
	
	CompanyEmail data = new CompanyEmail();
	// ----------------------
	
	
	//	Test default constructor
	
	//	Test ID: A.1.1
	// 	Test created by: Henry Hunt
	//  Test created: 26/04/18
	@Test
	public void testDefaultConstructor() {
		data = new CompanyEmail();
		
		assertNull(data.fromAddress());
		assertNull(data.toAddress());
		assertNull(data.subjectLine());
		assertNull(data.emailMessage());
	}
		
	
	//	Test main constructor
		
	//	Test ID: A.2.1
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18 
	@Test
	public void testMainConstructor_1() {
		assertNotNull(new CompanyEmail(fAddress, tAddress, subLine, eMessage));
	}


	//  Test get method for sender’s address
	
	//	Test ID: A.3.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testFromAddress_1() {
		data = new CompanyEmail(fAddress, null, null, null);
		assertEquals(data.fromAddress(), fAddress);
	}
	
	//	Test ID: A.3.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testFromAddress_2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.fromAddress());
	}
	
	
	//	Test get method for receiver’s address 
	
	//	Test ID: A.4.1
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testToAddress_1() {
		data = new CompanyEmail(null, "receiver@nottingham.ac.uk", null, null);
		assertEquals(data.toAddress(), "receiver@nottingham.ac.uk");
	}
	
	//	Test ID: A.4.2
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testToAddress_2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.toAddress());
	}
	
	
	//	Test get method for subject line
	
	//	Test ID: A.5.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testSubjectLine_1() {
		data = new CompanyEmail(null, null, "subject", null);
		assertEquals(data.subjectLine(), "subject");
	}
		
	//	Test ID: A.5.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testSubjectLine_2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.subjectLine());
	}
	
	
	//	Test get method email body
	
	//	Test ID: A.6.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testEmailMessage_1() {
		data = new CompanyEmail(null, null, null, eMessage);
		assertEquals(data.emailMessage(), eMessage);
	}
		
	//	Test ID: A.6.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testEmailMessage_2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.emailMessage());
	}
	
	
	//	Test set method for sender’s address
	
	//	Test ID: A.7.1
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testSetFrom_1() {
		data = new CompanyEmail();
		data.setFrom(newAddrValid);
		assertEquals(data.fromAddress(), newAddrValid);
	}
	
	//	Test ID: A.7.2
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testSetFrom_2() {
		data = new CompanyEmail();
		data.setFrom(newAddrInvalid);
		assertNotEquals(data.fromAddress(), newAddrInvalid);
	}

	//	Test ID: A.7.3
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
	@Test
	public void testSetFrom_3() {
		
	}
	
	//	Test ID: A.7.4
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
	@Test
	public void testSetFrom_4() {
		
	}
	
	
	//	Test set method for receiver’s address
	
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
		
	//	Test set method for subject line
	
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
		
	//	Test set method for email body
	
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
		
	//	Test function to check validity
	
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
}
