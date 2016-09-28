package com.gopi.starter;
/**
 * @author gopi
 */
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gopi.writer.dbWriterClass;

public class AppViewer {
	public static void main(String args[]) throws Exception{
		String[] springConfig  = 
			{	"spring/batch/config/database.xml", 
				"spring/batch/config/context.xml",
				"spring/batch/jobs/job-report.xml" 
			};
		
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);
		
		dbWriterClass templateInstance = (dbWriterClass) context.getBean("OracleDBItemWriter");
		
		List<Map<String,Object>> result=templateInstance.getResult();
		JettyStart.redirectWeb(result);
	}
}
