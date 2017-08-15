package org.yanning.lib.LogFormat;

import static org.yanning.lib.LogFormat.Utils.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日志输出
 * 
 * @author ning
 *
 */
public class LogFormat extends Config{

	public static LogFormat newLog() {
		return new LogFormat();
	}

	public enum Type {
		info, error
	}

	private LogFormat() {

	}

	private String tag = "";
	private StringBuffer stringBuffer = new StringBuffer();

	public final LogFormat tag(String tag) {
		this.tag = tag;
		return this;
	}

	public final LogFormat log(Object object) {
		return log(JsonFormat.format(object));
	}

	public final LogFormat logJson(String json) {
		return log(JsonFormat.formatJson(json));
	}

	public final LogFormat log(String log) {
		stringBuffer = new StringBuffer(log);
		return this;
	}

	public final LogFormat addLogJson(String json) {
		return addLog(JsonFormat.formatJson(json));
	}

	public final LogFormat addLog(Object object) {
		return addLog(JsonFormat.format(object));
	}

	public final LogFormat addLog(String log) {
		stringBuffer.append(log);
		return this;
	}

	/**
	 * 输出内容没办法计算汉字的宽度，所有不显示右边的边框
	 * 
	 * @return
	 */
	public final String string() {
		// TODO Auto-generated method stub
		if (tag == null) {
			tag = TAG_DEFAULT;
		}
		tag = tag.replaceAll("\n", " ");
		String[] strings = stringBuffer.toString().split("\n");
		// StringBuffer startSpace=new StringBuffer();
		StringBuffer content = new StringBuffer();
		String timeBar = new SimpleDateFormat("\nyyyy年MM月dd日 HH:mm:ss --> ").format(new Date()) + tag;
		String tagBar = "  " + BORDER_NEXT_LEVEL_LEFT + "---> ";
		/**
		 * 左边的边距
		 */
		String startSpace = String.format("%" + (tagBar.length()) + "s", "");
		/**
		 * 最大宽度
		 */
		int maxWidth = DEFAULT_DIVIDER_WIDTH;
		String[] straceInfo = null;
		{
			/**
			 * 初始化堆栈信息
			 */
			if (DEBUG_STACK_STRACE_MAX_DEPTH < 1) {
				straceInfo = StackTraceUtils.getStackTraceInfo(1);
			} else {
				straceInfo = StackTraceUtils.getStackTraceInfo(DEBUG_STACK_STRACE_MAX_DEPTH);
			}
		}
		{
			/**
			 * 计算最大宽度
			 */
			maxWidth = getMaxLength(strings, straceInfo);
		}
		String topBar = tagBar + BORDER_TOP_LEFT + makeSameString(maxWidth + 5, BORDER_HORIZONTAL) + BORDER_TOP_RIGHT;
		String bottomBar = startSpace + BORDER_BOTTOM_LEFT + makeSameString(maxWidth + 5, BORDER_HORIZONTAL)
				+ BORDER_BOTTOM_RIGHT;
		/**
		 * 加上左边的边框+边距
		 */
		String leftBar = startSpace + BORDER_VERTICAL + " ";
		{
			/**
			 * 添加日志时间
			 */
			content.append(timeBar + "\n");
		}
		{
			/**
			 * 添加日志标识(顶部栏)
			 */
			content.append(topBar + "\n");
		}
		{
			/**
			 * 添加代码索引
			 */
			content.append(mergeStrings(leftBar, "\n", straceInfo));
			content.append(startSpace + BORDER_LEFT_DIVIDER + makeSameString(maxWidth + 5, BORDER_HORIZONTAL_DIVIDER)
					+ BORDER_RIGHT_DIVIDER + "\n");
		}
		{
			/**
			 * 添加主体日志内容
			 */
			content.append(mergeStrings(leftBar, "\n", strings));
		}
		{
			/**
			 * 添加日志底部栏
			 */
			content.append(bottomBar + "\n");
		}
		return content.toString();
	}

	public final void out() {
		out(Type.info);
	}

	public final void out(Type type) {
		switch (type) {
		case error:
			System.err.println(string());
			break;

		default:
			System.out.println(string());
			break;
		}
	}

}
