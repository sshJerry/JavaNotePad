package com.p2;

import java.util.Scanner;
import com.p2.service.ResultService;
import com.main.exception.IllegalMarksExceptions;
import com.main.exception.InvalidMarksException;
import com.main.exception.InvalidTotalMarksException;
public class App {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Marks Scored");
		Double marksScored = sc.nextDouble();
		System.out.println("Enter Total Marks");
		Double totalMarks = sc.nextDouble();
		
		ResultService rservice = new ResultService();
		try {
			double percent = rservice.computePercent(marksScored,totalMarks);
			System.out.println("You Scored: " + percent + "%");
			
			String grade = rservice.computeGrade(percent);
			System.out.println("Grade is: " + grade);
		}
		catch(IllegalMarksExceptions e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidMarksException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidTotalMarksException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Thank you");
		
	}
}