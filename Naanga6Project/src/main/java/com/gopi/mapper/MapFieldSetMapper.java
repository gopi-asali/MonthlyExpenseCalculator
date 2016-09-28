package com.gopi.mapper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
/**
 * 
 * @author gopi
 *
 */
public class MapFieldSetMapper  implements FieldSetMapper<String [] > {

	@Override
	public String []  mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		
		Map<String,String> mapValues=new HashMap<String, String>();
		int i=0;
		String [] values=fieldSet.getValues();
		String[] names=fieldSet.getNames();
		Integer finalValues[]=new Integer[6];
		for(String key:names){
			finalValues[i]=Integer.parseInt(values[i]);
		}
		return values;
	}

}
