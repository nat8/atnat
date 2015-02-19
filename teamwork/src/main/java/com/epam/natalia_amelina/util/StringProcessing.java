package com.epam.natalia_amelina.util;

public class StringProcessing {

	private static final String POINT = ".";
	private static final String HYPHEN = " - ";
	
	public static String convertToBrand(String productInfo) {
		int hyphenIndex = productInfo.indexOf(HYPHEN);
		return productInfo.substring(0, hyphenIndex);
	}
	
	public static int convertPriceToInt(String price) {
		int pointIndex = price.indexOf(POINT);
		return Integer.parseInt(price.substring(1, pointIndex));
	}
}
