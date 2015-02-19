package com.epam.natalia_amelina.runner;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import com.epam.natalia_amelina.configuration.Settings;
import com.epam.natalia_amelina.exception.ParserException;
import com.epam.natalia_amelina.util.UserUrl;

public class Runner {
	
	private static final String SUITE_PATH = "Path to the runnable suite = ";
	private static final String URL = "URL of the test site = ";
	
	private String testSuite;
	private String url;
	
	private Runner(String[] args) {
        Settings settings = new Settings();
        CmdLineParser parser = new CmdLineParser(settings);
        try {
            parser.parseArgument(args);
            testSuite = settings.getTestNGPath();
            url = settings.getUrlSite();
            UserUrl.writeUrlToFile(url);
        } catch (CmdLineException e) {
            System.err.println(e.toString());
            parser.printUsage(System.out);
        }
	}
	
	public static void main(String[] args) {
		Runner runner = new Runner(args);
		runner.runTestSuite();
	}
	
	private void runTestSuite() {
		outputStartOptions();
		TestNG testNG = new TestNG();
		XmlSuite suite = null;
		try {
			suite = new Parser(testSuite).parseToList().get(0);
		} catch (Exception e) {
			throw new ParserException(e.getMessage());
		}
		testNG.setCommandLineSuite(suite);
		testNG.run();
	}
	
	private void outputStartOptions() {
        System.out.println(SUITE_PATH + testSuite);
        System.out.println(URL + url);
	}

}
