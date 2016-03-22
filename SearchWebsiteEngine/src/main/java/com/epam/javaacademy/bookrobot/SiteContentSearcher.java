package com.epam.javaacademy.bookrobot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SiteContentSearcher 
{

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
	
	public ArrayList<String> searchOnPublio() throws IOException{
		
		String url = "http://www.publio.pl/szukaj,darmowe.html";
		String marker = "div[class=product-tile-price-wrapper]";
		Document document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
        Elements divElements = document.select(marker);

        ArrayList<String> titleList = new ArrayList<>();
        
        for(Element divElement : divElements){
        	Elements priceElements = divElement.select("ins[class=product-tile-price]");
        	String price = priceElements.html();
        	addTitlesToArray(titleList, divElement, price);
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
        for(Element aElement : aElements){
        	Pattern pricePattern = Pattern.compile("0[,.]00.*");
        	
        	Matcher m = pricePattern.matcher(prices[i].html());
        	
        	if(m.matches()){
        		System.out.println(aElement.html());
        		titleList.add(aElement.html());
        	}
        }
		return titleList;
	}
	
	public ArrayList<String> searchOnVirtualo() throws IOException {
	
		String url = "http://virtualo.pl/darmowe/m6/";
		String marker = "div[class=content]";
		String priceMarker = "div[class=price]";
		ArrayList<String> titleList = new ArrayList<>();
		
		Document document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
        Elements divElements = document.select(marker);
        	
        	for(Element divElement : divElements){
        		Elements priceElements = divElement.select(priceMarker);
        		Element priceElement = priceElements.first();

        		if(priceElement != null) {
        			String price = priceElement.html();
        			
        			Matcher priceMatcher = matchPrice(price);
        			
        			if(priceMatcher.matches()){
        				Elements titleElements = divElement.select("div[class=title]");
        				String title = titleElements.html().split("\n")[0];
        				titleList.add(title);
	            			
        				System.out.println(title);
        			}
        		}
            	
        	}
        
        return titleList;
	}
   
	private void addTitlesToArray(ArrayList<String> titleList, Element element, String price) {
		Matcher m = matchPrice(price);

		if(m.matches()){
			Elements titleElements = element.select("a[title]");
			String title = titleElements.attr("title");
			titleList.add(title);
		}
	}
	
	private Matcher matchPrice(String price) {
		Pattern pricePattern = Pattern.compile("0[,.]00.*");
		Matcher m = pricePattern.matcher(price);
		return m;
	}
}
