package com.epam.natalia_amelina.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserUrl {

	private static final String URL_FILE_PATH = ".\\src\\test\\resources\\url.txt";
	private static final String WRITE_ERROR = "ERROR! Data can't write to the file! \n";
	private static final String READ_ERROR = "ERROR! Data can't read from the file! \n";

	public static void writeUrlToFile(String url) {
		File fileWithArray = new File(URL_FILE_PATH);
		PrintWriter streamForWriteInFile = null;
		try {
			streamForWriteInFile = new PrintWriter(new BufferedWriter(new FileWriter(fileWithArray)));
			streamForWriteInFile.println(url);
		} catch (IOException e) {
			System.err.println(WRITE_ERROR + e);
		} finally {
			streamForWriteInFile.close();
		}
	}
	
	public static String readUrlFromFile() {
		String url = null;
		File fileWithArray = new File(URL_FILE_PATH);
		Scanner streamReadFromFile = null;
		try {
			streamReadFromFile = new Scanner(fileWithArray);
			while(streamReadFromFile.hasNextLine()) {
				url = streamReadFromFile.nextLine();
			}
		} catch (IOException e) {
			System.err.println(READ_ERROR + e);
		} finally {
			streamReadFromFile.close();
		}
		return url;
	}
}
