package com.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AppDateTime {
	public static void main(String[] args) {
		/* Todays Date*/
		System.out.println(LocalDate.now());
		
		/* Custom Date */
		LocalDate customDate = LocalDate.of(2022,07,10);
		System.out.println(customDate);
		
		/* String to Date Conversion */
		String strDate= "2022-07-08";
		LocalDate ld = LocalDate.parse(strDate);
		System.out.println(ld);
		
		/* Utility Methods */
		System.out.println("1 day after today is: ");
		System.out.println(LocalDate.now().plusDays(1));
		System.out.println("1 day before customDate: ");
		System.out.println(customDate.minusDays(1));
		System.out.println("1 Month after today");
		System.out.println(LocalDate.now().plusMonths(1));
		
		/* Date Comparision*/
		String couponLastDate="2022-07-08";
		boolean isBefore = LocalDate.parse(couponLastDate).isBefore(LocalDate.now());
		System.out.println(isBefore);
		boolean isAfter = LocalDate.parse(couponLastDate).isAfter(LocalDate.now());
		System.out.println(isAfter);
		String offerStartDate="2022-07-13";
		boolean isAfterOfffer = LocalDate.parse(LocalDate.now().toString()).isAfter(LocalDate.parse(offerStartDate));
		System.out.println(isAfterOfffer);
		
		/* Meaningful Info From Date*/
		DayOfWeek day = LocalDate.now().getDayOfWeek();
		System.out.println(day);
		int DayofMonth = LocalDate.now().getDayOfMonth();
		System.out.println(DayofMonth);
		int dayOfYear = LocalDate.now().getDayOfYear();
		System.out.println(dayOfYear);
		
		boolean isLeapYear = LocalDate.now().isLeapYear();
		System.out.println(isLeapYear);
		
		Period p = Period.between(LocalDate.parse(couponLastDate), LocalDate.now());
		System.out.println(p);
		
		long days = ChronoUnit.DAYS.between(LocalDate.parse(couponLastDate), LocalDate.now());
		System.out.println(days);
		
		/* LocalTime Class */
		/* Current Time */
		System.out.println(LocalTime.now());
		/* Custom Time*/
		System.out.println(LocalTime.parse("10:50"));
		System.out.println(LocalTime.parse("22:50"));
		/* Utility Methods */
		//LocalTime.now().plus(2,ChronoUnit.DECADES);
		System.out.println(LocalTime.now().plus(2,ChronoUnit.HOURS));
		
		boolean isBeforeTime = LocalTime.parse("08:50").isBefore(LocalTime.parse("09:00"));
		System.out.println(isBeforeTime);
		
		/* 
		 * LocalDateTime - Not that useful but you might as well know it 
		 *  */
		System.out.println(LocalDateTime.now());
		String date = LocalDateTime.now().toString().split("T")[0];
		String time = LocalDateTime.now().toString().split("T")[1];
		
		System.out.println(date + "\t" + time);
		
		System.out.println(LocalDateTime.of(2022,Month.JULY, 15, 10, 01));
	}
}
