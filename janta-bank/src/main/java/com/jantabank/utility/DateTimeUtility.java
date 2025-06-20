package com.jantabank.utility;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class DateTimeUtility 
{
	public String getCurrentDate()
	{
		LocalDate localDate=LocalDate.now();
		StringBuffer stringBuffer=new StringBuffer();
		int date=localDate.getDayOfMonth();
		stringBuffer.append(date<10?"0"+date:date);
		stringBuffer.append("-");
		int month=localDate.getMonthValue();
		stringBuffer.append(month<10?"0"+month:month);
		stringBuffer.append("-");
		stringBuffer.append(localDate.getYear());
		return stringBuffer.toString();
	}
	public String getCurrentTime()
	{
		LocalTime localTime=LocalTime.now();
		StringBuffer stringBuffer=new StringBuffer();
		int h=localTime.getHour();
		stringBuffer.append(h<10?"0"+h:h);
		stringBuffer.append(":");
		int m=localTime.getMinute();
		stringBuffer.append(m<10?"0"+m:m);
		stringBuffer.append(":");
		int s=localTime.getSecond();
		stringBuffer.append(s<10?"0"+s:s);
		return stringBuffer.toString();
	}
}
