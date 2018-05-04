// https://docs.google.com/document/d/1migYYyWoCX3aydqz9rkFh2q5YYehMueO_p8LHfVqLb4/edit

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import emailScripts.CompanyEmail;

public class TestCompanyEmail {
	
	// ------- Data ----------
	String fAddress ="sender@nottingham.ac.uk";
	String tAddress ="receiver@nottingham.ac.uk";
	String subLine = "subject";
	String eMessage = "body";
	String newAddrInvalid = "abcdefg";
	String newAddrLong = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccccccccccccccccccccccccccccccccc@gmail.com";
	String emptyStr = "";
	
	CompanyEmail data = new CompanyEmail();
	// ----------------------
	
	
	//	Test: defaultConstructor()
	
	//	Test ID: A.1.1
	// 	Test created by: Henry Hunt
	//  Test created: 26/04/18
	@Test
	public void testDefaultConstructor1() {
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
	public void testMainConstructor1() {
		data = new CompanyEmail(fAddress, tAddress, subLine, eMessage);
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
	public void testFromAddress1() {
		data = new CompanyEmail(fAddress, null, null, null);
		assertEquals(data.fromAddress(), fAddress);
	}
	
	//	Test ID: A.3.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testFromAddress2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.fromAddress());
	}
	
	
	//	Test: toAddress()
	
	//	Test ID: A.4.1
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testToAddress1() {
		data = new CompanyEmail(null, tAddress, null, null);
		assertEquals(data.toAddress(), tAddress);
	}
	
	//	Test ID: A.4.2
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testToAddress2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.toAddress());
	}
	
	
	//	Test: subjectLine()
	
	//	Test ID: A.5.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testSubjectLine1() {
		data = new CompanyEmail(null, null, subLine, null);
		assertEquals(data.subjectLine(), subLine);
	}
		
	//	Test ID: A.5.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testSubjectLine2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.subjectLine());
	}
	
	
	//	Test: emailMessage()
	
	//	Test ID: A.6.1
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testEmailMessage1() {
		data = new CompanyEmail(null, null, null, eMessage);
		assertEquals(data.emailMessage(), eMessage);
	}
		
	//	Test ID: A.6.2
	// 	Test created by: Henry Hunt
	//	Date created: 27/04/18
	@Test
	public void testEmailMessage2() {
		data = new CompanyEmail(null, null, null, null);
		assertNull(data.emailMessage());
	}
	
	//	Test: setFrom()
	//	Test ID: A.7.1
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testSetFrom1() {
		data = new CompanyEmail();
		data.setFrom(fAddress);
		assertEquals(data.fromAddress(), fAddress);
	}
	
	//	Test ID: A.7.2
	// 	Test created by: Julian Kubelec
	//	Date created: 26/04/18
	@Test
	public void testSetFrom2() {
		data = new CompanyEmail();
		data.setFrom(newAddrInvalid);
		assertNull(data.fromAddress());
	}

	//	Test ID: A.7.3
	// 	Test created by: Julian Kubelec
	//	Date created: 30/04/18
	@Test
	public void testSetFrom3() {
		data = new CompanyEmail();
		data.setFrom(newAddrLong);
		assertNull(data.fromAddress());
	}
	
	//	Test ID: A.7.4
	// 	Test created by: Julian Kubelec
	//	Date created: 30/04/18
	@Test
	public void testSetFrom4() {
		data = new CompanyEmail(fAddress, tAddress, subLine, eMessage);
		data.setFrom(null);
		assertNull(data.fromAddress());
	}	
	
	//	Test: setTo()
	//	Test ID: A.8.1
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo1() {
		data = new CompanyEmail();
		data.setTo(tAddress);
		assertEquals(tAddress, data.toAddress());
	}	
	
	//	Test ID: A.8.2
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo2() {
		data = new CompanyEmail();
		data.setTo(newAddrInvalid);
		assertNull(data.toAddress());
	}
	
	//	Test ID: A.8.3
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo3() {
		data = new CompanyEmail();
		data.setTo(newAddrLong);
		assertNull(data.toAddress());
	}	
	
	//	Test ID: A.7.4
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void testSetTo4() {
		data = new CompanyEmail(fAddress, tAddress, subLine, eMessage);
		data.setTo(null);
		assertNull(data.toAddress());
	}
		
	//	Test: setSubject()
	
	//	Test ID: A.9.1
	// 	Test created by: Henry Hunt
	//	Date created: 01/05/18
	@Test
	public void testSetSubject1() {
		data = new CompanyEmail();
		data.setSubject(subLine);
		
		assertEquals(data.subjectLine(), subLine);
	}
	
	//	Test ID: A.9.2
	// 	Test created by: Henry Hunt
	//	Date created: 01/05/18
	@Test
	public void testSetSubject2() {
		data = new CompanyEmail();
		data.setSubject(emptyStr);
		assertEquals(data.subjectLine(), emptyStr);
	}
	
	//	Test ID: A.9.3
	// 	Test created by: Henry Hunt
	//	Date created: 01/05/18
	@Test
	public void testSetSubject3() {
		data = new CompanyEmail();
		data.setSubject(null);
		
		assertNull(data.subjectLine());
	}
	
		
	//	Test: setMessage()
	
	//	Test ID: A.10.1
	// 	Test created by: Henry Hunt
	//	Date created: 01/05/18
	@Test
	public void testSetMessage1() {
		data = new CompanyEmail();
		data.setMessage(eMessage);
		
		assertEquals(data.emailMessage(), eMessage);
	}
	
	//	Test ID: A.10.2
	// 	Test created by: Henry Hunt
	//	Date created: 01/05/18
	@Test
	public void testSetMessage2() {
		data = new CompanyEmail();
		data.setMessage(emptyStr);
		
		assertEquals(data.emailMessage(), emptyStr);
	}
	
	//	Test ID: A.10.3
	// 	Test created by: Henry Hunt
	//	Date created: 01/05/18
	@Test
	public void testSetMessage3() {
		data = new CompanyEmail(fAddress, tAddress, subLine, eMessage);
		data.setMessage(null);
		
		assertNull(data.emailMessage());
	}
	
		
	//	Test: isValid()
	
	//	Test ID: A.11.1
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void isValidTest1() {
		data = new CompanyEmail();
		assertEquals(data.isValid(), false);
	}
	
	//	Test ID: A.11.2
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void isValidTest2() {
		data = new CompanyEmail(null, null, emptyStr, null);
		assertEquals(data.isValid(), false);
	}
		
	//	Test ID: A.11.3
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void isValidTest3() {
		data = new CompanyEmail(null, emptyStr, null, null);
		assertEquals(data.isValid(), false);
	}
	
//	Test ID: A.11.4
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void isValidTest4() {
		data = new CompanyEmail(emptyStr, null, null, null);
		assertEquals(data.isValid(), false);
	}

//	Test ID: A.11.5
	// 	Test created by: Julian Kubelec
	//	Date created: 01/05/18
	@Test
	public void isValidTest5() {
		data = new CompanyEmail(emptyStr, emptyStr, emptyStr, emptyStr);
		assertEquals(data.isValid(), true);
	}
	
	//	Test: checkValidEmail()
	
	//	Test ID: A.12.1
	// 	Test created by: Joshua Richardson
	//	Date created: 01/05/18
	
	@Test
	public void testCheckValidEmail1() {
		CompanyEmail ce = new CompanyEmail();
		String address = null;
		assertFalse(ce.checkValidEmail(address));
	}
	
	//	Test ID: A.12.2
	// 	Test created by: Joshua Richardson
	//	Date created: 01/05/18
	
	@Test
	public void testCheckValidEmail2() {
		CompanyEmail ce = new CompanyEmail();
		assertTrue(ce.checkValidEmail(tAddress));
	}
	
	//	Test ID: A.12.3
	// 	Test created by: Joshua Richardson
	//	Date created: 01/05/18
	
	@Test
	public void testCheckValidEmail3() {
		CompanyEmail ce = new CompanyEmail();
		assertFalse(ce.checkValidEmail(newAddrInvalid));
	}
	
	//	Test ID: A.12.4
	// 	Test created by: Joshua Richardson
	//	Date created: 01/05/18
	
	@Test
	public void testCheckValidEmail4() {
		CompanyEmail ce = new CompanyEmail();
		assertFalse(ce.checkValidEmail(emptyStr));
	}
	
	//	Test ID: A.12.5
	// 	Test created by: Joshua Richardson
	//	Date created: 01/05/18
	
	@Test
	public void testCheckValidEmail5() {
		CompanyEmail ce = new CompanyEmail();
		assertFalse(ce.checkValidEmail(newAddrLong));
	}
	
	//  Test: check toString()
	
	//	Test ID: A.13.1
	// 	Test created by: Joshua Richardson
	//	Date created: 02/05/18
	
	@Test
	public void testToString_1() {
		CompanyEmail ce = new CompanyEmail();
		ce.setSubject(emptyStr);
		assertEquals("[no subject]", ce.toString());
	}
	
	
	
	//	Test ID: A.13.2
	// 	Test created by: Joshua Richardson
	//	Date created: 02/05/18
	
	@Test
	public void testToString2() {
		CompanyEmail ce = new CompanyEmail();
		ce.setSubject("  ");
		assertEquals("[no subject]", ce.toString());
	}
	
	
	//	Test ID: A.13.3
	// 	Test created by: Joshua Richardson
	//	Date created: 02/05/18
	
	@Test
	public void testToString3() {
		CompanyEmail ce = new CompanyEmail();
		ce.setSubject(subLine);
		assertEquals(subLine, ce.toString());
	}
}
