package com.epam.javaacademy.bookrobot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;

public class BooksList implements Serializable{
	
	private Map<String, String> map;
	
	public BooksList(Map<String, String> map){
		
		this.map = map;
	}
	
	public BooksList serialize(URL url) throws IOException{
		FileOutputStream fstream = new FileOutputStream(url.toString());
		ObjectOutputStream oout = new ObjectOutputStream(fstream);
		oout.writeObject(this);
		oout.close();
		fstream.close();
		return this;
	}
	
	public BooksList deSerialize(URL url) throws IOException, ClassNotFoundException{
		FileInputStream fin = new FileInputStream(url.toString());
		ObjectInputStream oin = new ObjectInputStream(fin);
		BooksList booksList = (BooksList) oin.readObject();
		oin.close();
		fin.close();
		return booksList;
	}
	
}
