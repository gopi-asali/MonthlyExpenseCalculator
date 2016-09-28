package com.gopi.util;
/**
 * @author gopi
 */
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.gopi.writer.dbWriterClass;

public class DbColumnNameTokenizer extends DelimitedLineTokenizer implements InitializingBean{
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setNames(dbWriterClass.columnNames);
	}

}
