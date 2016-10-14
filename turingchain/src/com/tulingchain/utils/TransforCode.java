package com.tulingchain.utils;

public class TransforCode {

	public static void main(String[] args) {
		String s = "简介";
		String tt = chinese2Encoding(s); // String tt1 = "你好，我想给你说一个事情";
		System.out.println(tt);
		System.out.println(unicode2Chinese("\\u7b80\\u4ecb")); // System.out.println(decodeUnicode(tt1));
		String s1 = "\u7b80\u4ecb";
		System.out.println(s.indexOf("\\"));
	}

	public static String chinese2Encoding(final String gbString) {
		char[] utfBytes = gbString.toCharArray();
		String unicodeBytes = "";
		for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
			String hexB = Integer.toHexString(utfBytes[byteIndex]);
			if (hexB.length() <= 2) {
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		System.out.println("unicodeBytes is: " + unicodeBytes);
		return unicodeBytes;
	}

	public static String unicode2Chinese(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			end = dataStr.indexOf("\\u", start + 2);
			String charStr = "";
			if (end == -1) {
				charStr = dataStr.substring(start + 2, dataStr.length());
			} else {
				charStr = dataStr.substring(start + 2, end);
			}
			char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
			buffer.append(new Character(letter).toString());
			start = end;
		}
		return buffer.toString();
	}
}
