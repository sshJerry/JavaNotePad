package com.main;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest {
	@BeforeClass // This executes only once before all test cases
	public static void beforeClass() {System.out.println("Before class");}
	@Before //this executes before every test case
	public void init() {System.out.println("Init");}
	@Test
	public void test1() {System.out.println("Test-1");}
	@Test
	public void test2() {System.out.println("Test-2");}
	@After//this executes after every test case
	public void after() {System.out.println("After");}
	@AfterClass // This executes only once after all test cases
	public static void afterClass() {System.out.println("After Class");}
}
