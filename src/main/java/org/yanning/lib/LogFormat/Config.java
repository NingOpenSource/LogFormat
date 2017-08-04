package org.yanning.lib.LogFormat;

/**
 * 默认的配置类，可以更改本类中的信息来修改配置
 * 
 * @author ning
 *
 */
public class Config {
	/**
	 * debug模式下堆栈信息最多打印的层数
	 */
	public static int DEBUG_STACK_STRACE_MAX_DEPTH = 10;
	/**
	 * 默认的tag
	 */
	public static final String TAG_DEFAULT = "LogFormat";
	protected static final String STRING_OBJECT_NULL = "Object[object is null]";
	/**
	 * 默认的分割线宽度
	 */
	public static int DEFAULT_DIVIDER_WIDTH = 50;

	/**
	 * 换行符
	 */
	protected static final String BR = System.getProperty("line.separator");

	/**
	 * 空格
	 */
	protected static final String SPACE = "\t";

	protected static final String BORDER_TOP_LEFT = "╔";
	protected static final String BORDER_BOTTOM_LEFT = "╚";
	protected static final String BORDER_TOP_RIGHT = "╗";
	protected static final String BORDER_BOTTOM_RIGHT = "╝";
	protected static final String BORDER_LEFT_DIVIDER = "╟";
	protected static final String BORDER_RIGHT_DIVIDER = "╢";
	protected static final String BORDER_HORIZONTAL = "═";
	protected static final String BORDER_VERTICAL = "║";
	protected static final String BORDER_HORIZONTAL_DIVIDER = "-";
	protected static final String BORDER_NEXT_LEVEL_LEFT = "└";// └
}
