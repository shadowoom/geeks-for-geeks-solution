package com.datastructure.array;

import java.io.UnsupportedEncodingException;

public class Substring {

	public static boolean isChineseChar(char c) throws UnsupportedEncodingException{
		return String.valueOf(c).getBytes("GBK").length > 1;
	}
	
	public static String substring(String original, int start, int end) throws UnsupportedEncodingException{
		if(original != null && !original.equals("")) {
			original = new String(original.getBytes(), "GBK");
			if(end > 0 && end < original.getBytes().length && start >= 0 && start <= end) {
				StringBuffer buff = new StringBuffer();
				char c;
				int index = 0;
				int startIndex = 0;
				while(index <= start) {
					c = original.charAt(startIndex);
					if(Substring.isChineseChar(c)) {
						index += 2;
						startIndex ++;
					}
					else {
						index += 1;
						startIndex ++;
					}
				}
				
				for(int i = startIndex - 1; i < end; i++) {
					c= original.charAt(i);
					buff.append(c);
					if(Substring.isChineseChar(c)) {
						--end;
					}
				}
				return buff.toString();
			}
		}
		return original;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "中国abc";
		System.out.println("原始字符串: " + s);
		try {
			System.out.println(Substring.substring(s, 4, 5));
		}
		catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
