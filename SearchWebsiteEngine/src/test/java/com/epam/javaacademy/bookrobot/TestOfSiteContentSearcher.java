package com.epam.javaacademy.bookrobot;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestOfSiteContentSearcher {
	
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
	
	/*@Test
	public void testGettingArrayListofBooksFromNexto() throws IOException{
		SiteContentSearcher searcher = new SiteContentSearcher();
		int zero = 0;
		List<String> bookList = searcher.searchOnNexto();
		assertThat(bookList.size()).isGreaterThan(zero);
	}
	
	@Test
	public void testGettingArrayListofBooksFromPublio() throws IOException{
		SiteContentSearcher searcher = new SiteContentSearcher();
		int zero = 0;
		List<String> bookList = searcher.searchOnPublio();
		assertThat(bookList.size()).isGreaterThan(zero);
	}
	
	@Test
	public void testGettingArrayListofBooksFromVirtualo() throws IOException{
		SiteContentSearcher searcher = new SiteContentSearcher();
		int zero = 0;
		List<String> bookList = searcher.searchOnVirtualo();
		assertThat(bookList.size()).isGreaterThan(zero);
	}*/
	
}