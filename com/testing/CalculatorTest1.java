package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest1 {
	
	int a, b, expRes;
	static Calculator c;

	@BeforeAll
	static void getObject() {
		c = new Calculator();
	}
	
	@BeforeEach
	void setValues() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a: ");
		a = sc.nextInt();
		System.out.println("Enter b: ");
		b = sc.nextInt();
		System.out.println("Enter expected result:");
		expRes = sc.nextInt();
	}
	
	@Test
	void testAdd() {
		int actualRes = c.add(a,b);
		assertEquals(expRes, actualRes, "Test case failed!");
	}
	
	@Test
	void testSub() {
		int actualRes = c.sub(a, b);
		assertEquals(expRes, actualRes, "Test case failed");
	}

	@Test
	void testMul() {
		int actualRes = c.mul(a,b);
		assertEquals(expRes, actualRes);
	}

	@Test
	void testDiv() {
		int actualRes = c.div(a,b);
		assertEquals(expRes, actualRes);
	}
}
