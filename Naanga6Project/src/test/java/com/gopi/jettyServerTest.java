package com.gopi;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
public class jettyServerTest {
	
	@Test
	public void Test(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy ");
		Date date = new Date();
		  System.out.println(dateFormat.format(date));
	}
	
}
