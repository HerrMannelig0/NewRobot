package com.epam.javaacademy.bookrobot;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

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
	
	@Test
	public void testSearchingInSite() throws IOException{
		
		SiteContentSearcher searcher = new SiteContentSearcher();
		String url = "http://www.nexto.pl/ebooki/darmowe_c1219.xml";
		int zero = 0;
		
		List<String> list = searcher.searchInSite(url);
		assertThat(list.size()).isGreaterThan(zero);
	}
	
	
}