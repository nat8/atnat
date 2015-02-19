package com.epam.natalia_amelina.configuration;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.kohsuke.args4j.Option;

public class Settings {

	@Option(name = "--testng", usage = "Path to test suite", required = true)
	private String testNGPath;
	
	@Option(name = "--url", usage = "URL to the test site", required = true)
	private String urlSite;
	
	public String getTestNGPath() {
		return testNGPath;
	}
	
	public String getUrlSite() {
		return urlSite;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle
															.SIMPLE_STYLE);
	}
	
}
