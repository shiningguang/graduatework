package com.intelligentCommunity.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
		public static String getNow() {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return sdf.format(date);
		}
		
		public static void main(String[] args) {
			System.err.println(LongToStringTime(System.currentTimeMillis()));
		}
		
		
		public static String LongToStringTime(long l){
			Date date = new Date(l);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}
}
