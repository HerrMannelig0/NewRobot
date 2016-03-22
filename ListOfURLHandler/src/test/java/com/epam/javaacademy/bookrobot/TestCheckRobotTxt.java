package com.epam.javaacademy.bookrobot;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCheckRobotTxt 
{

	@BeforeMethod
	public void preparations () throws MalformedURLException{
	}
	
	@Test
	public void testIfCreatesListOfURLs() throws MalformedURLException {
		//given
		CheckRobotTxt mockingObject = Mockito.mock(CheckRobotTxt.class);
		CheckRobotTxt obj = new CheckRobotTxt();
		URL mockedURL = new URL ("http://www.empik.com");
		HashSet <String> expected = new HashSet <String>();
		expected.add("/ajax/");
		expected.add("/personalizacja-dataforce/");
		expected.add("/sysaction/");
		expected.add("/koszyk/");
		expected.add("/logowanie/");
		//when
		HashSet <String> result = obj.listOfUnallowedURLs(mockedURL);

		Assertions.assertThat(result).isEqualTo(expected);
		//pytanie o mockito - jak to działa, skoro mockingObject zwraca false, obj true..? :(
	}
	
}
