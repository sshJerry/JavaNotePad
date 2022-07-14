package com.main.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.main.exception.MarksException;
import com.main.model.Employee;

public class A {
	private int x;
	private int y;
	public String computeGrade(double percent) {
		if(percent >75)
			return "A";
		if(percent >60)
			return "B";
		if (percent >45)
			return "C";
		return "D";
	}
	public double computePercent(double marks, double total) {
		double percent = (marks * 100) /total;
		return percent;
	}
	public int sum(int x,int y) {
		return x+y;
	}
	public Integer[] sortArray(Integer[] arr, String direction) {
		if(direction.equalsIgnoreCase("ASC")) {
			//sort the array in ASC ORDER
			Arrays.sort(arr);
			return arr;
		}
		if(direction.equalsIgnoreCase("DESC")) {
			//sort the array in ADEC ORDER
			Arrays.sort(arr, Collections.reverseOrder());
			return arr;
		}
		return arr;
	}
	
	public List<Integer> filterList(List<Integer> list, String filter) {
		List <Integer> tempList =new ArrayList<>();
		if (filter.equalsIgnoreCase("even")){
			//return the list with only even numbers init 
			for (int e : list) {
				if (e % 2 ==0) {
					tempList.add(e);
				}
			}
			return tempList;
		}
		if (filter.equalsIgnoreCase("odd")){
			//return the list with only odd numbers init 
			for (int e : list) {
				if (e % 2 ==2) {
					tempList.add(e);
				}
			}
			return tempList;
		}
		return list;
	}
	
	public List<Employee> filterEmployeeList(List<Employee> list, double filterSalary, String filter) {
		List<Employee> tempList = new ArrayList<>();
		if(filter.equalsIgnoreCase("less")) {
			for (Employee e:list) {
				if(e.getSalary() < filterSalary) {
					tempList.add(e);
				}
			}
			return tempList;
		}
		if(filter.equalsIgnoreCase("more")) {
			for (Employee e:list) {
				if(e.getSalary() > filterSalary) {
					tempList.add(e);
				}
			}
			return tempList;
		}
		return tempList;
	}
	
	public double computePercentException(double marks, double total) throws MarksException{
		if (marks > total) {
			throw new MarksException("Marks cannot be greater than total");
		}
		if (marks < 0) {
			throw new MarksException("Marks cannot be less than zero");
		}
		if (total==0) {
			throw new ArithmeticException("Divide by zero not allowed");
		}
		double percent = (marks * 100) /total;
		return percent;
	}
	public void doStuff(int x, int y) {
		this.x =++x;
		this.y =++y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
