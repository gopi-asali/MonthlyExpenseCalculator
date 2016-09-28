package com.gopi.writer;
/**
 * 
 * @author gopi
 *
 */
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.gopi.starter.JettyStart;

public class dbWriterClass extends JdbcDaoSupport implements ItemWriter<String [] > {
		private  String sql;
		public static String[] columnNames;

	@Override
	public void write(final List<? extends String [] > values) throws Exception {
		String dateValue=getDateValue();
		this.getJdbcTemplate().execute("DELETE FROM SHARES WHERE TO_DATE(C_DATE) ='"+dateValue+"'");
		this.getJdbcTemplate().execute("DELETE FROM BALANCE WHERE TO_DATE(CALC_DATE) ='"+dateValue+"'");
		System.out.println("Table data deleted for the  day of : "+ dateValue);
			this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					String[] value=values.get(i);
					ps.setString(1, value[0]);
					ps.setString(2, value[1]);
					ps.setString(3, value[2]);
					ps.setString(4, value[3]);
					ps.setString(5, value[4]);
					ps.setString(6, value[5]);
				}

				@Override
				public int getBatchSize() {
					return values.size();
				}
			  } );
			CallableStatement callableStatement=getConnection().prepareCall("{call P_SHARES(280916)}");
			callableStatement.execute();
			List<Map<String,Object>> result =this.getJdbcTemplate().queryForList("SELECT RPAD(S_NO,4,' ') AS S_NO, RPAD(NAME,30,' ') AS NAME, RPAD(AMOUNT,10,' ') AS AMOUNT,RPAD(CALC_DATE,10,' ') AS CALC_DATE FROM BALANCE WHERE TO_DATE(CALC_DATE)='"+dateValue+"'");
			JettyStart.redirectWeb(result);
	}
public List<Map<String,Object>> getResult(){
	String dateValue=getDateValue();
	List<Map<String,Object>> result;
	if(dateValue.equals("ALL"))
	 result =this.getJdbcTemplate().queryForList("SELECT RPAD(S_NO,4,' ') AS S_NO, RPAD(NAME,30,' ') AS NAME, RPAD(AMOUNT,10,' ') AS AMOUNT,RPAD(CALC_DATE,10,' ') AS CALC_DATE FROM BALANCE");
	else
		result=this.getJdbcTemplate().queryForList("SELECT RPAD(S_NO,4,' ') AS S_NO, RPAD(NAME,30,' ') AS NAME, RPAD(AMOUNT,10,' ') AS AMOUNT,RPAD(CALC_DATE,10,' ') AS CALC_DATE FROM BALANCE  WHERE TO_DATE(CALC_DATE)='"+dateValue+"'");
	return result;
}
protected String getDateValue(){
	
	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy ");
	Date date = new Date();
	  String dateValue=dateFormat.format(date);
	if(System.getenv("calcDate")!=null&&!System.getenv("calcDate").isEmpty())
		dateValue=System.getenv("calcDate");
	return dateValue;
}


	public void setSql(String sql) {
		List<Map<String, Object>> values=this.getJdbcTemplate().queryForList("SELECT COLUMN_NAME FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='SHARES' AND COLUMN_NAME!='C_DATE' ORDER BY COLUMN_ID");
		columnNames=new String[values.size()];
		int i=0;
		String query="insert into SHARES( ";
		String quesComm="";
		for(Map<String, Object> columns:values){
		String names=(String) columns.get("COLUMN_NAME");
		columnNames[i]=names;
		if(i==values.size()-1){
			query=query+names+" ) values ( ";
			quesComm=quesComm+"?)";
		}else{
		query=query+names+",";
		quesComm=quesComm+"?,";
		}
		
		i++;
	}
		this.sql=query+quesComm;
		System.out.println("sql is :"+this.sql);
	
	
	}

}
