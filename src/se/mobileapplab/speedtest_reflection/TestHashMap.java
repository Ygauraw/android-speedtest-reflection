package se.mobileapplab.speedtest_reflection;

import java.util.HashMap;

public class TestHashMap {
	public TestHashMap() {
	}
	
	public int test(HashMap<String, Object> obj) {
		int fooCount = 0;
		for (String key : obj.keySet()) {
			Object value = obj.get(key);
			String string = value.toString();
			if (string.length()>0)
				fooCount++;
		}
		return fooCount;
	}
}
