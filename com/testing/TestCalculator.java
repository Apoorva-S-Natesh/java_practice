package com.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalculator {

	//Pre-test every time we run the application, testcase before any other testcase
	@BeforeAll
	static void testNetwork() {
		System.out.println("Netwok testing");
	}
	
	@AfterAll //Tested after all the tests are tested
	static void testNetwork2() {
		System.out.println("After all tests");
	}
	
	@BeforeEach //When a test has to be run before every other test
	void testData() {
		System.out.println("data testing");
	}
	
	@AfterEach //Tested after each test case
	void memoryTest() {
		System.out.println("Memory testing");
	}

	@Test //Which ever test we want to run
	void test1() {
		System.out.println("Test1");
	}
	
	@Test
	void test2() {
		System.out.println("Test2");
	}
	
	void test3() {
		System.out.println("Test3");
	}
}
