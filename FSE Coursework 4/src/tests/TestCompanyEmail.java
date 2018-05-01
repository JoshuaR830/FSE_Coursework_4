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
	String newAddrLongBoye = "JulianKubelecIsAGoodBoiButLittleDidYouKnowThatIAmActuallyTheDestroyerOfWorldsXxammthorhahajklolThisIsJustATestToSeeIfThisEmailAddressWillWorkOrNotHahahaFunnixdddd@gmail.com";
	
	CompanyEmail data = new CompanyEmail();
	// ----------------------
	
	
	//	Test: defaultConstructor()
	
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
		
	
	//	Test: mainConstructor()
		
	//	Test ID: A.2.1
	// 	Test created by: Julian Kubelec
	//	Date created: 1/05/18 
	@Test
	public void testMainConstructor_1() {
		assertNotNull(new CompanyEmail(fAddress, tAddress, subLine, eMessage));
		assertEquals(data.fromAddress(), fAddress);
		assertEquals(data.toAddress(), tAddress);
		assertEquals(data.subjectLine(), subLine);
		assertEquals(data.emailMessage(), eMessage);
	}


	//  Test: fromAddress()
	
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
	
	
	//	Test: toAddress()
	
	//	Test ID: A.4.1
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testToAddress_1() {
		data = new CompanyEmail(null, tAddress, null, null);
		assertEquals(data.toAddress(), tAddress);
	}
	
	//	Test ID: A.4.2
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testToAddress_2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.toAddress());
	}
	
	
	//	Test: subjectLine()
	
	//	Test ID: A.5.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testSubjectLine_1() {
		data = new CompanyEmail(null, null, subLine, null);
		assertEquals(data.subjectLine(), subLine);
	}
		
	//	Test ID: A.5.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testSubjectLine_2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.subjectLine());
	}
	
	
	//	Test: emailMessage()
	
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
	
	
	//	Test: setFrom()
	
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
		assertNull(data.fromAddress());
	}

	//	Test ID: A.7.3
	// 	Test created by: Julian Kubelec
	//	Date created: 30/04/18
	@Test
	public void testSetFrom_3() {
		data = new CompanyEmail();
		data.setFrom(newAddrLongBoye);
		assertNull(data.fromAddress());
	}
	
	//	Test ID: A.7.4
	// 	Test created by: Julian Kubelec
	//	Date created: 30/04/18
	@Test
	public void testSetFrom_4() {
		data = new CompanyEmail();
		assertNull(data.fromAddress());
	}
	
	
	//	Test: setTo()
	
	//	Test ID: A.8.1
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo_1() {
		data = new CompanyEmail();
		data.setTo(newAddrValid);
		assertEquals(data.toAddress(), newAddrValid);
	}	
	//	Test ID: A.8.2
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo_2() {
		data = new CompanyEmail();
		data.setTo(newAddrInvalid);
		assertNull(data.toAddress());
	}
//	Test ID: A.8.3
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo_3() {
		data = new CompanyEmail();
		data.setTo(newAddrLongBoye);
		assertNull(data.toAddress());
	}	
//	Test ID: A.7.4
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo_4() {
		data = new CompanyEmail();
		assertNull(data.fromAddress());
	}
		
	//	Test: setSubject()
	
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
		
	//	Test: setMessage()
	
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
		
	//	Test: isValid()
	
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
		
	//	Test ID: L.N.N
	// 	Test created by: f_name s_name
	//	Date created: dd/mm/yy
}
