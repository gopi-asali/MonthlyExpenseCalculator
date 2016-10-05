package com.gopi.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * 
 * @author gopi
 *
 */
public class MapFieldSetMapper implements FieldSetMapper<String[]> {

	@Override
	public String[] mapFieldSet(FieldSet fieldSet) throws BindException {
		String[] values = fieldSet.getValues();
		return values;
	}

}
