package com.springlearnig.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {
    
	
	public String formatLocalDateTimeToDataBaseStily(LocalDateTime localDateTime) {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime); 
	}
	
}
