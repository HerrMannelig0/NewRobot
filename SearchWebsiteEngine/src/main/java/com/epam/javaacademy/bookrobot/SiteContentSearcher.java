package com.epam.javaacademy.bookrobot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SiteContentSearcher 
{

	public ArrayList<String> searchOnSite() throws IOException {

		String url = "https://www.waterstones.com/";
		String atribute = "alt";
		
        Elements elements = getElementsFromSite(url, "img");
        Element[] elementTable = createElementsTable(elements);
        
        return createBooksList(elementTable, atribute);
        
	}

	private Element[] createElementsTable(Elements elements) {
		int size = elements.size();
        
        Object [] objectsElementsTable = elements.toArray();
        Element [] elementTable = new Element[size];
        for(int i=0; i<size; i++){
            elementTable[i] = (Element) objectsElementsTable[i];
        }

		return elementTable;
	}

	public ArrayList<String> searchOnNEXTO() throws IOException{
		String url = "http://www.publio.pl/szukaj,darmowe.html";
		String marker = "h3";
		Elements elements = getElementsFromSite(url, marker);
		Element[] elementTable = createElementsTable(elements);
		ArrayList<String> list = createBooksList(elementTable, "title");
		return list;
	}
	
	private ArrayList<String> createBooksList(Element[] elementTable, String attribute) {
		int size = elementTable.length;
		ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<size; i++){
            if(!elementTable[i].attr(attribute).equals("")){
                String bookName = elementTable[i].attr(attribute);
                list.add(bookName);
                System.out.println(i+"\t"+bookName);
            }
        }
		return list;
	}

	public boolean isMarkerFound(String htmlAdress, String marker){
		String url = htmlAdress;
		Document document = null;
		try {
			document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements elements = document.select(marker);
		if(elements.size()>0) return true;
		return false;
	}
	
	private Elements getElementsFromSite(String url, String marker) throws IOException {
		Document document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
        Elements elements = document.select(marker);
		return elements;
	}

	public ArrayList<String> searchOnPublio() throws IOException{
		
		String url = "http://www.publio.pl/szukaj,darmowe.html";
		String marker = "div[class=product-tile-price-wrapper]";
		Document document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
        Elements divElements = document.select(marker);

        ArrayList<String> titleList = new ArrayList<>();
        
        for(Element e : divElements){
        	Elements priceElements = e.select("ins[class=product-tile-price]");
        	String price = priceElements.html();
        	Pattern pricePattern = Pattern.compile("0[,.]00.*");
        	Matcher m = pricePattern.matcher(price);
        	if(m.matches()){
        		Elements titleElements = e.select("a[title]");
        		String title = titleElements.attr("title");
        		titleList.add(title);
        	}
        }
        
        for (String i : titleList){
        	System.out.println(i);
        }
        
        return titleList; 
	}
	
	public ArrayList<String> searchOnNexto() throws IOException {
		
		String url = "http://www.nexto.pl/ebooki/darmowe_c1219.xml";
		String marker = "a[class=title]";
		String priceMarker = "strong[class=nprice]";
		ArrayList<String> titleList = new ArrayList<>();
		
		Document document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
        Elements aElements = document.select(marker);
        Elements priceElements = document.select(priceMarker);
        
        Element [] prices = new Element[priceElements.size()]; 
        priceElements.toArray(prices);
        
        int i = 0;
        for(Element e : aElements){
        	Pattern pricePattern = Pattern.compile("0[,.]00.*");
        	Matcher m = pricePattern.matcher(prices[i].html());
        	if(m.matches()){
        		System.out.println(e.html());
        		titleList.add(e.html());
        	}
        }
        
		return titleList;
	}
	
	
}
