package com.epam.javaacademy.bookrobot;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static com.epam.javaacademy.bookrobot.SearchingLogger.*;

public class BooksToFileWriter {
	PrintWriter writer;
	
	public BooksToFileWriter() {
		try {
			writer = new PrintWriter("../FoundBooks.txt");
		} catch (FileNotFoundException e) {
			logForImpossibilityToFindTheFileToWriteIn();
			e.printStackTrace();
		}
	}
}
