package com.epam.javaacademy.bookrobot;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.UnsupportedMimeTypeException;
import org.testng.annotations.Test;


public class TestOfSiteContentSearcher {
	
	SiteContentSearcher searcher = new SiteContentSearcher();
	
	@Test
	public void testIfCanFindBodyTagInBlankSite(){
		//given
		String htmlAdress = "http://www.blankwebsite.com/";
		String marker = "body";
		SiteContentSearcher searcher = new SiteContentSearcher();
		//when
	    boolean isFound = searcher.isMarkerFound(htmlAdress, marker);
		//then
	    assertThat(isFound).isTrue();
	}
	
	@Test
	public void testSearchingInSite() throws IOException{
		
		String url = "http://www.nexto.pl/ebooki/darmowe_c1219.xml";
		int zero = 0;
		
		List<String> list = searcher.searchInSite(url);
		assertThat(list.size()).isGreaterThan(zero);
	}
	
	@Test (expectedExceptions = UnsupportedMimeTypeException.class)
	public void testForUnsuportedMimeTypeExceptionWhenBooksInSiteSearching() throws IOException {
		String url = "http://tools.nexto.pl/svgconverter?in=/svg/nexto/left_title.svg&amp";

		searcher.searchOnNexto(url);
	}
	
	@Test
	public void testIfSearcherCreatesNewSitesMap() throws IOException {
		
		CompleteListOfURLs urls = mock(CompleteListOfURLs.class);
		
		String urlToCheck = "http://www.nexto.pl/ebooki/darmowe_c1219.xml";
		Map <URL, ArrayList<String>> mapOfURLs = new HashMap<>();
		ArrayList<String> oneURLList =  new ArrayList<>();
		URL url = new URL("http://www.nexto.pl/");
		
		oneURLList.add(urlToCheck);
		mapOfURLs.put(url, oneURLList);
	
		when(urls.createMap()).thenReturn(mapOfURLs);
		
		searcher.searchAllSitesForBooks(urls);
		
		verify(urls).createMap();
	}
	
	@Test
	public void testSearchingOnPublio() throws IOException {
		int zero = 0;
		String urlToCheck = "http://www.publio.pl/szukaj,darmowe.html";
		ArrayList<String> list = searcher.searchOnPublio(urlToCheck);
		assertThat(list.size()).isGreaterThan(zero);
	}
	
	@Test
	public void testSearchingOnNexto() throws IOException {
		int zero = 0;
		String urlToCheck = "http://www.nexto.pl/ebooki/darmowe_c1219.xml";
		ArrayList<String> list = searcher.searchOnNexto(urlToCheck);
		assertThat(list.size()).isGreaterThan(zero);
	}
	
	@Test
	public void testSearchingOnVirtualo() throws IOException {
		int zero = 0;
		String urlToCheck = "http://virtualo.pl/darmowe/m6/";
		ArrayList<String> list = searcher.searchOnVirtualo(urlToCheck);
		assertThat(list.size()).isGreaterThan(zero);
	}
	
}