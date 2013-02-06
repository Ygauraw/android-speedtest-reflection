package se.mobileapplab.speedtest_reflection;

import java.lang.reflect.Field;

public class TestReflection {
	private Field[] _fields;

	public TestReflection() {
		_fields = null;
	}
	
	public int test(Object obj) {
		if (_fields==null) {
			_fields = obj.getClass().getDeclaredFields();
		}
		
		int fooCount = 0;
		for (int i = 0; i<_fields.length; i++) {
			try {
				Object value = _fields[i].get(obj);
				String string = value.toString();
				if (string.length()>0)
					fooCount++;
			}
			catch (IllegalArgumentException e) {
			}
			catch (IllegalAccessException e) {
			}
		}
		return fooCount;
	}
}
