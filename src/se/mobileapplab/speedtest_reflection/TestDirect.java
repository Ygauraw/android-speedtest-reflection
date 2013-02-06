package se.mobileapplab.speedtest_reflection;

public class TestDirect {
	public TestDirect() {
	}
	
	public int test(Item obj) {
		// Yes, a stupid loop and switch statement, but I want to create code that is similar
		// to my other test cases where I iterated through all members.
		int fooCount = 0;
		for (int i = 0; i<5; i++) {
			String string;
			switch (i) {
			case 0:
				string = obj.name;
				break;
			case 1:
				string = obj.description;
				break;
			case 2:
				string = Integer.toString(obj.category);
				break;
			case 3:
				string = Double.toString(obj.value);
				break;
			case 4:
				string = Boolean.toString(obj.active);
				break;
			default:
				string = "";
				break;
			}
			if (string.length()>0)
				fooCount++;
		}
		return fooCount;
	}
}
