// https://docs.google.com/document/d/1migYYyWoCX3aydqz9rkFh2q5YYehMueO_p8LHfVqLb4/edit

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import emailScripts.CompanyEmail;

public class TestCompanyEmail {

	//-------Data----------
	String fAddress ="sender@nottingham.ac.uk";
	String tAddress ="receiver@nottingham.ac.uk";
	String subLine = "subject";
	String eMessage = "msg";
	CompanyEmail data = new CompanyEmail();
	//---------------------
	
	//	Test default constructor
		
	//	Test ID: A.1.1
	// 	Test created by: f_name s_name
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
	
	
	
//	Test main constructor
	
//	Test ID: A.2.1
// 	Test created by: Julian Kubelec
//	Date created: 26/04/18 
@Test
	public void testMainConstructor_1() {
		assertNotNull(new CompanyEmail(fAddress, tAddress, subLine, eMessage));
}



	//Test get method for sender’s address
	//	Test ID: A.3.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/2018
	@Test
	public void testFromAddress_1() {
		CompanyEmail data = new CompanyEmail(
				fAddress, null, null, null);
		assertEquals(data.fromAddress(), fAddress);
	}
	
	//	Test ID: A.3.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/2018
	@Test
	public void testFromAddress_2() {
		CompanyEmail data = new CompanyEmail(
				null, null, null, null);
		assertNull(data.fromAddress());
	}
	
	
	
//	Test get method for receiver’s address 

//	Test ID: A.4.1
// 	Test created by: Julian Kubelec
//	Date created: 26/04/18
	@Test
	public void testToAddress_1() {
		CompanyEmail data = new CompanyEmail(
				null, "receiver@nottingham.ac.uk", null, null);
		assertEquals(data.toAddress(), "receiver@nottingham.ac.uk");
	}
//	Test ID: A.4.2
// 	Test created by: Julian Kubelec
//	Date created: 26/04/18
	@Test
	public void testToAddress_2() {
		CompanyEmail data = new CompanyEmail(
				null, null, null, null);
		assertNull(data.toAddress());
	}
	
	
	//	Test get method for subject line
	
	//	Test ID: A.5.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/2018
	@Test
	public void testSubjectLine_1() {
		CompanyEmail data = new CompanyEmail(
				null, null, "subject", null);
		assertEquals(data.subjectLine(), "subject");
	}
		
	//	Test ID: A.5.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/201
	@Test
	public void testSubjectLine_2() {
		CompanyEmail data = new CompanyEmail(
				null, null, null, null);
		assertNull(data.subjectLine());
	}
	
	
	//	Test get method email body
	
	//	Test ID: A.6.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/2018
	@Test
	public void testEmailMessage_1() {
		CompanyEmail data = new CompanyEmail(
				null, null, null, "body");
		assertEquals(data.emailMessage(), "body");
	}
		
	//	Test ID: A.6.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/2018
	@Test
	public void testEmailMessage_2() {
		CompanyEmail data = new CompanyEmail(
				null, null, null, null);
		assertNull(data.emailMessage());
	}
	
//	Test set method for sender’s address

//	Test ID: A.7.1
// 	Test created by: Julian Kubelec
//	Date created: 26/04/18
	@Test
	public void testSetFrom() {
		
	}
	
//	Test ID: L.N.N
// 	Test created by: f_name s_name
//	Date created: dd/mm/yy
	
	
	
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
