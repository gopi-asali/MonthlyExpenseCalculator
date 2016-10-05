package com.gopi.util;

/**
 * @author gopi
 */
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.InitializingBean;

import com.gopi.writer.dbWriterClass;

public class DbColumnNameTokenizer extends DelimitedLineTokenizer implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setNames(dbWriterClass.columnNames);
	}

}
