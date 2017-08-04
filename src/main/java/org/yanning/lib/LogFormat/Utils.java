package org.yanning.lib.LogFormat;

import java.util.ArrayList;
import java.util.Arrays;

class Utils {

	/**
	 * 合并数组
	 * 
	 * @param strings
	 * @return
	 */
	public static final String[] mergeArrays(String[]... strings) {
		ArrayList<String> arrayList = new ArrayList<>();
		for (String[] ss : strings) {
			arrayList.addAll(Arrays.asList(ss));
		}
		String[] strings2 = new String[arrayList.size()];
		arrayList.toArray(strings2);
		return strings2;
	}
	

	/**
	 * 创建指定数量的字符
	 * 
	 * @param count
	 * @param string
	 * @return
	 */
	public static final String makeSameString(int count, String string) {
		if (string == null) {
			string = "";
		}
		if (count <= 0) {
			count = 1;
		}
		return String.format("%" + count + "s", "").replaceAll(" ", string);
	}
	
/**
 * 
 * @param leftBar
 * @param contents
 * @return
 */
	public static final String mergeStrings(String startString,String endString,String... strings) {
		StringBuffer content = new StringBuffer();
		for (String s : strings) {
			content.append(startString + s + endString);
		}
		return content.toString();
	}

	/**
	 * 获取字符串的最大长度
	 * 
	 * @param strings
	 * @return
	 */
	public static final int getMaxLength(String... strings) {
		int maxLength = 0;
		for (String s : strings) {
			if (maxLength < s.length()) {
				maxLength = s.length();
			}
		}
		return maxLength;
	}

	/**
	 * 获取字符串的最大长度
	 * 
	 * @param strings
	 * @return
	 */
	public static final int getMaxLength(String[]... strings) {
		int maxLength = 0;
		for (String[] s : strings) {
			int max = getMaxLength(s);
			if (maxLength < max) {
				maxLength = max;
			}
		}
		return maxLength;
	}

}
