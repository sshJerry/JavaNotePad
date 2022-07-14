package com.p2.service;

import com.main.exception.IllegalMarksExceptions;
import com.main.exception.InvalidMarksException;
import com.main.exception.InvalidTotalMarksException;

public class ResultService {
	public double computePercent(Double marksScored, Double totalMarks) 
	throws IllegalMarksExceptions,InvalidMarksException,InvalidTotalMarksException {
		
		if(marksScored>totalMarks)
			throw new IllegalMarksExceptions("MarksScored Cannot be > Total Marks");
		if(marksScored<0)
			throw new InvalidMarksException("Marks Scored Cannot be < 0");
		if(totalMarks<100)
			throw new InvalidTotalMarksException("Total Marks Cannot be < 100");
		double percent = (marksScored / totalMarks)*100;
		return percent;
	}

	public String computeGrade(double percent) {
		if (percent>75)
			return "A";
		if (percent>60)
			return "B";
		if (percent>45)
			return "C";
		return "D";
	}
	
}
