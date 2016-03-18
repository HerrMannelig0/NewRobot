package com.epam.javaacademy.bookrobot;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

public class TestOfSiteContentSearcher {
	
	@Test
	public void testIfCanFindBodyTagInBlankSite(){
		//given
		String htmlAdress = "http://www.blankwebsite.com/";
		String marker = "<body>";
		SiteContentSearcher searcher = new SiteContentSearcher();
		//when
	    boolean isFound = searcher.isMarkerFound(htmlAdress);
		//then
	    assertThat(isFound).isTrue();
	}
	
	
	
	
}