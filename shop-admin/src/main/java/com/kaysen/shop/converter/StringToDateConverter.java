package com.kaysen.shop.converter;

import com.kaysen.shop.utils.log.Logs;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * spring Controller自定义日期转换类
 * @author Administrator
 *
 */
public class StringToDateConverter implements Converter<String, Date> {
	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_DATE = "yyyy-MM-dd";
	public static final String PATTERN_MONTH = "yyyy-MM";

	@Override
	public Date convert(String source) {
		if(source != null && StringUtils.isNotBlank(source)) {
			SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_STANDARD);
			Date date = null;

			try {
				date = sdf.parse(source);
			} catch (ParseException e) {
				sdf = new SimpleDateFormat(PATTERN_DATE);
				try {
					date = sdf.parse(source);
				} catch (ParseException e1) {
					sdf = new SimpleDateFormat(PATTERN_MONTH);
					try{
						date = sdf.parse(source);
					}
					catch(ParseException e2){
						Logs.error(e2.getMessage());
					}
					Logs.error(e1.getMessage());
				}
				Logs.error(e.getMessage()); 
			}
//			System.out.println(source);
//			System.out.println(date);
			return date;
		}
		return null;
	}

}

