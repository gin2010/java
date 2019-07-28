package demo14;

import java.lang.reflect.Method;

class MethodTest {
	private final String sayHello(final String name) {
		return "Hello, " + name;
	}
}

public class Test9 {
	public static void main(String args[]) throws Exception {
		MethodTest test = new MethodTest();
		final Method[] methods = test.getClass().getDeclaredMethods();
		for (int i = 0; i < methods.length; ++i) {
			if (methods[i].getName().equals("sayHello")) {
				final Object params[] = { "Ross" };
				
				methods[i].setAccessible(true);
				
				Object ret = methods[i].invoke(test, params);
				System.out.println(ret);
			}
		}
	}
}
