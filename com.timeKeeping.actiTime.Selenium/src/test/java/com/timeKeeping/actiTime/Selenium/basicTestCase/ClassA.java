package com.timeKeeping.actiTime.Selenium.basicTestCase;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.timeKeeping.actiTime.Selenium.genericUtility.BaseClass3;

public class ClassA extends BaseClass3{
	
	@Test
	public void demo1()
	{
		System.out.println("From demo 1");
		Reporter.log("log from demo 1", false);
	}
	
	@Test
	public void demo2()
	{
		System.out.println("From demo 2");
		Reporter.log("log from demo 2", true);
	}
	
	@Test
	public void demo3()
	{
		System.out.println("From demo 3");
	}

}
