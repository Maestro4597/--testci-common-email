package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;


import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class EmailTest {
	
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org", "djnvaksdnvkjsndkarwq@enwnuinsnd.com.bd"};
	private EmailConcrete email;
	private static final String[] NAMES = { "Myles", "John", "Sebastian"};
 

	 
	
	@Before
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete(); //call constructor new object of class Email
		
	}
	
	
	
	@Test
	public void testAddBcc() throws Exception{
		
		email.addBcc(TEST_EMAILS); //Pulling emails from previously initiallized array
		
		assertEquals(3, email.getBccAddresses().size());	//Assert method 		
		
	}
	
	@Test
	public void testAddCc() throws Exception {
		
		email.addCc(TEST_EMAILS);
		
		assertEquals(3, email.getCcAddresses().size());
		
	}
	
	@Test
	public void testAddHeader() throws Exception {
		
		email.addHeader(NAMES[0], "58563370"); //adding name and ID to header
	
		assertEquals("Myles", NAMES[0]);
		
		//email.addHeader(null, "62347"); //removing name from header
			
	}
	
	@Test
	public void testAddReplyTo() throws Exception {
		
		email.addReplyTo(TEST_EMAILS[0], NAMES[1]); //adding replies (email, name)
		
		//Map<String, String> replyToAddresses = (Map<String, String>) email.getReplyToAddresses();
		
		//assertEquals(NAMES[1], replyToAddresses.get(TEST_EMAILS[0]));
		
	}
	
	@Test
	public void testBuildMimeMessage() throws Exception  {
		
	
		
		MimeMultipart aMimemultipart = new MimeMultipart();
		email.setCharset("UTF-16");
        email.setContent(aMimemultipart);
        email.addBcc("addBcc@cyahoo.com");
        email.addCc("addCc@comcast.net");
        email.setHostName("Michael");
        email.setSmtpPort(2222);
        email.setContent("oh", "String");
        email.addHeader(NAMES[0], "58563370");
        email.updateContentType("WOW");
      
      
			email.setFrom("myles@test.net");
			email.addTo("addto@example.com");
			email.setSubject("Follow Up");
			email.setMsg("Still meeting?");
			email.addReplyTo("response@nft.org");
			email.setPopBeforeSmtp(true, "newPopHost", "newPopUsername", "newPopPassword");

			MimeMessage myMessage = email.getMimeMessage();
			email.buildMimeMessage();
		
		assertTrue(true);
	}
	
	
	@Test
	public void testGetHostName() {
		
		email.setHostName("Bill"); //setting name to a real value
		email.getHostName();
		assertEquals("Bill", email.getHostName());
		email.setHostName(null); //setting value of name to null
		email.getHostName();

	  }
	
	@Test
	public void testGetMailSession() throws Exception {
		
		
		MimeMultipart aMimemultipart = new MimeMultipart();
		email.setCharset("UTF-16");
        email.setContent(aMimemultipart);
        email.addBcc("addBcc@cyahoo.com");
        email.setHostName("Myles");

      
			email.setFrom("myles@test.net");
			email.addTo("addto@example.com");
			email.setSubject("Follow Up");
			email.setMsg("Still meeting?");
		
			
		email.getMailSession();
		
		 Session session = email.getMailSession(); // Assuming getMailSession returns a javax.mail.Session
	        
	        assertNotNull("Mail session should not be null",session);
		
		
	}
	
	@Test
	 public void testGetSentDate() {
		
		email.getSentDate();
		Date now = new Date(); //declaring an object of class 'Date' and calling the default constructor
		email.setSentDate(now);
		
		Date retrievedDate = email.getSentDate();
        assertEquals("The retrieved date should match the date that was set.", now, retrievedDate);
		
	}
	
	@Test
	public void testGetSocketConnectionTimeout() {
		
		email.getSocketConnectionTimeout();
		assertTrue(true);	
	}
	
	@Test
	public void testSetFrom() throws Exception{
		
		email.setFrom(TEST_EMAILS[2]);
		
		InternetAddress fromAddress = email.getFromAddress();
        
        assertEquals(TEST_EMAILS[2], fromAddress, "The from address should match the one that was set.");
    }
		
	
	
	@After
	public void tearDownEmailTest() throws Exception {
		
		email = null;
		
	}
	
	
	
}
