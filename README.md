# 日志格式化输出工具
[![](https://jitpack.io/v/NingOpenSource/LogFormat.svg)](https://jitpack.io/#NingOpenSource/LogFormat)

## 例子
```java
package example;
import java.util.HashMap;
import java.util.Map;

import org.yanning.lib.LogFormat.LogFormat;

public class LogTest {
	static class Test extends Test1 {
		private String _testName;
		private int count;

		public Test(String _testName, int count) {
			super();
			this._testName = _testName;
			this.count = count;
		}

	}

	public static class Test1 {
		private String _testName0 = "2342";
		private int count0 = 4343;

	}

	public static void main(String[] args) {
		{
			/**
			 * config
			 */
			LogFormat.DEBUG_STACK_STRACE_MAX_DEPTH=5;
			LogFormat.DEFAULT_DIVIDER_WIDTH=50;
			
		}
		Map<String, String> map = new HashMap<>();
		map.put("2321", "sdasas");
		map.put("212132131", "dasvrtefvef");
		map.put("233221", "sdasas");
		map.put("212343132131", "dasvrtefvef");
		map.put("23232421", "sdasas");
		map.put("212145432131", "dasvrtefvef");
		map.put("236721", "sdasas");
		map.put("212432132131", "dasvrtefvef");
		map.put("232443621", "sdasas");
		map.put("212234365132131", "dasvrtefvef");
		map.put("236768721", "sdasas");
		map.put("21682132131", "dasvrtefvef");
		map.put("235435321", "sdasas");
		map.put("217872132131", "dasvrtefvef");
		LogFormat.newLog().tag("Object").log(new Test("哈哈哈", 20)).out();
		LogFormat.newLog().tag("map").log(map).out();
		LogFormat.newLog().tag("jius\nsduas").log("hahaha\nsgydgsytdgs  ").out();
		test();
		// System.err.println(String.format("%4s", "+").replaceAll(" ", "+"));
	}

	private static void test() {
		LogFormat.newLog().tag("map").logJson("{\"_testName\":\"哈哈哈\",\"count\":20}").out();
	}
}

```
输出结果：
```log

2017年08月15日 09:46:37 --> Object
  └---> ╔══════════════════════════════════════════╗
        ║ example.LogTest.main(LogTest.java:50)
        ╟------------------------------------------╢
        ║ {
        ║   "_testName": "哈哈哈",
        ║   "count": 20,
        ║   "_testName0": "2342",
        ║   "count0": 4343
        ║ }
        ╚══════════════════════════════════════════╝


2017年08月15日 09:46:37 --> map
  └---> ╔══════════════════════════════════════════╗
        ║ example.LogTest.main(LogTest.java:51)
        ╟------------------------------------------╢
        ║ {
        ║   "212132131": "dasvrtefvef",
        ║   "236768721": "sdasas",
        ║   "233221": "sdasas",
        ║   "212145432131": "dasvrtefvef",
        ║   "217872132131": "dasvrtefvef",
        ║   "212343132131": "dasvrtefvef",
        ║   "212234365132131": "dasvrtefvef",
        ║   "212432132131": "dasvrtefvef",
        ║   "23232421": "sdasas",
        ║   "232443621": "sdasas",
        ║   "21682132131": "dasvrtefvef",
        ║   "2321": "sdasas",
        ║   "235435321": "sdasas",
        ║   "236721": "sdasas"
        ║ }
        ╚══════════════════════════════════════════╝


2017年08月15日 09:46:37 --> jius sduas
  └---> ╔══════════════════════════════════════════╗
        ║ example.LogTest.main(LogTest.java:52)
        ╟------------------------------------------╢
        ║ hahaha
        ║ sgydgsytdgs  
        ╚══════════════════════════════════════════╝


2017年08月15日 09:46:37 --> map
  └---> ╔══════════════════════════════════════════╗
        ║ example.LogTest.test(LogTest.java:58)
        ║ example.LogTest.main(LogTest.java:53)
        ╟------------------------------------------╢
        ║ {
        ║   "_testName": "哈哈哈",
        ║   "count": 20
        ║ }
        ╚══════════════════════════════════════════╝


```
