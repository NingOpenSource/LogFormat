package org.yanning.lib.LogFormat;

import java.util.ArrayList;

/**
 * 堆栈信息工具类
 * 
 * @author ning
 *
 */
class StackTraceUtils {

	/**
	 * 获取堆栈信息
	 * 
	 * @param maxDepth
	 *            输出日志的深度(大于0)
	 * @return
	 */
	public static String[] getStackTraceInfo(int maxDepth) {
		if (maxDepth < 0) {
			maxDepth = 0;
		}
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		// 注意!这里是下标为2的,而不是为1的
		boolean isReturn = false;
		ArrayList<String> arrayList = new ArrayList<>(maxDepth);
		for (StackTraceElement element : trace) {
			if (isReturn) {
				if (!element.getClassName().equals(LogFormat.class.getName())) {
					if (arrayList.size() < maxDepth) {
						arrayList.add(element.toString());
					} else {
						break;
					}
				}
			}
			if (element.getClassName().equals(LogFormat.class.getName())) {
				isReturn = true;
			}
		}
		String[] ss = new String[arrayList.size()];
		arrayList.toArray(ss);
		return ss;
	}
}
