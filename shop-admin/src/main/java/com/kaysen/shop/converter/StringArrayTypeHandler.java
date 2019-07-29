package com.kaysen.shop.converter;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

/**	
 *	AezGenholmes 
 *	2016年4月19日
 *  描述： mybatis java类型为String[]数组--jdbc类型为varchar 处理工具类
 */
@MappedTypes({String[].class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class StringArrayTypeHandler implements TypeHandler<String[]> {
	   
    public String[] getResult(ResultSet rs, String columnName)  
                  throws SQLException {  
           String columnValue = rs.getString(columnName);  
           return this.getStringArray(columnValue);  
    }  

    public String[] getResult(ResultSet rs, int columnIndex)  
                  throws SQLException {  
           String columnValue = rs.getString(columnIndex);  
           return this.getStringArray(columnValue);  
    }  

    public String[] getResult(CallableStatement cs, int columnIndex)  
                  throws SQLException {  
           // TODO Auto-generated method stub  
           String columnValue = cs.getString(columnIndex);  
           return this.getStringArray(columnValue);  
    }  

    public void setParameter(PreparedStatement ps, int i, String[] parameter,  
                  JdbcType jdbcType) throws SQLException {
           if (parameter == null)  
                  ps.setNull(i, Types.VARCHAR);  
           else {  
                  StringBuffer result = new StringBuffer();  
                  for (String value : parameter)  
                         result.append(value).append(",");  
                  result.deleteCharAt(result.length()-1);  
                  ps.setString(i, result.toString());  
           }  
    }  

    private String[] getStringArray(String columnValue) {  
           if (columnValue == null)  
                  return null;  
           return columnValue.split(",");  
    }  

}