package com.epam.javaacademy.bookrobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

public class CheckRobotTxt 
{
    public HashSet <String> listOfUnallowedURLs (URL urlToCheck){
    	HashSet <String> unallowedList = new HashSet<>();
    	
    	try {
			String web = urlToCheck.getHost().toLowerCase();
			String line;
			
			URL robots = new URL ("http://" + web + "/robots.txt");
			
			//start the connection, read robots.txt
			BufferedReader reader = new BufferedReader(new InputStreamReader(robots.openStream()));
    		
			while((line = reader.readLine()) != null){
				if (line.contains("Disallow:")){
				
					line = line.substring("Disallow:".length());
					unallowedList.add(line.trim());
				}
			}
    		
    		
		} catch (MalformedURLException e) {
			System.err.println("Problem with URL.");
		} catch (IOException e) {
			System.err.println("Robots.txt not found.");
			return null;
		}
    	
		return unallowedList;
    }



}
