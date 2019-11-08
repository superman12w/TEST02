package com.xkit.ssm.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String,Date> {
	public Date convert(String param) {
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		Date d=null;
		try {
			d = sm.parse(param);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
}
